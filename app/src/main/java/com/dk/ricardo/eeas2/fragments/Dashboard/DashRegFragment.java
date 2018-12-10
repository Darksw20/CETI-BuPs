package com.dk.ricardo.eeas2.fragments.Dashboard;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
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
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DashRegFragment extends Fragment implements Response.Listener<JSONObject>,Response.ErrorListener
{
    PieChart chart,pieChart1;
    BarChart barChart;
    TextView regTaller,masTaller,tallerxPer, tiempoReg, dispReg;


    public DashRegFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dash_reg, container, false);

        chart=view.findViewById(R.id.chart);
        pieChart1=view.findViewById(R.id.pieChart1);
        barChart=view.findViewById(R.id.barChart);
        regTaller=view.findViewById(R.id.regTaller);
        masTaller=view.findViewById(R.id.masTaller);
        tallerxPer=view.findViewById(R.id.tallerXPer);
        tiempoReg=view.findViewById(R.id.tiempoReg);
        dispReg=view.findViewById(R.id.dispReg);

        cargarWebServiceData("getDataReg.php");

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
    public void onErrorResponse(VolleyError error) {
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

                    int regTaller1=response.getInt("regTalleresConc");
                    int masTaller1=response.getInt("masTaller");
                    double dentro=response.getDouble("regPagados");
                    double afuera=response.getDouble("regPreReg");
                    double tallerxpers=response.getDouble("tallerxPer");
                    double entre=response.getInt("kitEntre");
                    double exist=response.getInt("kitExist");


                    String a = Double.toString(tallerxpers);
                    String time=response.getString("regAct"),
                            disp=String.valueOf(response.getInt("dispoReg"));

                    tiempoReg.setText(time);
                    dispReg.setText(disp);
                    regTaller.setText(String.valueOf(regTaller1));
                    masTaller.setText(String.valueOf(masTaller1));
                    tallerxPer.setText(a);


                    List<PieEntry> entries = new ArrayList<>();
                    List<PieEntry> entries1 = new ArrayList<>();
                    List<BarEntry> entries2 = new ArrayList<>();
                    JSONArray jsonArray = response.getJSONArray("asistProv");

                    entries.add(new PieEntry((float) dentro, "Pagados"));
                    entries.add(new PieEntry((float) afuera, "PreRegistrados"));
                    entries1.add(new PieEntry((float) entre, "Entregados"));
                    entries1.add(new PieEntry((float) exist, "Existentes"));
                    for (int i=0; i<jsonArray.length(); i++) {
                        entries2.add(new BarEntry((float)0+i,(float) jsonArray.getInt(i)));
                    }

                    PieDataSet set = new PieDataSet(entries, "Personas");
                    PieDataSet set1 = new PieDataSet(entries1, "Kits");
                    BarDataSet set2 = new BarDataSet(entries2, "Personas");

                    PieData data = new PieData(set);
                    PieData data1 = new PieData(set1);
                    BarData data2 = new BarData(set2);

                    set.setColors(new int[] { R.color.colorAccent, R.color.green},getContext());
                    set1.setColors(new int[] { R.color.colorAccent, R.color.green},getContext());
                    set2.setColors(new int[] { R.color.colorAccent, R.color.green},getContext());

                    chart.setData(data);
                    chart.invalidate(); // refresh
                    pieChart1.setData(data1);
                    pieChart1.invalidate(); // refresh
                    barChart.setData(data2);
                    barChart.invalidate(); // refresh

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
            tiempoReg.setText(R.string.Recharge);
            dispReg.setText(R.string.Recharge);
            regTaller.setText(R.string.Recharge);
            masTaller.setText(R.string.Recharge);
            tallerxPer.setText(R.string.Recharge);


            List<PieEntry> entries = new ArrayList<>();

            entries.add(new PieEntry(49.0f, "Dentro"));
            entries.add(new PieEntry(51.0f, "Fuera"));


            PieDataSet set = new PieDataSet(entries, "Personas");
            PieData data = new PieData(set);
            chart.setData(data);
            chart.invalidate(); // refresh

            //----------------------------------------------------------------

            List<PieEntry> entries1 = new ArrayList<>();

            entries1.add(new PieEntry(30.0f, "Dentro"));
            entries1.add(new PieEntry(70.0f, "Fuera"));


            PieDataSet set1 = new PieDataSet(entries1, "Personas");
            PieData data1 = new PieData(set1);

            pieChart1.setData(data1);
            pieChart1.invalidate(); // refresh

            //---------------------------------------------------------------

            List<BarEntry> entries2 = new ArrayList<>();

            entries2.add(new BarEntry(45.2f,12.1f));
            entries2.add(new BarEntry(51.0f, 13.4f));


            BarDataSet set2 = new BarDataSet(entries2, "Personas");
            BarData data2 = new BarData(set2);
            barChart.setData(data2);
            barChart.invalidate(); // refresh
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
