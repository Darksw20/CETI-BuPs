package com.dk.ricardo.eeas2.JavaBeans.Entidades;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.dk.ricardo.eeas2.utilidades.CustomJsonArrayRequest;
import com.dk.ricardo.eeas2.utilidades.VolleySingletonAdapter;
import com.dk.ricardo.eeas2.R;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class UserSingleton implements Response.Listener<JSONObject>,Response.ErrorListener
{
    private String cum, nombre, aPat, aMat, fNaci, vigencia, provincia, grupoS, seccion, scouterResp, telCel, pass;
    private String colorCabello, colorOjos, colorPiel, tipoSangre, dieta, regnal;
    private int sexo, donarSangre, alcohol, fumador, usoSustancias, famDiabetes, famHipertension, afeccionFrioCalor;
    private int infoEmergencia, tipoUser;
    private double estatura, peso;

    private static volatile UserSingleton ourInstance = null;


    private UserSingleton() {

    }

    public void cargarWebService(Context context)
    {
        String webService="fillUserData.php";
        String ip= context.getString(R.string.ip_webServices);
        String url=""+ip+webService;
        CustomJsonArrayRequest customjsonArrayRequest=new CustomJsonArrayRequest(Request.Method.POST,url, null, this,this)
        {
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<>();
                params.put("CUM",getCum());
                params.put("Pass",getPass());
                return params;
            }
        };
        VolleySingletonAdapter.getInstanceVolley(context).addToRequestQueue(customjsonArrayRequest);
        delay(500);

    }

    public static UserSingleton getInstance()
    {
        if(ourInstance==null)
        {
            synchronized (UserSingleton.class)
            {
                if(ourInstance==null)
                {
                    ourInstance = new UserSingleton();//ourInstance.context);
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

    public void clean(){

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        error.printStackTrace();
    }

    @Override
    public void onResponse(JSONObject response) {

        try
        {
            setCum(response.getString("CUM"));
            setNombre(response.getString("nombre"));
            setaPat(response.getString("aPat"));
            setaMat(response.getString("aMat"));
            setSexo(response.getInt("sexo"));
            setfNaci(response.getString("fNaci"));
            setVigencia(response.getString("vigencia"));
            setProvincia(response.getString("provincia"));
            setGrupoS(response.getString("grupoS"));
            setSeccion(response.getString("seccion"));
            setScouterResp(response.getString("scouterResp"));
            setTelCel(response.getString("telCel"));
            setPass(response.getString("pass"));
            setEstatura(response.getDouble("estatura"));
            setPeso(response.getDouble("peso"));
            setColorCabello(response.getString("colorCabello"));
            setColorOjos(response.getString("colorOjos"));
            setColorPiel(response.getString("colorPiel"));
            setTipoSangre(response.getString("tipoSangre"));
            setDonarSangre(response.getInt("donarSangre"));
            setDieta(response.getString("dieta"));
            setAlcohol(response.getInt("alcohol"));
            setFumador(response.getInt("fumador"));
            setUsoSustancias(response.getInt("usoSustancias"));
            setFamDiabetes(response.getInt("famDiabetes"));
            setFamHipertension(response.getInt("famHipertension"));
            setAfeccionFrioCalor(response.getInt("afeccionesFrioCalor"));
            setInfoEmergencia(response.getInt("infoEmergencia"));
            setRegnal(response.getString("regnal"));
            setTipoUser(response.getInt("tipoUser"));
        }catch (Exception e)
        {
            e.printStackTrace();
        }



    }
    public void delay(int time)
    {
        //delay 500ms
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
            }
        }, time);
    }
}
