package com.dk.ricardo.eeas2.fragments.Toolbox;

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


public class ToolboxFragment extends Fragment {

    ViewPager pagerTool;
    ViewPagerAdapter adapterTool;
    TabLayout tabsTool;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_toolbox, container, false);
        pagerTool=view.findViewById(R.id.pagerTool);


        tabsTool=view.findViewById(R.id.TablaTool);
        adapterTool= new ViewPagerAdapter(getActivity().getSupportFragmentManager(),5);

        pagerTool.setAdapter(adapterTool);

        tabsTool.setupWithViewPager(pagerTool);
        tabsTool.setTabMode(TabLayout.MODE_SCROLLABLE);

        tabsTool.getTabAt(0).setCustomView(itemView("Registros"));
        tabsTool.getTabAt(1).setCustomView(itemView("Stock"));
        tabsTool.getTabAt(2).setCustomView(itemView("WoCo"));
        tabsTool.getTabAt(3).setCustomView(itemView("Notas"));
        tabsTool.getTabAt(4).setCustomView(itemView("Entradas/salidas"));


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
