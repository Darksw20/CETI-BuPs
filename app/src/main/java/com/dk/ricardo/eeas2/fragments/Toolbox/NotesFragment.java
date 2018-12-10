package com.dk.ricardo.eeas2.fragments.Toolbox;


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
import com.dk.ricardo.eeas2.interfaces.NavigationHost;
import com.dk.ricardo.eeas2.utilidades.Items.ItemData;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotesFragment extends Fragment implements RecyclerAdapter.ItemClickListener,NavigationHost {


    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    ArrayList<ItemData> itemData=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notes, container, false);

        recyclerView=view.findViewById(R.id.recyclerNotes);
        itemData.add(new ItemData("Nota",R.drawable.ic_afuera));
        itemData.add(new ItemData("Nota",R.drawable.ic_afuera));
        itemData.add(new ItemData("Nota",R.drawable.ic_afuera));
        itemData.add(new ItemData("Nota",R.drawable.ic_afuera));
        itemData.add(new ItemData("Nota",R.drawable.ic_afuera));
        itemData.add(new ItemData("Nota",R.drawable.ic_afuera));
        itemData.add(new ItemData("Nota",R.drawable.ic_afuera));
        itemData.add(new ItemData("Nota",R.drawable.ic_afuera));
        itemData.add(new ItemData("Nota",R.drawable.ic_afuera));

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerAdapter = new RecyclerAdapter(getContext(),itemData);

        recyclerAdapter.setClickListener(this);

        recyclerView.setAdapter(recyclerAdapter);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return view;

    }


    @Override
    public void onItemClick(View view, int position) {
        navigateTo(new NotesEditorFragment(),true);
    }

    @Override
    public void navigateTo(Fragment fragment, boolean addToBackstack) {

    }
}
