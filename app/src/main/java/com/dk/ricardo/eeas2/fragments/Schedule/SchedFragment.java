package com.dk.ricardo.eeas2.fragments.Schedule;

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

public class SchedFragment extends Fragment {

    ViewPager pagerSched;
    ViewPagerAdapter adapterSched;
    TabLayout tabsSched;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sched, container, false);
        pagerSched=view.findViewById(R.id.pagerSched);


        tabsSched=view.findViewById(R.id.TablaSched);
        adapterSched= new ViewPagerAdapter(getActivity().getSupportFragmentManager(),3);

        pagerSched.setAdapter(adapterSched);

        tabsSched.setupWithViewPager(pagerSched);
        tabsSched.setTabMode(TabLayout.MODE_FIXED);

        tabsSched.getTabAt(0).setCustomView(itemView("Act in Camp"));
        tabsSched.getTabAt(1).setCustomView(itemView("Actividades"));
        tabsSched.getTabAt(2).setCustomView(itemView("Mis actividades"));

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
