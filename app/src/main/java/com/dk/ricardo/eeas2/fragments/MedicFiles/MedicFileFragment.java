package com.dk.ricardo.eeas2.fragments.MedicFiles;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.dk.ricardo.eeas2.R;

public class MedicFileFragment extends Fragment {

    ViewPager pagerMedic;
    ViewPagerAdapter adapterMedic;
    TabLayout tabsMedic;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_medic_file, container, false);

        pagerMedic=view.findViewById(R.id.pagerMedic);


        tabsMedic=view.findViewById(R.id.TablaMedic);
        adapterMedic= new ViewPagerAdapter(getActivity().getSupportFragmentManager(),3);

        pagerMedic.setAdapter(adapterMedic);

        tabsMedic.setupWithViewPager(pagerMedic);
        tabsMedic.setTabMode(TabLayout.MODE_FIXED);

        tabsMedic.getTabAt(0).setCustomView(itemView("Buscar"));
        tabsMedic.getTabAt(1).setCustomView(itemView("Mostrar"));
        tabsMedic.getTabAt(2).setCustomView(itemView("Localizacion"));

        return view;
    }
    public View itemView(String name)
    {
        View tabView = View.inflate(getActivity(),R.layout.tablayout,null);
        TextView tvTab = tabView.findViewById(R.id.tabText);
        tvTab.setText(name);
        return tabView;
    }

}
