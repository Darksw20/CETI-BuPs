package com.dk.ricardo.eeas2.fragments.Dashboard;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import com.dk.ricardo.eeas2.R;



public class DashFragment extends Fragment {

    ViewPager pager;
    ViewPagerAdapter adapter;
    TabLayout tabs;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_dash, container, false);

        pager=view.findViewById(R.id.pagerDash);


        tabs=view.findViewById(R.id.Tablay);
        adapter= new ViewPagerAdapter(getActivity().getSupportFragmentManager());

        pager.setAdapter(adapter);

        tabs.setupWithViewPager(pager);
        tabs.setTabMode(TabLayout.MODE_FIXED);

        try
        {
            tabs.getTabAt(0).setCustomView(itemView("Registros"));
            tabs.getTabAt(1).setCustomView(itemView("Evento"));
            tabs.getTabAt(2).setCustomView(itemView("Fin de Evento"));

        }catch (Exception e)
        {
            e.printStackTrace();
        }

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
