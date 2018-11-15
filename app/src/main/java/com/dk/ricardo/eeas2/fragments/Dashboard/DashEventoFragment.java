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
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;


public class DashEventoFragment extends Fragment {

    PieChart chart,pieChart1;
    BarChart barChart;
    TextView regTaller,masTaller,tallerxPer, tiempoReg, dispReg;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dash_evento, container, false);

        chart=view.findViewById(R.id.chartprueba);
        barChart=view.findViewById(R.id.barChart);
        regTaller=view.findViewById(R.id.regTaller);
        masTaller=view.findViewById(R.id.masTaller);
        tallerxPer=view.findViewById(R.id.tallerXPer);
        tiempoReg=view.findViewById(R.id.tiempoReg);
        dispReg=view.findViewById(R.id.dispReg);



        List<PieEntry> entries = new ArrayList<>();

        entries.add(new PieEntry(49.0f, "Dentro"));
        entries.add(new PieEntry(51.0f, "Fuera"));


        PieDataSet set = new PieDataSet(entries, "Personas");
        PieData data = new PieData(set);
        chart.setData(data);
        chart.invalidate(); // refresh

        //----------------------------------------------------------------



        //---------------------------------------------------------------



        return view;
    }

}
