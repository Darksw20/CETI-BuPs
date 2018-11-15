package com.dk.ricardo.eeas2.JavaBeans.Entidades;

import java.io.Serializable;

public class User implements Serializable
{
    private String cum, nombre, aPat, aMat, fNaci, vigencia, provincia, grupoS, seccion, scouterResp, telCel, pass;
    private String colorCabello, colorOjos, colorPiel, tipoSangre, dieta, regnal;
    private int sexo, donarSangre, alcohol, fumador, usoSustancias, famDiabetes, famHipertension, afeccionFrioCalor;
    private int infoEmergencia, tipoUser;
    private double estatura, peso;

    public User()
    {

    }

    public User(String cum, String nombre, String aPat, String aMat, String fNaci, String vigencia, String provincia, String grupoS, String seccion, String scouterResp, String telCel, String pass, String colorCabello, String colorOjos, String colorPiel, String tipoSangre, String dieta, String regnal, int sexo, int donarSangre, int alcohol, int fumador, int usoSustancias, int famDiabetes, int famHipertension, int afeccionFrioCalor, int infoEmergencia, int tipoUser, double estatura, double peso) {
        this.cum = cum;
        this.nombre = nombre;
        this.aPat = aPat;
        this.aMat = aMat;
        this.fNaci = fNaci;
        this.vigencia = vigencia;
        this.provincia = provincia;
        this.grupoS = grupoS;
        this.seccion = seccion;
        this.scouterResp = scouterResp;
        this.telCel = telCel;
        this.pass = pass;
        this.colorCabello = colorCabello;
        this.colorOjos = colorOjos;
        this.colorPiel = colorPiel;
        this.tipoSangre = tipoSangre;
        this.dieta = dieta;
        this.regnal = regnal;
        this.sexo = sexo;
        this.donarSangre = donarSangre;
        this.alcohol = alcohol;
        this.fumador = fumador;
        this.usoSustancias = usoSustancias;
        this.famDiabetes = famDiabetes;
        this.famHipertension = famHipertension;
        this.afeccionFrioCalor = afeccionFrioCalor;
        this.infoEmergencia = infoEmergencia;
        this.tipoUser = tipoUser;
        this.estatura = estatura;
        this.peso = peso;
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

    public String getfNaci() {
        return fNaci;
    }

    public void setfNaci(String fNaci) {
        this.fNaci = fNaci;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getGrupoS() {
        return grupoS;
    }

    public void setGrupoS(String grupoS) {
        this.grupoS = grupoS;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getScouterResp() {
        return scouterResp;
    }

    public void setScouterResp(String scouterResp) {
        this.scouterResp = scouterResp;
    }

    public String getTelCel() {
        return telCel;
    }

    public void setTelCel(String telCel) {
        this.telCel = telCel;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getColorCabello() {
        return colorCabello;
    }

    public void setColorCabello(String colorCabello) {
        this.colorCabello = colorCabello;
    }

    public String getColorOjos() {
        return colorOjos;
    }

    public void setColorOjos(String colorOjos) {
        this.colorOjos = colorOjos;
    }

    public String getColorPiel() {
        return colorPiel;
    }

    public void setColorPiel(String colorPiel) {
        this.colorPiel = colorPiel;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getDieta() {
        return dieta;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
    }

    public String getRegnal() {
        return regnal;
    }

    public void setRegnal(String regnal) {
        this.regnal = regnal;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public int getDonarSangre() {
        return donarSangre;
    }

    public void setDonarSangre(int donarSangre) {
        this.donarSangre = donarSangre;
    }

    public int getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(int alcohol) {
        this.alcohol = alcohol;
    }

    public int getFumador() {
        return fumador;
    }

    public void setFumador(int fumador) {
        this.fumador = fumador;
    }

    public int getUsoSustancias() {
        return usoSustancias;
    }

    public void setUsoSustancias(int usoSustancias) {
        this.usoSustancias = usoSustancias;
    }

    public int getFamDiabetes() {
        return famDiabetes;
    }

    public void setFamDiabetes(int famDiabetes) {
        this.famDiabetes = famDiabetes;
    }

    public int getFamHipertension() {
        return famHipertension;
    }

    public void setFamHipertension(int famHipertension) {
        this.famHipertension = famHipertension;
    }

    public int getAfeccionFrioCalor() {
        return afeccionFrioCalor;
    }

    public void setAfeccionFrioCalor(int afeccionFrioCalor) {
        this.afeccionFrioCalor = afeccionFrioCalor;
    }

    public int getInfoEmergencia() {
        return infoEmergencia;
    }

    public void setInfoEmergencia(int infoEmergencia) {
        this.infoEmergencia = infoEmergencia;
    }

    public int getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(int tipoUser) {
        this.tipoUser = tipoUser;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
