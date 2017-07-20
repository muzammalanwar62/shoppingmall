package com.example.ma.lecture7;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class shoping_cart extends AppCompatActivity {
    RecyclerView productslist;
    ArrayList<products> productsArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoping_cart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       /* productslist=(RecyclerView) findViewById(R.id.cart_itemlist);
        productslist.setLayoutManager(new LinearLayoutManager(shoping_cart.this));
        productsArrayList=new ArrayList<>();
        productsArrayList.add(new products("HTC ONE",15000,R.drawable.mobile,2));
        productsArrayList.add(new products("Samsung Galaxy S8",5000000,R.drawable.mobile,2));
        productslist.setAdapter(new cart_listitem_adapter(productsArrayList,shoping_cart.this));*/
    }

}
