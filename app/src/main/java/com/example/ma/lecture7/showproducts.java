package com.example.ma.lecture7;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class showproducts extends AppCompatActivity {
RecyclerView productslist;
    ArrayList<products> productsArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showproducts);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String Catorgery=getIntent().getStringExtra("Catorgery");
        getSupportActionBar().setTitle(Catorgery);
        productslist=(RecyclerView) findViewById(R.id.productslist);
        productslist.setLayoutManager(new GridLayoutManager(showproducts.this,2));
      /*  productsArrayList=new ArrayList<>();
        productsArrayList.add(new products("HTC ONE",15000,R.drawable.mobile,2));
        productsArrayList.add(new products("Samsung Galaxy S8",5000000,R.drawable.mobile,2));*/
        //productslist.setAdapter(new productlistadapter(productsArrayList,showproducts.this));
          new gets_product_task(showproducts.this,productslist).execute(Catorgery);
    }

}
