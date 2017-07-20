package com.example.ma.lecture7;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by MA on 7/5/2017.
 */

public class cart_listitem_adapter extends RecyclerView.Adapter<cartviewholder> {
ArrayList<products> productsArrayList;
    Context context;

    public cart_listitem_adapter(ArrayList<products> productsArrayList, Context context) {
        this.productsArrayList = productsArrayList;
        this.context = context;
    }

    @Override
    public cartviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.shoping_cart_list_layout,parent,false);

        return new cartviewholder(v) ;
    }

    @Override
    public void onBindViewHolder(final cartviewholder holder, int position) {
    final products prodcts=productsArrayList.get(position);
        holder.name.setText(prodcts.getName());
        holder.price.setText(String.valueOf(prodcts.getPrice()));
        holder.quantity.setText(String.valueOf(prodcts.getQuantity()));
       // holder.cartimage.setImageResource(prodcts.getImage());
        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              prodcts.quantity++;
                prodcts.setQuantity(prodcts.quantity++);
                holder.quantity.setText(String.valueOf(prodcts.getQuantity()));
            }
        });
        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(prodcts.quantity!=1) {
                    prodcts.quantity--;

                    prodcts.setQuantity(prodcts.quantity--);
                    holder.quantity.setText(String.valueOf(prodcts.getQuantity()));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return productsArrayList.size();
    }
}
 class cartviewholder extends RecyclerView.ViewHolder {
     ImageView cartimage,plus,minus;
     TextView name,price,quantity;
     public cartviewholder(View itemView) {
         super(itemView);
         cartimage=(ImageView) itemView.findViewById(R.id.cart_list_image);
         plus=(ImageView) itemView.findViewById(R.id.cart_plus_img);
         minus= (ImageView) itemView.findViewById(R.id.cart_minus_img);
         name= (TextView) itemView.findViewById(R.id.cart_itemlist_name);
         price= (TextView) itemView.findViewById(R.id.cart_item_price);
         quantity= (TextView) itemView.findViewById(R.id.cart_listitem_quantity);
     }
 }