package com.dk.ricardo.eeas2.fragments.ControlPanel;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dk.ricardo.eeas2.Adapters.RecyclerAdapter;
import com.dk.ricardo.eeas2.R;
import com.dk.ricardo.eeas2.utilidades.Items.ItemData;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AssGestorFragment extends Fragment  implements RecyclerAdapter.ItemClickListener {

    RecyclerView assGestor;
    RecyclerAdapter recyclerAdapter;
    ArrayList<ItemData> itemData=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ass_gestor, container, false);

        assGestor=view.findViewById(R.id.assGestorView);

        itemData.add(new ItemData("Juan Miguel CUM:JAL0202020202",R.drawable.ic_afuera));

        assGestor.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerAdapter = new RecyclerAdapter(getContext(),itemData);

        recyclerAdapter.setClickListener(this);
        assGestor.setAdapter(recyclerAdapter);

        return view;


    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getContext(), "You clicked " + recyclerAdapter.getItem(position).getTitle().toString() + " on row number " + position, Toast.LENGTH_SHORT).show();
    }

}
