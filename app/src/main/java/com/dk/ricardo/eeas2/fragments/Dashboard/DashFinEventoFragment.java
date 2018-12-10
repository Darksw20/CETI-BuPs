package com.dk.ricardo.eeas2.fragments.Dashboard;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.dk.ricardo.eeas2.JavaBeans.Entidades.UserSingleton;
import com.dk.ricardo.eeas2.R;
import com.dk.ricardo.eeas2.utilidades.CustomJsonArrayRequest;
import com.dk.ricardo.eeas2.utilidades.VolleySingletonAdapter;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DashFinEventoFragment extends Fragment implements Response.Listener<JSONObject>,Response.ErrorListener{

    TextView incidencias;
    PieChart arrivals;
    BarChart satisfaccion, evaluacion;
    LineChart gastos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dash_fin_evento, container, false);

        incidencias=view.findViewById(R.id.numIncidencias);
        arrivals=view.findViewById(R.id.chartArrivals);
        satisfaccion=view.findViewById(R.id.satisfaccion);
        evaluacion=view.findViewById(R.id.evaluacionTalleres);
        gastos=view.findViewById(R.id.gastos);

        cargarWebServiceData("getDataEnd.php");

        return view;
    }

    private void cargarWebServiceData(String webService)
    {
        String ip= getString(R.string.ip_webServices), url=""+ip+webService;
        CustomJsonArrayRequest customjsonArrayRequest=new CustomJsonArrayRequest(Request.Method.POST,
                url, null, this,this)
        {
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<>();
                params.put("CUM",UserSingleton.getInstance().getCum());
                params.put("Pass",UserSingleton.getInstance().getPass());
                return params;
            }
        };
        VolleySingletonAdapter.getInstanceVolley(getContext()).addToRequestQueue(customjsonArrayRequest);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
            }
        }, 500);
    }

    @Override
    public void onErrorResponse(VolleyError error)
    {
        dummieData(error);
    }

    @Override
    public void onResponse(JSONObject response)
    {
        actData(response);
    }

    private void actData(JSONObject response)
    {
        try {
            int estado=response.getInt("estadoQuery");
            if(estado==200)
            {
                try {

                    int numInc=response.getInt("numIncidencias");
                    double sinLlegar=response.getDouble("personasSin");
                    double Llego=response.getDouble("personasLle");
                    double gastoProy=response.getDouble("gastoProy");
                    double gastoFin=response.getInt("gastoFinal");

                    incidencias.setText(String.valueOf(numInc));

                    List<PieEntry> afAdChart = new ArrayList<>();//Personas  afuera vs adentro
                    List<Entry> gastoProyectado = new ArrayList<>();//Pensado en un inicio
                    List<Entry> gastoFinal = new ArrayList<>();//Real
                    List<BarEntry> entries = new ArrayList<>();//Satisfaccion
                    List<BarEntry> entries1 = new ArrayList<>();//Evaluacion de los talleres
                    List<ILineDataSet> dataSets = new ArrayList<>();
                    JSONArray escalaSat = response.getJSONArray("escalaSat");//Escala de satisfaccion de los usuarios
                    JSONArray jsonArray =response.getJSONArray("evalTalleres");//Talleres

                    afAdChart.add(new PieEntry((float)sinLlegar, "Sin llegar"));
                    afAdChart.add(new PieEntry((float)Llego, "Llegados"));
                    gastoProyectado.add(new Entry(0f, 0f));
                    gastoProyectado.add(new Entry(1f, (float)gastoProy));
                    gastoFinal.add(new Entry(0f, 0f));
                    gastoFinal.add(new Entry(1f, (float)gastoFin));
                    for (int i=0; i<escalaSat.length(); i++) {
                        entries.add(new BarEntry((float)0+i,(float) escalaSat.getInt(i)));
                    }
                    for (int i=0; i<jsonArray.length(); i++) {
                        entries1.add(new BarEntry((float)0+i,(float) jsonArray.getInt(i)));
                    }



                    PieDataSet setAf = new PieDataSet(afAdChart, "Sin Llegar");
                    PieDataSet setAd = new PieDataSet(afAdChart, "Llegados");
                    BarDataSet set = new BarDataSet(entries, "Satisfaccion");
                    BarDataSet set1 = new BarDataSet(entries1, "Calificacion");
                    LineDataSet setComp1 = new LineDataSet(gastoProyectado, "Proyectado");
                    LineDataSet setComp2 = new LineDataSet(gastoFinal, "Final");

                    setComp1.setAxisDependency(YAxis.AxisDependency.LEFT);
                    setComp2.setAxisDependency(YAxis.AxisDependency.LEFT);
                    setComp1.setCircleColors(new int[] { R.color.colorAccent, R.color.green},getContext());
                    setComp2.setCircleColors(new int[] { R.color.colorAccent, R.color.green},getContext());

                    dataSets.add(setComp1);
                    dataSets.add(setComp2);

                    PieData dataAf = new PieData(setAf);
                    PieData dataAd = new PieData(setAd);
                    BarData data = new BarData(set);
                    BarData data1 = new BarData(set1);
                    LineData data4 = new LineData(dataSets);

                    setAf.setColors(new int[] { R.color.colorAccent, R.color.green},getContext());
                    setAd.setColors(new int[] { R.color.colorAccent, R.color.green},getContext());
                    set.setColors(new int[] { R.color.colorAccent, R.color.green},getContext());
                    set1.setColors(new int[] { R.color.colorAccent, R.color.green},getContext());

                    arrivals.setData(dataAd);
                    arrivals.setData(dataAf);
                    arrivals.invalidate(); // refresh
                    satisfaccion.setData(data);
                    satisfaccion.invalidate(); // refresh
                    evaluacion.setData(data1);
                    evaluacion.invalidate(); // refresh
                    gastos.setData(data4);
                    gastos.invalidate(); // refresh

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }else if(estado==0)
            {
                Log.i("Error permisos","El usuario no debe ver esto");
            }else if(estado==404)
            {
                Log.i("Error datos","No hay que mostrar");
            }else if(estado==420)
            {
                Log.i("Error envio","Se eviaron datos nulos");
            }else
            {
                Log.i("Error","Error desconocido");
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void dummieData(VolleyError error)
    {
        try{
            Log.i("Error : ",""+error);
            int numInc=0;
            double sinLlegar=0;
            double Llego=0;
            double gastoProy=0;
            double gastoFin=0;

            incidencias.setText(String.valueOf(numInc));

            List<PieEntry> afAdChart = new ArrayList<>();//Personas  afuera vs adentro
            List<Entry> valsComp1 = new ArrayList<>();//Pensado en un inicio
            List<Entry> valsComp2 = new ArrayList<>();//Real
            List<BarEntry> entries = new ArrayList<>();//Satisfaccion
            List<BarEntry> entries1 = new ArrayList<>();//Evaluacion de los talleres


            afAdChart.add(new PieEntry((float)sinLlegar, "Sin llegar"));
            afAdChart.add(new PieEntry((float)Llego, "Llegados"));



            PieDataSet setAf = new PieDataSet(afAdChart, "Sin Llegar");
            PieDataSet setAd = new PieDataSet(afAdChart, "Llegados");
            BarDataSet set = new BarDataSet(entries, "Satisfaccion");
            BarDataSet set1 = new BarDataSet(entries1, "Calificacion");

            PieData dataAf = new PieData(setAf);
            PieData dataAd = new PieData(setAd);
            BarData data = new BarData(set);
            BarData data1 = new BarData(set1);

            setAf.setColors(new int[] { R.color.colorAccent, R.color.green},getContext());
            setAd.setColors(new int[] { R.color.colorAccent, R.color.green},getContext());
            set.setColors(new int[] { R.color.colorAccent, R.color.green},getContext());
            set1.setColors(new int[] { R.color.colorAccent, R.color.green},getContext());

            arrivals.setData(dataAd);
            arrivals.setData(dataAf);
            arrivals.invalidate(); // refresh
            satisfaccion.setData(data);
            satisfaccion.invalidate(); // refresh
            evaluacion.setData(data1);
            evaluacion.invalidate(); // refresh

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
