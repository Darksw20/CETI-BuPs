package com.dk.ricardo.eeas2.utilidades;

public class Utilidades
{
    //constantes campos tabla usuarios
    public static final String TABLA_USUARIO="usuario";
    public static final String CAMPO_CUM="cum";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_APAT="aPat";
    public static final String CAMPO_AMAT="aMat";
    public static final String CAMPO_QR="QR";
    public static final String CAMPO_TIPO="tipo";


    public static final String CREAR_TABLA_USUARIO="CREATE TABLE "+TABLA_USUARIO+" ("+CAMPO_CUM+
            " TEXT PRIMARY KEY, "+CAMPO_NOMBRE+" TEXT, "+CAMPO_APAT+" TEXT, "+CAMPO_AMAT+
            " TEXT, "+CAMPO_QR+" TEXT, "+CAMPO_TIPO+" INTEGER)";
}
