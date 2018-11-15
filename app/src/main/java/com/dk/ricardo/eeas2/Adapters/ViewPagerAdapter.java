package com.dk.ricardo.eeas2.Adapters;

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
import com.dk.ricardo.eeas2.fragments.Toolbox.NotesFragment;
import com.dk.ricardo.eeas2.fragments.Toolbox.RegisterScanFragment;
import com.dk.ricardo.eeas2.fragments.Toolbox.SelectorInOutFragment;
import com.dk.ricardo.eeas2.fragments.Toolbox.StockFragment;
import com.dk.ricardo.eeas2.fragments.Toolbox.WoCoFragment;

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
            case 0: return new WelcomeFragment();
            case 1: return new RulesFragment();
            case 2: return new NewsFragment();
            case 3: return new CampLifeFragment();
            case 4: return new EvaluationFragment();
            case 5: return new PersonalInfoFragment();
            case 6: return new FriendListFragment();
            case 7: return new NewFriendFragment();
            case 8: return new ActGestorFragment();
            case 9: return new OrgGestorFragment();
            case 10: return new StaffGestorFragment();
            case 11: return new AssGestorFragment();
            case 12: return new DashRegFragment();
            case 13: return new DashEventoFragment();
            case 14: return new DashFinEventoFragment();
            case 15: return new CityMapFragment();
            case 16: return new CampMapFragment();
            case 17: return new SearchFragment();
            case 18: return new ShowFragment();
            case 19: return new LocationFragment();
            case 20: return new ActInCampFragment();
            case 21: return new PersonalSchedFragment();
            case 22: return new ActxDayFragment();
            case 23: return new WoCoFragment();
            case 24: return new StockFragment();
            case 25: return new RegisterScanFragment();
            case 26: return new SelectorInOutFragment();
            case 27: return new NotesFragment();

            default: return null;
        }
    }

    @Override
    public int getCount() {
        return 28;
    }
}
