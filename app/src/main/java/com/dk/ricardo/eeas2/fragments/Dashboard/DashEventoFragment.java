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


public class DashEventoFragment extends Fragment implements Response.Listener<JSONObject>,Response.ErrorListener
{

    PieChart chartES;
    TextView Tent,Tsal,Hcont;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dash_evento, container, false);

        chartES=view.findViewById(R.id.chartES);
        Tent=view.findViewById(R.id.TEnt);
        Tsal=view.findViewById(R.id.TSal);
        Hcont=view.findViewById(R.id.HCont);
        cargarWebServiceData("getDataEvent.php");
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms

            }
        }, 500);


        return view;
    }

    private void cargarWebServiceData(String webService)
    {
        String ip= getString(R.string.ip_webServices), url=""+ip+webService;
        final CustomJsonArrayRequest customjsonArrayRequest=new CustomJsonArrayRequest(Request.Method.POST,
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
    public void onResponse(JSONObject response) {
        actData(response);
    }

    private void actData(JSONObject response)
    {
        try {
            int estado=response.getInt("estadoQuery");
            if(estado==200)
            {
                try {

                    int adentro=response.getInt("dentro");
                    int fuera=response.getInt("fuera");
                    int TEntradas=response.getInt("entradasT");
                    int TSalidas=response.getInt("salidasT");
                    String HCont=response.getString("horasT");

                    Tent.setText(String.valueOf(TEntradas));
                    Tsal.setText(String.valueOf(TSalidas));
                    Hcont.setText(String.valueOf(HCont));

                    List<PieEntry> entries = new ArrayList<>();

                    entries.add(new PieEntry((float) adentro, "Adentro"));
                    entries.add(new PieEntry((float) fuera, "Afuera"));

                    PieDataSet set = new PieDataSet(entries, "Personas");

                    PieData data = new PieData(set);

                    set.setColors(new int[] { R.color.colorAccent, R.color.green},getContext());

                    chartES.setData(data);
                    chartES.invalidate(); // refresh

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
        try
        {
            Log.i("Error : ",""+error);
            int adentro=0;
            int fuera=0;
            int TEntradas=0;
            int TSalidas=0;
            String HCont="Error conexion";

            Tent.setText(String.valueOf(TEntradas));
            Tsal.setText(String.valueOf(TSalidas));
            Hcont.setText(String.valueOf(HCont));

            List<PieEntry> entries = new ArrayList<>();

            entries.add(new PieEntry((float) adentro, "Adentro"));
            entries.add(new PieEntry((float) fuera, "Afuera"));

            PieDataSet set = new PieDataSet(entries, "Personas");

            PieData data = new PieData(set);

            set.setColors(new int[] { R.color.colorAccent, R.color.green},getContext());

            chartES.setData(data);
            chartES.invalidate(); // refresh
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
