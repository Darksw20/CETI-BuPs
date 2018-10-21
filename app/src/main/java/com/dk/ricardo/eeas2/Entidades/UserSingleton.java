package com.dk.ricardo.eeas2.Entidades;

public class UserSingleton
{
    private String cum, nombre, aPat, aMat, fNaci, vigencia, provincia, grupoS, seccion, scouterResp, telCel, pass;
    private String colorCabello, colorOjos, colorPiel, tipoSangre, dieta, regnal;
    private int sexo, donarSangre, alcohol, fumador, usoSustancias, famDiabetes, famHipertension, afeccionFrioCalor;
    private int infoEmergencia, tipoUser;
    private double estatura, peso;

    private static volatile UserSingleton ourInstance = null;

    private UserSingleton()
    {
        //TODO:llenar los datos despues el login
        /*
        //array[30];

        //Peticion a volley que me regresa en un array los datos pedidos

        Array [][]array= new Array();
        setCum(array[0]);
        setNombre(array[1]);
        setaPat(array[2]);
        setaMat(array[3]);
        setSexo(array[4]);
        setfNaci(array[5]);
        setVigencia(array[6]);
        setProvincia(array[7]);
        setGrupoS(array[8]);
        setSeccion(array[9]);
        setScouterResp(array[10]);
        setTelCel(array[11]);
        setPass(array[12]);
        setEstatura(array[13]);
        setPeso(array[14]);
        setColorCabello(array[15]);
        setColorOjos(array[16]);
        setColorPiel(array[17]);
        setTipoSangre(array[18]);
        setDonarSangre(array[19]);
        setDieta(array[20]);
        setAlcohol(array[21]);
        setFumador(array[22]);
        setUsoSustancias(array[23]);
        setFamDiabetes(array[24]);
        setFamHipertension(array[25]);
        setAfeccionFrioCalor(array[26]);
        setInfoEmergencia(array[27]);
        setRegnal(array[28]);
        setTipoUser(array[29]);
         */

    }

    public static UserSingleton getInstance()
    {
        if(ourInstance==null)
        {
            synchronized (UserSingleton.class)
            {
                if(ourInstance==null)
                {
                    ourInstance = new UserSingleton();
                }
            }
        }
        return ourInstance;
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

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
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

    public int getDonarSangre() {
        return donarSangre;
    }

    public void setDonarSangre(int donarSangre) {
        this.donarSangre = donarSangre;
    }

    public String getDieta() {
        return dieta;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
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

    public String getRegnal() {
        return regnal;
    }

    public void setRegnal(String regnal) {
        this.regnal = regnal;
    }

    public int getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(int tipoUser) {
        this.tipoUser = tipoUser;
    }
}
