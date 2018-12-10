package com.dk.ricardo.eeas2.fragments.ControlPanel;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.dk.ricardo.eeas2.JavaBeans.Entidades.User;
import com.dk.ricardo.eeas2.JavaBeans.Entidades.UserSingleton;
import com.dk.ricardo.eeas2.R;
import com.dk.ricardo.eeas2.fragments.ControlPanel.RecyclerAdapters.RecyclerAdapterAss;
import com.dk.ricardo.eeas2.utilidades.CustomJsonArrayRequest;
import com.dk.ricardo.eeas2.utilidades.Items.AssItemData;
import com.dk.ricardo.eeas2.utilidades.VolleySingletonAdapter;
import com.github.mikephil.charting.data.BarEntry;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class AssGestorFragment extends Fragment  implements RecyclerAdapterAss.ItemClickListener,
        Response.Listener<JSONObject>,Response.ErrorListener {

    RecyclerView assGestor;
    RecyclerAdapterAss recyclerAdapter;
    ArrayList<AssItemData> itemData=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ass_gestor, container, false);

        assGestor=view.findViewById(R.id.assGestorView);

        //Consulta que saque todos los datos para moverles

        getUsers(getContext());
        itemData.add(new AssItemData("Ricardo Navarro", "JAL0720230",
                R.drawable.ic_afuera));
        itemData.add(new AssItemData("ADALBERTO", "AGS0390293",
                R.drawable.ic_afuera));

        assGestor.setLayoutManager(new LinearLayoutManager(getActivity()));


        recyclerAdapter = new RecyclerAdapterAss(getContext(),itemData);

        recyclerAdapter.setClickListener(this);
        assGestor.setAdapter(recyclerAdapter);
        return view;


    }

    private void getUsers(Context context)
    {
        String webService="fillAss.php";
        String ip= context.getString(R.string.ip_webServices);
        String url=""+ip+webService;
        CustomJsonArrayRequest customjsonArrayRequest=new CustomJsonArrayRequest(Request.Method.POST,
                url, null, this,this)
        {
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<>();
                params.put("CUM",UserSingleton.getInstance().getCum());
                params.put("Pass",UserSingleton.getInstance().getPass());
                return params;
            }
        };
        VolleySingletonAdapter.getInstanceVolley(context).addToRequestQueue(customjsonArrayRequest);

    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getContext(), "You clicked " + recyclerAdapter.getItem(position).getName()
                + " on row number " + position, Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.i("assError",""+error);

    }

    @Override
    public void onResponse(JSONObject response) {

        setVista(response);
    }

    public void setVista(JSONObject response)
    {
        try
        {
            JSONArray jsonArrayName =response.getJSONArray("Nombre");
            JSONArray jsonArrayCum=response.getJSONArray("Cum");
            for (int i=0; i<jsonArrayName.length(); i++) {
                itemData.add(new AssItemData(jsonArrayName.getString(i), jsonArrayCum.getString(i),
                        R.drawable.ic_afuera));
                recyclerAdapter.notifyItemInserted(i);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        // Stuff that updates the UI


    }
}
