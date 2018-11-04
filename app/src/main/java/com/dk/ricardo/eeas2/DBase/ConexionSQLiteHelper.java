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
        db.execSQL(Utilidades.CREAR_TABLA_USUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);
    }
}
