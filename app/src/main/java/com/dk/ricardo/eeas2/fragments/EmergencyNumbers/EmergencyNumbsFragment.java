package com.dk.ricardo.eeas2.fragments.EmergencyNumbers;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dk.ricardo.eeas2.Adapters.RecyclerAdapter;
import com.dk.ricardo.eeas2.R;
import com.dk.ricardo.eeas2.utilidades.ItemData;

public class EmergencyNumbsFragment extends Fragment {

    RecyclerView recyclerView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_emergency_numbs, container, false);

        recyclerView=view.findViewById(R.id.recyclerEmergency);
        ItemData itemData[] ={
                new ItemData("Numero 1",R.drawable.ic_afuera),
                new ItemData("Numero 2",R.drawable.ic_afuera),
                new ItemData("Numero 3",R.drawable.ic_afuera),
                new ItemData("Numero 4",R.drawable.ic_afuera),
                new ItemData("Numero 5",R.drawable.ic_afuera),
                new ItemData("Numero 6",R.drawable.ic_afuera),
                new ItemData("Numero 7",R.drawable.ic_afuera),
                new ItemData("Numero 8",R.drawable.ic_afuera)
        };
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(itemData);

        recyclerView.setAdapter(recyclerAdapter);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return view;
    }

}
