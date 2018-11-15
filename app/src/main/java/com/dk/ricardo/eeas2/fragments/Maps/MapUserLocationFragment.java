package com.dk.ricardo.eeas2.fragments.Maps;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.dk.ricardo.eeas2.R;


public class MapUserLocationFragment extends Fragment {

    ViewPager pagerMap;
    ViewPagerAdapter adapterMap;
    TabLayout tabsMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_map_user_location, container, false);
        pagerMap=view.findViewById(R.id.pagerMap);


        tabsMap=view.findViewById(R.id.TablaMap);
        adapterMap= new ViewPagerAdapter(getActivity().getSupportFragmentManager(),2);

        pagerMap.setAdapter(adapterMap);

        tabsMap.setupWithViewPager(pagerMap);
        tabsMap.setTabMode(TabLayout.MODE_FIXED);


        tabsMap.getTabAt(0).setCustomView(itemView("Ciudad"));
        tabsMap.getTabAt(1).setCustomView(itemView("Campamento"));
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
