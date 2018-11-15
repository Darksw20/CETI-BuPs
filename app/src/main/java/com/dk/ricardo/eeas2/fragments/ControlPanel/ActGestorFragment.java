package com.dk.ricardo.eeas2.fragments.ControlPanel;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dk.ricardo.eeas2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActGestorFragment extends Fragment  {

    RecyclerView actGestor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_act_gestor, container, false);

        actGestor=view.findViewById(R.id.actGestorView);

        actGestor.setLayoutManager(new LinearLayoutManager(getActivity()));



        return view;
    }

}
