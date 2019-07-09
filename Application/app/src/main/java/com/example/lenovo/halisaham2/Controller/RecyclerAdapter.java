package com.example.lenovo.halisaham2.Controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.halisaham2.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private ArrayList<Dataprovider> arrayList = new ArrayList<Dataprovider>();

    public RecyclerAdapter(ArrayList<Dataprovider> arrayList)
    {
        this.arrayList=arrayList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        Dataprovider dataprovider=arrayList.get(position);
        holder.imageView.setImageResource(dataprovider.getImg_res());
        holder.h_name.setText(dataprovider.getH_name());
        holder.k_name.setText(dataprovider.getK_name());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView h_name,k_name;

        public RecyclerViewHolder(View view)
        {
            super(view);
            imageView=(ImageView)view.findViewById(R.id.img);
            h_name=(TextView)view.findViewById(R.id.h_name);
            k_name=(TextView)view.findViewById(R.id.k_name);

        }
    }
}
