package com.dk.ricardo.eeas2.fragments.ControlPanel;

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


public class ControlFragment extends Fragment {

    ViewPager pagerControl;
    ViewPagerAdapter adapterControl;
    TabLayout tabsControl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_control, container, false);

        pagerControl=view.findViewById(R.id.pagerControl);


        tabsControl=view.findViewById(R.id.TablaControl);
        adapterControl= new ViewPagerAdapter(getActivity().getSupportFragmentManager(),4);

        pagerControl.setAdapter(adapterControl);

        tabsControl.setupWithViewPager(pagerControl);
        tabsControl.setTabMode(TabLayout.MODE_SCROLLABLE);

        tabsControl.getTabAt(0).setCustomView(itemView("Actividades"));
        tabsControl.getTabAt(1).setCustomView(itemView("Organizadores"));
        tabsControl.getTabAt(2).setCustomView(itemView("Staff"));
        tabsControl.getTabAt(3).setCustomView(itemView("Asistentes"));
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
