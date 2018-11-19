package com.dk.ricardo.eeas2.Adapters;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.dk.ricardo.eeas2.R;
import com.dk.ricardo.eeas2.utilidades.Items.ItemData;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>
{
    private ArrayList<ItemData> itemsData;
    private LayoutInflater mInflater;
    private ItemClickListener itemClickListener;

    public RecyclerAdapter(Context context,ArrayList<ItemData> itemsData)
    {
        this.mInflater = LayoutInflater.from(context);
        this.itemsData = itemsData;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview, null);
        // create ViewHolder
        return new ViewHolder(itemLayoutView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position)
    {
        ItemData item = itemsData.get(position);
        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData
        viewHolder.txtViewTitle.setText(item.getTitle());
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

        public TextView txtViewTitle;
        public ImageView imgViewIcon;

        public ViewHolder(View itemView)
        {
            super(itemView);
            txtViewTitle = (TextView) itemView.findViewById(R.id.item_title);
            imgViewIcon = (ImageView) itemView.findViewById(R.id.item_icon);
            itemView.setOnClickListener(this);
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
    public String getTitle(String title) {
        title= getTitle(title);
        return title;
    }
    public ItemData getItem(int idItem) {
        return itemsData.get(idItem);
    }



    public void addItem(int position, ItemData viewModel) {
        itemsData.add(position, viewModel);
        notifyItemInserted(position);
    }




}
