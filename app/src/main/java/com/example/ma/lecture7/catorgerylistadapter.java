package com.example.ma.lecture7;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by MA on 6/30/2017.
 */

public class catorgerylistadapter extends RecyclerView.Adapter<viewholder> {
    ArrayList<catorgery> catorgerylist;
    Context context;
    public catorgerylistadapter(ArrayList<catorgery> catorgerylist, Context context){
        this.catorgerylist=catorgerylist;
        this.context=context;
    }
    @Override
    public viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
      View v=  LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_layout,parent,false);
        return new viewholder(v);
    }

    @Override
    public void onBindViewHolder(viewholder holder, int position) {
       final catorgery catorger= catorgerylist.get(position);
       holder.catorgeryimage.setImageResource(catorger.getImage());
        holder.name.setText(catorger.getCatorgeryname());
        holder.catorgerycard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,showproducts.class);
                i.putExtra("Catorgery",catorger.getCatorgeryname());
                        context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return catorgerylist.size();
    }
}
class viewholder extends RecyclerView.ViewHolder{
ImageView catorgeryimage;
    CardView catorgerycard;
    TextView name;
    public viewholder(View itemView) {
        super(itemView);
        catorgeryimage=(ImageView) itemView.findViewById(R.id.img);
        catorgerycard=(CardView) itemView.findViewById(R.id.catorgerycard);
        name=(TextView) itemView.findViewById(R.id.catorgerytxt);
    }
}
