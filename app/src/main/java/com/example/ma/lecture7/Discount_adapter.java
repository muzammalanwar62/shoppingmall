package com.example.ma.lecture7;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by MA on 7/12/2017.
 */

public class Discount_adapter extends RecyclerView.Adapter<discountholder> {
    ArrayList<latest_product> latest_prodct_List;
    Context context;

    public Discount_adapter(ArrayList<latest_product> arrayList, Context context) {
        this.latest_prodct_List = arrayList;
        this.context = context;
    }
    @Override
    public discountholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=  LayoutInflater.from(parent.getContext()).inflate(R.layout.discount_layout,parent,false);
        return new discountholder(v);
    }

    @Override
    public void onBindViewHolder(discountholder holder, int position) {
        latest_product latest=latest_prodct_List.get(position);
        holder.latestimg.setImageResource(latest.getImage());
        holder.productname.setText(latest.getPrdctname());
        holder.productprice.setText(latest.getPrdctprice());
        holder.discount.setText(String.valueOf(latest.getDiscountprice()));
        holder.productprice.setPaintFlags(holder.productprice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,showproducts.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return latest_prodct_List.size();
    }
}
class discountholder extends RecyclerView.ViewHolder{
    ImageView latestimg;
    CardView card;
    TextView productname;
    TextView productprice;
    TextView discount;
    public discountholder(View itemView) {
        super(itemView);
        latestimg=(ImageView) itemView.findViewById(R.id.latestimg);
        card= (CardView) itemView.findViewById(R.id.latestproductscard);
        productname=(TextView) itemView.findViewById(R.id.latesttext1);
        productprice= (TextView) itemView.findViewById(R.id.oldprice);
        discount= (TextView) itemView.findViewById(R.id.discountprice);

    }
}