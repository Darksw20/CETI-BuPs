package com.dk.ricardo.eeas2.fragments.GeoLocation;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dk.ricardo.eeas2.R;
import com.dk.ricardo.eeas2.fragments.Dashboard.DashFragment;
import com.dk.ricardo.eeas2.interfaces.NavigationHost;

public class GeoLocationFragment extends Fragment implements NavigationHost {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_geo_location, container, false);
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(getContext(), android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(getContext());
        }
        builder.setTitle("¿Deseas usar el sistema?")
                .setMessage("Te damos la bienvenida al sistema de seguimiento, este sistema fue creado  " +
                        "para tu seguridad, puedes cancelarlo si deseas, para mas informacion visita " +
                        "www.bupsscout.com/geolocalizacion")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continuar con el seguimiento
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Salir del fragment
                        navigateTo(new DashFragment(), false);
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
        return view;
    }

    @Override
    public void navigateTo(Fragment fragment, boolean addToBackstack) {
        FragmentTransaction transaction =
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, fragment);

        if (addToBackstack) {
            transaction.addToBackStack(null);
        }

        transaction.commit();
    }
}
