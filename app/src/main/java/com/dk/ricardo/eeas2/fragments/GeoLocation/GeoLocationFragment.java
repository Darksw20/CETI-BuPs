package com.dk.ricardo.eeas2.fragments.GeoLocation;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dk.ricardo.eeas2.DBase.ConexionSQLiteHelper;
import com.dk.ricardo.eeas2.JavaBeans.Entidades.UserSingleton;
import com.dk.ricardo.eeas2.R;
import com.dk.ricardo.eeas2.fragments.Dashboard.DashFragment;
import com.dk.ricardo.eeas2.interfaces.NavigationHost;
import com.dk.ricardo.eeas2.utilidades.Utilidades;

public class GeoLocationFragment extends Fragment implements NavigationHost {

    EditText fecha, hora, lugar;
    Button comenzar,terminar;
    ConexionSQLiteHelper con;
    SQLiteDatabase db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_geo_location, container, false);


        AlertDialog.Builder builder;
        fecha=view.findViewById(R.id.EdDia);
        hora=view.findViewById(R.id.EdHora);
        lugar=view.findViewById(R.id.EdLugar);
        comenzar=view.findViewById(R.id.ButComSeg);
        terminar=view.findViewById(R.id.ButTerSeg);

        comenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=fecha.getText().toString(),b=hora.getText().toString(),c=lugar.getText().toString();


                if(a.equals("")&&b.equals("")&&c.equals(""))
                {
                    Toast.makeText(getContext(),"Favor de llenar los campos",Toast.LENGTH_LONG).show();
                }
                else {
                    //ingresar los datos en la BD
                    con = new ConexionSQLiteHelper(getContext(), "bd_usuarios", null, 1);
                    db = con.getWritableDatabase();
                    ContentValues cv = new ContentValues();
                    cv.put(Utilidades.CAMPO_LUGAR_LLEGADA, c);
                    cv.put(Utilidades.CAMPO_HORA_LLEGADA, b);
                    cv.put(Utilidades.CAMPO_DIA_LLEGADA, a);
                    db.update(Utilidades.TABLA_USUARIO, cv, Utilidades.CAMPO_CUM + "= '" +
                            UserSingleton.getInstance().getCum() + "'", null);



                    String[] campos = new String[]{Utilidades.CAMPO_CUM, Utilidades.CAMPO_LUGAR_LLEGADA};
                    String[] args = new String[]{UserSingleton.getInstance().getCum()};

                    Cursor d = db.query("usuario", campos, "cum=?", args, null, null, null);

                    //Nos aseguramos de que existe al menos un registro
                    if (d.moveToFirst()) {
                        //Recorremos el cursor hasta que no haya más registros
                        do {
                            String cum = d.getString(0);
                            String Lugar = d.getString(1);
                            Log.i("dataBD",cum+" : "+Lugar);
                            Toast.makeText(getContext(),""+cum,Toast.LENGTH_SHORT).show();
                        } while (d.moveToNext());

                    }
                    d.close();
                    db.close();
                }
            }
        });
        terminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateTo(new DashFragment(), false);
            }
        });


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            builder = new AlertDialog.Builder(getContext(), android.R.style.Theme_Material_Dialog_Alert);
        }
        else {

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
