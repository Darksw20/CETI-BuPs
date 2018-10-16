package com.dk.ricardo.eeas2.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.dk.ricardo.eeas2.Entidades.VolleySingletonAdapter;
import com.dk.ricardo.eeas2.R;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Fragment representing the login screen for B-upS.
 */
public class LoginFragment extends Fragment implements Response.Listener<JSONObject>,Response.ErrorListener
{
    private Boolean validado;
    private int tipo=0;
    ProgressDialog progreso;

    //RequestQueue request;
    JsonObjectRequest jsonArrayRequest;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        final TextInputLayout passwordTextInput = view.findViewById(R.id.passTextInput);
        final TextInputLayout userTextInput = view.findViewById(R.id.userTextInput);
        final TextInputEditText passwordEditText = view.findViewById(R.id.passEditText);
        final TextInputEditText userEditText= view.findViewById(R.id.userEditText);
        MaterialButton loginButton = view.findViewById(R.id.loginButton);


        //TODO: Agregar shared preferences





        //TODO: Revisar que los errores coincidan con lo que se escribio en la propuesta DER
        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                cargarWebService("userNameAvailable.php");
                //VolleySingletonAdapter.getInstanceVolley(getContext()).addToRequestQueue(jsonObjectRequest);
           /*

                if (!isPasswordValid(passwordEditText.getText()))
                {
                    passwordTextInput.setError(getString(R.string.eeas_error_password));
                }
                else
                {


                    //Aqui se agrega la forma de verdaderamente iniciar sesion


                    final String user=userEditText.getText().toString();
                    final String pass=passwordEditText.getText().toString();

                    //RequestQueue Objeto=Volley.newRequestQueue(getActivity().getBaseContext());
                    //TODO: Hacer loginValidation.php

                    String ip=getString(R.string.ip_webServices);
                    final String Direccion = ip+"loginValidation.php";

                    StringRequest Busca = new StringRequest(Request.Method.POST, Direccion, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONArray jsonArray = new JSONArray(response);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject obj = jsonArray.getJSONObject(i);
                                    tipo = obj.getInt("tipo");
                                }

                                switch(tipo)
                                {
                                    //Error
                                    case 0:
                                        if(!isUserValid(userEditText.getText()))
                                        {
                                            userTextInput.setError(getString((R.string.eeas_error_user)));
                                        }
                                        break;
                                    //DBA
                                    case 1:
                                        userTextInput.setError(null);//limpiar ambos errores
                                        passwordTextInput.setError(null); // Clear the error
                                        break;
                                    //Organizadores
                                    case 2:
                                        userTextInput.setError(null);//limpiar ambos errores
                                        passwordTextInput.setError(null); // Clear the error
                                        break;
                                    //Servicios medicos
                                    case 3:
                                        userTextInput.setError(null);//limpiar ambos errores
                                        passwordTextInput.setError(null); // Clear the error
                                        break;
                                    //Jueces
                                    case 4:
                                        userTextInput.setError(null);//limpiar ambos errores
                                        passwordTextInput.setError(null); // Clear the error
                                        break;
                                    //Talleristas
                                    case 5:
                                        userTextInput.setError(null);//limpiar ambos errores
                                        passwordTextInput.setError(null); // Clear the error
                                        break;
                                    //Participantes
                                    case 6:
                                        userTextInput.setError(null);//limpiar ambos errores
                                        passwordTextInput.setError(null); // Clear the error
                                        break;
                                    //Scouter responsable
                                    case 7:
                                        userTextInput.setError(null);//limpiar ambos errores
                                        passwordTextInput.setError(null); // Clear the error
                                        break;
                                    //Staff
                                    case 8:
                                        userTextInput.setError(null);//limpiar ambos errores
                                        passwordTextInput.setError(null); // Clear the error
                                        break;
                                    //Error de conexion(o desconocido)
                                    default:
                                        break;

                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getActivity().getBaseContext(),"ERROR",Toast.LENGTH_LONG).show();
                        }

                }){
                        @Override
                        protected Map<String, String> getParams()
                        {
                            Map<String, String> params= new HashMap<String, String>();
                            params.put("CUM",user);
                            params.put("Pass",pass);
                            return params;
                        }
                    };
                    //Objeto.add(Busca);
                    VolleySingletonAdapter.getInstanceVolley(getContext()).addToRequestQueue(Busca);
                    //TODO:Que hacer con el valor de retorno tipo?
                }
            }
        });






        // Clear the error once more than 8 characters are typed.
        passwordEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (isPasswordValid(passwordEditText.getText())) {
                    passwordTextInput.setError(null); //Clear the error
                }
                return false;
            }
        });


        */
            }
        });
        return view;
    }




    /**
     * Es un metodo para saber si la contraseña tiene las caracteristicas minimas necesarias
     * para poder ser enviado al servidor las cuales son:
     *      -Debe ser Mayor o igual a 8 Caracteres
     *      -Debe incluir un numero
     *      -Debe incluir un digito especial
     * @param text
     * Es el texto que recibe de el campo PassEditText
     * @return
     * Retorna un valor booleano que dice si es valido o no
     */
    //TODO: Agregar condiciones 2 y 3
    private boolean isPasswordValid(@Nullable Editable text) {
        return text != null && text.length() >= 8;
    }

    /**
     * Este metodo sirve para saber si el usuario ingresado si existe dentro de la base de datos
     * @param text
     * Es el texto que recibe de userEditText
     * @return
     * Regresa un valor booleano que muestra si existe o no el Usuario en la base de datos
     */
    //TODO: Hacer el php para esta funcion: userNameAvailable.php
    private boolean isUserValid(@NonNull Editable text)
    {
        cargarWebService("userNameAvailable.php");//,text.toString());
        /*
        final String user = text.toString();
        RequestQueue Objeto = Volley.newRequestQueue(getActivity().getBaseContext());

        String ip = getString(R.string.ip_webServices);

        final String Direccion = ip+"userNameAvailable.php";
        //Toast.makeText(getActivity().getBaseContext(),"Usuario de nombre"+user+";"+Direccion,Toast.LENGTH_SHORT).show();

        StringRequest Busca = new StringRequest(Request.Method.POST, Direccion, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray jsonArray = new JSONArray(response);

                    for (int i = 0; i < jsonArray.length(); i++) {         //obtengo los valores del response de volley
                        JSONObject obj = jsonArray.getJSONObject(i);  //convierto de json a string separadas
                        validado = obj.getBoolean("validado");
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }},new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity().getBaseContext(),"ERROR",Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String> params= new HashMap<String, String>();
                params.put("CUM",user);
                return params;
            }
        };
        Objeto.add(Busca);
        Toast.makeText(getActivity().getBaseContext(),""+validado,Toast.LENGTH_SHORT).show();

        */
        return validado;
    }












    private void cargarWebService(String webService)//,final String user)
    {
        progreso=new ProgressDialog(getContext());
        progreso.setMessage("Revisando solicitud...");
        progreso.show();

        String ip= getString(R.string.ip_webServices), url=""+ip+webService;
        Toast.makeText(getContext(),url,Toast.LENGTH_SHORT).show();
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonParams = new JSONObject();
        try
        {
            jsonParams.put("CUM","JAL0720230");
            jsonParams.put("Pass","hola");
        }catch (JSONException e)
        {
            e.printStackTrace();
        }
        jsonArray.put(jsonParams);
        Log.d("Gabo",jsonParams.toString());

        jsonArrayRequest=new JsonObjectRequest(Request.Method.POST,""+url,null,this,this)
        {
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("CUM","JAL0720230");
                params.put("Pass","hola");

                return params;
            }
        };

        VolleySingletonAdapter.getInstanceVolley(getContext()).addToRequestQueue(jsonArrayRequest);

    }


    @Override
    public void onErrorResponse(VolleyError error) {
        progreso.hide();
        Toast.makeText(getContext(),"No se pudo consultar "+error.toString(),Toast.LENGTH_LONG).show();
        Log.i("ERROR",error.toString());

    }



    @Override
    public void onResponse(JSONObject response) {
        progreso.hide();
        Toast.makeText(getContext(),"Mensaje: "+response,Toast.LENGTH_LONG).show();
    }
}