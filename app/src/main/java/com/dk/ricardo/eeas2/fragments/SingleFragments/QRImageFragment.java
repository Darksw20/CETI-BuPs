package com.dk.ricardo.eeas2.fragments.SingleFragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dk.ricardo.eeas2.JavaBeans.Entidades.UserSingleton;
import com.dk.ricardo.eeas2.R;

public class QRImageFragment extends Fragment {

    TextView nombre,aPat,aMat,cum,provincia;
    ImageView qr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_qrimage, container, false);

        nombre=view.findViewById(R.id.nomb);
        aPat=view.findViewById(R.id.apat);
        aMat=view.findViewById(R.id.amat);
        cum=view.findViewById(R.id.cum);
        qr=view.findViewById(R.id.imagenQr);

        nombre.setText(UserSingleton.getInstance().getNombre());
        aPat.setText(UserSingleton.getInstance().getaPat());
        aMat.setText(UserSingleton.getInstance().getaMat());
        cum.setText(UserSingleton.getInstance().getCum());

        return view;
    }
}
