package com.dk.ricardo.eeas2.fragments.Contacts;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.dk.ricardo.eeas2.R;

public class ContactsFragment extends Fragment {

    ViewPager pagerContacts;
    ViewPagerAdapter adapterContacts;
    TabLayout tabsContacts;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_contacts, container, false);
        pagerContacts=view.findViewById(R.id.pagerContacts);


        tabsContacts=view.findViewById(R.id.TablaContacts);
        adapterContacts= new ViewPagerAdapter(getActivity().getSupportFragmentManager(),3);

        pagerContacts.setAdapter(adapterContacts);

        tabsContacts.setupWithViewPager(pagerContacts);
        tabsContacts.setTabMode(TabLayout.MODE_FIXED);

        tabsContacts.getTabAt(0).setCustomView(itemView("Info Personal"));
        tabsContacts.getTabAt(1).setCustomView(itemView("Amigos"));
        tabsContacts.getTabAt(2).setCustomView(itemView("Nuevo Amigo"));


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
