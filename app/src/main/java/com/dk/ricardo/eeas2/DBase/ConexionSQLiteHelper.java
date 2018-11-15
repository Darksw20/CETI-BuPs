package com.dk.ricardo.eeas2.DBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.dk.ricardo.eeas2.utilidades.Utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper
{


    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        // aqui pudiera poner las condiciones para el tipo de base de datos
        // como en un switch case
        db.execSQL(Utilidades.CREAR_TABLA_ALERGIAS);
        db.execSQL(Utilidades.CREAR_TABLA_CIRUGIAS);
        db.execSQL(Utilidades.CREAR_TABLA_ENFERMEDADES);
        db.execSQL(Utilidades.CREAR_TABLA_ENF_INMUNES);
        db.execSQL(Utilidades.CREAR_TABLA_FRACTURAS);
        db.execSQL(Utilidades.CREAR_TABLA_INCIDENTES);
        db.execSQL(Utilidades.CREAR_TABLA_INFO_EMERGENCIA);
        db.execSQL(Utilidades.CREAR_TABLA_MUJER);
        db.execSQL(Utilidades.CREAR_TABLA_PROB_CIRCULATORIOS);
        db.execSQL(Utilidades.CREAR_TABLA_PROB_HER);
        db.execSQL(Utilidades.CREAR_TABLA_REDES_SOCIALES);
        db.execSQL(Utilidades.CREAR_TABLA_SEG_PUB);
        db.execSQL(Utilidades.CREAR_TABLA_SEG_PRIV);
        db.execSQL(Utilidades.CREAR_TABLA_GEOLOCALIZACION);
        db.execSQL(Utilidades.CREAR_TABLA_VACUNAS);
        db.execSQL(Utilidades.CREAR_TABLA_LENTES);
        db.execSQL(Utilidades.CREAR_TABLA_USUARIO);
        db.execSQL(Utilidades.CREAR_TABLA_PACIENTE);
        db.execSQL(Utilidades.CREAR_TABLA_AMIGOS);
        db.execSQL(Utilidades.CREAR_TABLA_LISTA);
        db.execSQL(Utilidades.CREAR_TABLA_RELACION_ENF_INMUNES);
        db.execSQL(Utilidades.CREAR_TABLA_RELACION_ALERGIAS);
        db.execSQL(Utilidades.CREAR_TABLA_RELACION_PROB_CIRCULATORIOS);
        db.execSQL(Utilidades.CREAR_TABLA_RELACION_FRACTURAS);
        db.execSQL(Utilidades.CREAR_TABLA_RELACION_CIRUGIAS);
        db.execSQL(Utilidades.CREAR_TABLA_RELACION_ENFERMEDADES);
        db.execSQL(Utilidades.CREAR_TABLA_RELACION_MUJER);
        db.execSQL(Utilidades.CREAR_TABLA_RELACION_VACUNAS);
        db.execSQL(Utilidades.CREAR_TABLA_RELACION_SEG_PUBLICA);
        db.execSQL(Utilidades.CREAR_TABLA_RELACION_SEG_PRIVADA);
        db.execSQL(Utilidades.CREAR_TABLA_RELACION_PROB_HER);
        db.execSQL(Utilidades.CREAR_TABLA_RELACION_INCIDENTES);
        db.execSQL(Utilidades.CREAR_TABLA_ACTIVIDADES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_REL_INCIDENTES);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_REL_PROB_HER);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_REL_SEG_PRIVADA);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_REL_SEG_PUBLICA);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_REL_VACUNAS);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_REL_MUJER);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_REL_ENFERMEDADES);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_REL_CIRUGIAS);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_REL_FRACTURAS);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_REL_PROB_CIRCULATORIOS);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_REL_ALERGIAS);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_REL_ENF_INMUNES);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_ACTIVIDADES);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_LISTA);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_AMIGOS);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_PACIENTE);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_LENTES);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_VACUNAS);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_GEOLOCALIZACION);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_SEG_PRIV);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_SEG_PUB);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_REDES_SOCIALES);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_PROB_HER);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_PROB_CIRCULATORIOS);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_MUJER);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_INFO_EMERGENCIA);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_INCIDENTES);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_FRACTURAS);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_ENF_INMUNES);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_ENFERMEDADES);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_CIRUGIAS);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_ALERGIAS);
        onCreate(db);
    }
}
