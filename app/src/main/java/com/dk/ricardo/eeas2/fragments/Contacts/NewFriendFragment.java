package com.dk.ricardo.eeas2.fragments.Contacts;


import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;

import com.dk.ricardo.eeas2.DBase.ConexionSQLiteHelper;
import com.dk.ricardo.eeas2.JavaBeans.Entidades.UserSingleton;
import com.dk.ricardo.eeas2.R;
import com.dk.ricardo.eeas2.utilidades.Utilidades;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewFriendFragment extends Fragment {


    private CameraSource cameraSource;
    private SurfaceView cameraView;
    private final int MY_PERMISSIONS_REQUEST_CAMERA = 1;
    private String token = "";
    private String tokenanterior = "";
    ConexionSQLiteHelper con;
    SQLiteDatabase db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_friend, container, false);
        cameraView = view.findViewById(R.id.cameraFriend);
        initQR();
        return view;
    }

    public void initQR()
    {

        // creo el detector qr
        BarcodeDetector barcodeDetector =
                new BarcodeDetector.Builder(getContext())
                        .setBarcodeFormats(Barcode.ALL_FORMATS)
                        .build();

        // creo la camara
        cameraSource = new CameraSource
                .Builder(getContext(), barcodeDetector)
                .setRequestedPreviewSize(1600, 1024)
                .setAutoFocusEnabled(true) //you should add this feature
                .build();

        // listener de ciclo de vida de la camara
        cameraView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {


                // verifico si el usuario dio los permisos para la camara
                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        // verificamos la version de ANdroid que sea al menos la M para mostrar
                        // el dialog de la solicitud de la camara
                        if (shouldShowRequestPermissionRationale(
                                Manifest.permission.CAMERA)) ;
                        requestPermissions(new String[]{Manifest.permission.CAMERA},
                                MY_PERMISSIONS_REQUEST_CAMERA);
                    }
                    return;
                } else {
                    try {

                        cameraSource.start(cameraView.getHolder());
                    } catch (IOException ie) {
                        Log.e("CAMERA SOURCE", ie.getMessage());
                    }catch (RuntimeException re)
                    {
                        Log.e("CAMERA FAIL",re.getMessage());
                    }
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                //surface realese
                if (cameraSource != null) {
                    try {
                        cameraSource.release();
                    } catch (NullPointerException ignored) {  }
                    cameraSource = null;
                }
            }
        });

        // preparo el detector de QR
        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {
            }


            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> barcodes = detections.getDetectedItems();

                if (barcodes.size() > 0) {

                    // obtenemos el token
                    token = barcodes.valueAt(0).displayValue.toString();

                    // verificamos que el token anterior no se igual al actual
                    // esto es util para evitar multiples llamadas empleando el mismo token
                    if (!token.equals(tokenanterior)) {

                        // guardamos el ultimo token proceado
                        tokenanterior = token;
                        Log.i("token", token);

                        //Agrega amigo

                        con = new ConexionSQLiteHelper(getContext(), "bd_usuarios", null, 1);
                        db = con.getWritableDatabase();
                        ContentValues cv = new ContentValues();
                            cv.put(Utilidades.CAMPO_AMIGOS_FK_USUARIO, token);
                            db.insert(Utilidades.TABLA_AMIGOS,Utilidades.CAMPO_FK_AMIGOS,cv);

                        String[] campos = new String[]{Utilidades.CAMPO_ID_AMIGOS};
                        String[] args = new String[]{UserSingleton.getInstance().getCum()};

                        Cursor d = db.query(Utilidades.TABLA_AMIGOS, campos, "cum=?", args, null, null, null);

                        //Nos aseguramos de que existe al menos un registro
                        if (d.moveToFirst()) {
                            //Recorremos el cursor hasta que no haya más registros
                            do {
                                String cum = d.getString(0);
                                Log.i("amigosBD",cum+"Amigo");
                            } while (d.moveToNext());

                        }
                        d.close();
                        db.close();

                        new Thread(new Runnable() {
                            public void run() {
                                try {
                                    synchronized (this) {
                                        wait(5000);
                                        // limpiamos el token
                                        tokenanterior = "";
                                    }
                                } catch (InterruptedException e) {
                                    // TODO Auto-generated catch block
                                    Log.e("Error", "Waiting didnt work!!");
                                    e.printStackTrace();
                                }
                            }
                        }).start();

                    }
                }
            }
        });

    }
    @Override
    public void onPause() {
        super.onPause();
        if (cameraSource != null) {
            try {
                cameraSource.release();
            } catch (NullPointerException ignored) {  }
            cameraSource = null;
        }
    }
}
