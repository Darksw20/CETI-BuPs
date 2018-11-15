package com.dk.ricardo.eeas2.fragments.Comunication;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.dk.ricardo.eeas2.R;

public class ComunicationFragment extends Fragment {

    ViewPager pagerComunication;
    ViewPagerAdapter adapterComunication;
    TabLayout tabsComunication;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_comunication, container, false);

        pagerComunication=view.findViewById(R.id.pagerComunication);


        tabsComunication=view.findViewById(R.id.TablaComunication);
        adapterComunication= new ViewPagerAdapter(getActivity().getSupportFragmentManager(),5);

        pagerComunication.setAdapter(adapterComunication);

        tabsComunication.setupWithViewPager(pagerComunication);
        tabsComunication.setTabMode(TabLayout.MODE_SCROLLABLE);

        tabsComunication.getTabAt(0).setCustomView(itemView("Bienvenida"));
        tabsComunication.getTabAt(1).setCustomView(itemView("Reglas"));
        tabsComunication.getTabAt(2).setCustomView(itemView("Noticias"));
        tabsComunication.getTabAt(3).setCustomView(itemView("Camp Life"));
        tabsComunication.getTabAt(4).setCustomView(itemView("Evaluacion"));



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
