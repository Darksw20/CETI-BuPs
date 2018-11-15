package com.dk.ricardo.eeas2.fragments.Toolbox;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dk.ricardo.eeas2.fragments.Comunication.CampLifeFragment;
import com.dk.ricardo.eeas2.fragments.Comunication.EvaluationFragment;
import com.dk.ricardo.eeas2.fragments.Comunication.NewsFragment;
import com.dk.ricardo.eeas2.fragments.Comunication.RulesFragment;
import com.dk.ricardo.eeas2.fragments.Comunication.WelcomeFragment;
import com.dk.ricardo.eeas2.fragments.Contacts.FriendListFragment;
import com.dk.ricardo.eeas2.fragments.Contacts.NewFriendFragment;
import com.dk.ricardo.eeas2.fragments.Contacts.PersonalInfoFragment;
import com.dk.ricardo.eeas2.fragments.ControlPanel.ActGestorFragment;
import com.dk.ricardo.eeas2.fragments.ControlPanel.AssGestorFragment;
import com.dk.ricardo.eeas2.fragments.ControlPanel.OrgGestorFragment;
import com.dk.ricardo.eeas2.fragments.ControlPanel.StaffGestorFragment;
import com.dk.ricardo.eeas2.fragments.Dashboard.DashEventoFragment;
import com.dk.ricardo.eeas2.fragments.Dashboard.DashFinEventoFragment;
import com.dk.ricardo.eeas2.fragments.Dashboard.DashRegFragment;
import com.dk.ricardo.eeas2.fragments.Maps.CampMapFragment;
import com.dk.ricardo.eeas2.fragments.Maps.CityMapFragment;
import com.dk.ricardo.eeas2.fragments.MedicFiles.LocationFragment;
import com.dk.ricardo.eeas2.fragments.MedicFiles.SearchFragment;
import com.dk.ricardo.eeas2.fragments.MedicFiles.ShowFragment;
import com.dk.ricardo.eeas2.fragments.Schedule.ActInCampFragment;
import com.dk.ricardo.eeas2.fragments.Schedule.ActxDayFragment;
import com.dk.ricardo.eeas2.fragments.Schedule.PersonalSchedFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    int a;
    public ViewPagerAdapter(FragmentManager fm, int i) {
        super(fm);
        a=i;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {

            case 0: return new WoCoFragment();
            case 1: return new StockFragment();
            case 2: return new RegisterScanFragment();
            case 3: return new SelectorInOutFragment();
            case 4: return new NotesFragment();

            default: return null;
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}
