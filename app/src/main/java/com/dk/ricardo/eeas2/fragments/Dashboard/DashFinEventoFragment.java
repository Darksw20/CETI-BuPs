package com.dk.ricardo.eeas2.fragments.Dashboard;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dk.ricardo.eeas2.R;
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

import java.util.ArrayList;
import java.util.List;

public class DashFinEventoFragment extends Fragment {

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





        //Declaraciones de los Arreglos de los datos

        List<PieEntry> afAdChart = new ArrayList<>();//Personas  afuera vs adentro

        //incidencias

        List<BarEntry> entries2 = new ArrayList<>();//Escala de satisfaccion de los usuarios

        //Gastos de materrial proyectado vs Final
        List<Entry> valsComp1 = new ArrayList<Entry>();//Pensado en un inicio
        List<Entry> valsComp2 = new ArrayList<Entry>();//Real

        List<BarEntry> entries1 = new ArrayList<>();//Evaluacion de los talleres






        //--------------------------------------------------------------



        afAdChart.add(new PieEntry(49.0f, "Dentro"));
        afAdChart.add(new PieEntry(51.0f, "Fuera"));


        PieDataSet setAf = new PieDataSet(afAdChart, "Personas1");
        PieDataSet setAd = new PieDataSet(afAdChart, "Personas2");
        PieData dataAf = new PieData(setAf);
        PieData dataAd = new PieData(setAd);

        arrivals.setData(dataAd);
        arrivals.setData(dataAf);
        arrivals.invalidate(); // refresh
        //----------------------------------------------------------------



        entries2.add(new BarEntry(45.2f,12.1f));
        entries2.add(new BarEntry(51.0f, 13.4f));


        BarDataSet set2 = new BarDataSet(entries2, "Personas");
        BarData data2 = new BarData(set2);
        satisfaccion.setData(data2);
        satisfaccion.invalidate(); // refresh
        //-------------------------------------------------------------


        entries1.add(new BarEntry(45.2f,12.1f));
        entries1.add(new BarEntry(51.0f, 13.4f));


        BarDataSet set1 = new BarDataSet(entries1, "Personas");
        BarData data1 = new BarData(set1);
        evaluacion.setData(data1);
        evaluacion.invalidate(); // refresh
        //-------------------------------------------------------------



        Entry c1e1 = new Entry(0f, 100000f); // 0 == quarter 1
        Entry c1e2 = new Entry(1f, 140000f); // 1 == quarter 2 ...

        valsComp1.add(c1e1);
        valsComp1.add(c1e2);


        Entry c2e1 = new Entry(0f, 130000f); // 0 == quarter 1
        Entry c2e2 = new Entry(1f, 115000f); // 1 == quarter 2 ...

        valsComp2.add(c2e1);
        valsComp2.add(c2e2);

        LineDataSet setComp1 = new LineDataSet(valsComp1, "Company 1");
        LineDataSet setComp2 = new LineDataSet(valsComp2, "Company 2");

        setComp1.setAxisDependency(YAxis.AxisDependency.LEFT);
        setComp2.setAxisDependency(YAxis.AxisDependency.LEFT);

        List<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(setComp1);
        dataSets.add(setComp2);

        LineData data4 = new LineData(dataSets);
        gastos.setData(data4);
        gastos.invalidate(); // refresh

        return view;
    }

}
