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

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by MA on 7/3/2017.
 */

public class productlistadapter extends RecyclerView.Adapter<productsviewholder> {
    ArrayList<products> productsArrayList;Context context;
    public productlistadapter(ArrayList<products> productsArrayList, Context context){
        this.productsArrayList=productsArrayList;
        this.context=context;
    }
    @Override
    public productsviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.productlistlayout,parent,false);
        return new productsviewholder(v);
    }

    @Override
    public void onBindViewHolder(productsviewholder holder, int position) {
        final products pro=productsArrayList.get(position);
        holder.productname.setText(pro.getName());
        if (pro.getDiscount()!= 0){
            holder.productprice.setText("Rs:"+String.valueOf(pro.getDiscount()));

        }
        else  if (pro.getDiscount()==0){
            holder.productprice.setText("Rs:"+String.valueOf(pro.getPrice()));
        }

        Picasso.with(context).load(pro.getImage()).into(holder.productimg);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context,product_details.class);
                intent.putExtra("Specifications",pro.getSpecification());
                intent.putExtra("Image",pro.getImage());
                intent.putExtra("Name",pro.getName());
                intent.putExtra("ID", pro.getId());
                intent.putExtra("PRICE",pro.getPrice());
                intent.putExtra("DISCOUNT",pro.getDiscount());
                intent.putExtra("QUANTITY",pro.getQuantity());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productsArrayList.size();
    }
}
class productsviewholder extends RecyclerView.ViewHolder{
TextView productname,productprice;
    CardView cardView;
    ImageView productimg;
    public productsviewholder(View itemView) {
        super(itemView);
        productname=(TextView) itemView.findViewById(R.id.productname);
        productprice=(TextView) itemView.findViewById(R.id.productprice);
        productimg=(ImageView) itemView.findViewById(R.id.productimg);
        cardView= (CardView) itemView.findViewById(R.id.productcard);
    }
}
