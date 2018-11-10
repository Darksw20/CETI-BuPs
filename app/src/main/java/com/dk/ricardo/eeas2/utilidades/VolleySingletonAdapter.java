package com.dk.ricardo.eeas2.utilidades;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingletonAdapter
{
    private static VolleySingletonAdapter instanceVolley;
    private RequestQueue request;
//    private StringRequest request;
    private static Context contexto;

    private VolleySingletonAdapter(Context context) {
        contexto=context;
        request= getRequestQueue();
    }



    public static synchronized VolleySingletonAdapter getInstanceVolley(Context context)
    {
        if(instanceVolley==null)
        {
            instanceVolley=new VolleySingletonAdapter(context);
        }
        return instanceVolley;
    }
    private RequestQueue getRequestQueue()
    {
        if (request==null)
        {
            request= Volley.newRequestQueue(contexto.getApplicationContext());
        }
        return request;
    }
    public <T> void addToRequestQueue(Request<T> request)
    {
        getRequestQueue().add(request);
    }
}
