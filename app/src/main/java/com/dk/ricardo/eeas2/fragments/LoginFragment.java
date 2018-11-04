package com.dk.ricardo.eeas2.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
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
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.dk.ricardo.eeas2.Entidades.CustomJsonArrayRequest;
import com.dk.ricardo.eeas2.Entidades.UserSingleton;
import com.dk.ricardo.eeas2.Entidades.VolleySingletonAdapter;
import com.dk.ricardo.eeas2.R;
import com.dk.ricardo.eeas2.activities.MainActivity;
import com.dk.ricardo.eeas2.activities.splashScreen;

import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

/**
 * Fragment representing the login screen for B-upS.
 */
public class LoginFragment extends Fragment implements Response.Listener<JSONObject>,Response.ErrorListener
{
    private boolean validado,tipoOf;
    private int tipo;
    private String user, pass;

    SharedPreferences loggin;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        final TextInputLayout passwordTextInput = view.findViewById(R.id.passTextInput);
        final TextInputLayout userTextInput = view.findViewById(R.id.userTextInput);
        final TextInputEditText passwordEditText = view.findViewById(R.id.passEditText);
        final TextInputEditText userEditText = view.findViewById(R.id.userEditText);
        MaterialButton loginButton = view.findViewById(R.id.loginButton);


        //TODO: Agregar shared preferences
        try
        {
            loggin = getContext().getSharedPreferences("LoginData", MODE_PRIVATE);

            tipo=loggin.getInt("type",404);
            user=loggin.getString("user","404");
            pass=loggin.getString("pass","404");

            if(tipo!=404||!user.equals("404")||!pass.equals("404"))
            {
                UserSingleton.getInstance().setCum(user);
                UserSingleton.getInstance().setPass(pass);
                UserSingleton.getInstance().setTipoUser(tipo);
                //se hace query, si los datos coinciden con alguna cuenta se entra al sistema
                Intent inicio = new Intent(getActivity(), MainActivity.class);
                startActivity(inicio);
            }


        }catch (Exception e)
        {
            e.printStackTrace();
        }
































/*

        //TODO: Revisar que los errores coincidan con lo que se escribio en la propuesta DER
        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(isUserValid(userEditText.getText())||isPasswordValid(passwordEditText.getText()))
                {
                    userTextInput.setError(getString(R.string.eeas_error_user));
                }
                else
                {
                    userTextInput.setError(null);//limpiar ambos errores
                    passwordTextInput.setError(null); // Clear the error
                    cargarWebServiceAuth("loginValidation.php",userEditText.getText().toString(),passwordEditText.getText().toString());
                    Toast.makeText(getContext(),""+tipo,Toast.LENGTH_SHORT).show();
                    if(tipo!=404&&tipo!=0)
                    {



                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run()
                            {
                                Intent intent=new Intent(getActivity(),MainActivity.class);
                                startActivity(intent);
                                //finish();
                            }
                        },2000);
                    }
                    else
                    {
                        //error de tipo de usuario
                    }
                }

                // Clear the error once more than 8 characters are typed.
                passwordEditText.setOnKeyListener(new View.OnKeyListener()
                {
                    @Override
                    public boolean onKey(View view, int i, KeyEvent keyEvent)
                    {
                        if (!isPasswordValid(passwordEditText.getText()))
                        {
                            passwordTextInput.setError(null); //Clear the error
                        }
                        return false;
                    }
                });
            }
        });
        return view;
    }

    /**
     * Este metodo sirve para saber si el usuario ingresado si existe dentro de la base de datos
     * @param text
     * Es el texto que recibe de userEditText
     * @return
     * Regresa un valor booleano que muestra si existe o no el Usuario en la base de datos
     */
/*
    //TODO: Hacer el php para esta funcion: userNameAvailable.php
    private boolean isUserValid(@NonNull Editable text)
    {
        try {
            cargarWebServiceUV("userNameAvailable.php",text.toString());//,text.toString());
        }catch (Exception e)
        {
            Log.e("Error Raro","no carga esta madre");
            validado=false;
        }

        return validado;
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
/*
    //TODO: Agregar condiciones 2 y 3
    private boolean isPasswordValid(@Nullable Editable text) {
        return !(text != null && text.length() >= 8);
    }



    private void cargarWebServiceUV(String webService,final String user)
    {
        tipoOf=false;
        progreso=new ProgressDialog(getContext());
        progreso.setMessage("Revisando solicitud...uv");
        progreso.show();

        String ip= getString(R.string.ip_webServices), url=""+ip+webService;

        CustomJsonArrayRequest customjsonArrayRequest=new CustomJsonArrayRequest(Request.Method.POST,url, null, this,this)
        {
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("CUM",user);
                return params;
            }
        };
        VolleySingletonAdapter.getInstanceVolley(getContext()).addToRequestQueue(customjsonArrayRequest);
    }

    //Agregar en ves de dos parametros un array

    private void cargarWebServiceAuth(String webService,final String user,final String password)
    {
        tipoOf=true;
        progreso=new ProgressDialog(getContext());
        progreso.setMessage("Revisando solicitud...auth");
        progreso.show();

        String ip= getString(R.string.ip_webServices), url=""+ip+webService;

        CustomJsonArrayRequest customjsonArrayRequest=new CustomJsonArrayRequest(Request.Method.POST,url, null, this,this)
        {
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("CUM",user);
                params.put("Pass",password);
                return params;
            }
        };
        VolleySingletonAdapter.getInstanceVolley(getContext()).addToRequestQueue(customjsonArrayRequest);
    }







}
*/
    return view;
    }

    @Override
    public void onErrorResponse(VolleyError error) {

        Log.i("ERROR",error.toString());

    }
    @Override
    public void onResponse(JSONObject response) {
        if(tipoOf)
        {
            try
            {
                validado=response.getBoolean("validado");
            }catch (Exception e)
            {
                Log.e("ErrorParse",""+e);
            }
        }
        else
        {
            try
            {
                tipo=response.getInt("tipo");
            }catch (Exception a)
            {
                Log.e("errorNose",""+a);
            }
        }
    }
}