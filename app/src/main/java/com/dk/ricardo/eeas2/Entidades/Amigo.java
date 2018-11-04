package com.dk.ricardo.eeas2.Entidades;

public class Amigo
{
    private String cum;
    private String nombre;
    private String aPat;
    private String aMat;
    private String QR;
    private int tipo;

    public Amigo(String cum, String nombre, String aPat, String aMat, String QR, int tipo) {
        this.cum = cum;
        this.nombre = nombre;
        this.aPat = aPat;
        this.aMat = aMat;
        this.QR = QR;
        this.tipo = tipo;
    }

    public String getCum() {
        return cum;
    }

    public void setCum(String cum) {
        this.cum = cum;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getaPat() {
        return aPat;
    }

    public void setaPat(String aPat) {
        this.aPat = aPat;
    }

    public String getaMat() {
        return aMat;
    }

    public void setaMat(String aMat) {
        this.aMat = aMat;
    }

    public String getQR() {
        return QR;
    }

    public void setQR(String QR) {
        this.QR = QR;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
