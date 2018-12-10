package com.dk.ricardo.eeas2.fragments.EmergencyNumbers;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
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

public class EmergencyNumbsFragment extends Fragment  implements RecyclerAdapter.ItemClickListener{

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    ArrayList<ItemData> itemData=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_emergency_numbs, container, false);

        recyclerView=view.findViewById(R.id.recyclerEmergency);
        itemData.add(new ItemData("Mi mama",R.drawable.ic_afuera));
        itemData.add(new ItemData("El Benja",R.drawable.ic_afuera));
        itemData.add(new ItemData("Policia",R.drawable.ic_afuera));
        itemData.add(new ItemData("Ambulancia",R.drawable.ic_afuera));
        itemData.add(new ItemData("El Ejercito",R.drawable.ic_afuera));
        itemData.add(new ItemData("Bomberos",R.drawable.ic_afuera));

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerAdapter = new RecyclerAdapter(getContext(),itemData);

        recyclerAdapter.setClickListener(this);

        recyclerView.setAdapter(recyclerAdapter);


        return view;
    }
    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getContext(), "You clicked " + recyclerAdapter.getItem(position).getTitle().toString() + " on row number " + position, Toast.LENGTH_SHORT).show();
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        switch (position)
        {
            case 0:
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:3338219511")));
                break;
            case 1:
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:3323550062")));
                break;
            case 2:
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:911")));
                break;
            case 3:
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:911")));
                break;
            case 4:
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:911")));
                break;
            case 5:
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:911")));
                break;
            case 6:
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:911")));
                break;
            case 7:
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:911")));
                break;
            case 8:
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:911")));
                break;
        }

    }

}
