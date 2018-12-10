package com.dk.ricardo.eeas2.fragments.ControlPanel.RecyclerAdapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.dk.ricardo.eeas2.JavaBeans.Entidades.UserSingleton;
import com.dk.ricardo.eeas2.R;
import com.dk.ricardo.eeas2.utilidades.CustomJsonArrayRequest;
import com.dk.ricardo.eeas2.utilidades.Items.AssItemData;
import com.dk.ricardo.eeas2.utilidades.Items.ItemData;
import com.dk.ricardo.eeas2.utilidades.VolleySingletonAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RecyclerAdapterAss extends RecyclerView.Adapter<RecyclerAdapterAss.ViewHolder>
{
    private ArrayList<AssItemData> itemsData;
    private LayoutInflater mInflater;
    private ItemClickListener itemClickListener;
    Context contextoo;

    public RecyclerAdapterAss(Context context, ArrayList<AssItemData> itemsData)
    {
        this.contextoo= context;
        this.mInflater = LayoutInflater.from(context);
        this.itemsData = itemsData;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemviewassgestor, null);
        // create ViewHolder
        return new ViewHolder(itemLayoutView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position)
    {
        AssItemData item = itemsData.get(position);
        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData
        viewHolder.txtViewName.setText(item.getName());
        viewHolder.txtViewCum.setText(item.getCum());
        viewHolder.imgViewIcon.setImageResource(item.getImageUrl());

    }

    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount()
    {
        return itemsData.size();
    }


    // inner class to hold a reference to each item of RecyclerView
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        public TextView txtViewName;
        public TextView txtViewCum;
        public Button buttViewQuitar;
        public Button buttViewEditar;
        public ImageView imgViewIcon;
        public Context context;

        public ViewHolder(View itemView)
        {
            super(itemView);
            txtViewName = (TextView) itemView.findViewById(R.id.item_name);
            txtViewCum = (TextView) itemView.findViewById(R.id.item_cum);
            buttViewQuitar = (Button) itemView.findViewById(R.id.quitar);
            buttViewEditar = (Button) itemView.findViewById(R.id.editar);
            imgViewIcon = (ImageView) itemView.findViewById(R.id.item_icono);

            itemView.setOnClickListener(this);
            buttViewQuitar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //eliminar cambiar a usuario tipo 9 o regresarle su existencia
                    webServiceBan(txtViewCum.getText().toString(),v);

                }
            });
            buttViewEditar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //editar
                    Toast.makeText(v.getContext(),"editar"+txtViewCum.getText().toString(),Toast.LENGTH_SHORT).show();
                }
            });
        }

        private void webServiceBan(final String cum,final View v)
        {
            String ip=v.getContext().getString(R.string.ip_webServices), url=ip+"ban.php";
            CustomJsonArrayRequest customJsonArrayRequest= new CustomJsonArrayRequest(Request.Method.POST, url,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {

                    //Recibire un true o false
                    try
                    {
                        int resp=response.getInt("estadoQuery");
                        int tU=response.getInt("newUser");
                        if(tU==9)
                        {
                            buttViewQuitar.setText("0");
                        }
                        else
                        {
                            buttViewQuitar.setText("1");
                        }


                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.i("errorIsBan",""+error);
                }
            }
            ){
                @Override
                protected Map<String,String> getParams(){
                    Map<String,String> params = new HashMap<>();
                    params.put("CUM",UserSingleton.getInstance().getCum());
                    params.put("Pass",UserSingleton.getInstance().getPass());
                    params.put("userCum",cum);
                    return params;
                }
            };
            VolleySingletonAdapter.getInstanceVolley(contextoo).addToRequestQueue(customJsonArrayRequest);

        }

        @Override
        public void onClick(View v) {
            if (itemClickListener != null) itemClickListener.onItemClick(v, getAdapterPosition());
        }


    }



    public void setClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
    // convenience method for getting data at click position
    public String getName(String name) {
        name= getName(name);
        return name;
    }
    public AssItemData getItem(int idItem) {
        return itemsData.get(idItem);
    }
}
