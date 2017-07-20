package com.example.ma.lecture7;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class product_details extends AppCompatActivity {
    ViewPager viewPager;
    TextView text1,text2;
    ListView listView;
        ArrayList<Integer> arr=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        text1= (TextView) findViewById(R.id.specs);
        ImageView productimage=(ImageView) findViewById(R.id.productimage);
        listView= (ListView) findViewById(R.id.specsdetail);
        String s1=getIntent().getStringExtra("Specifications");

        String[] words=s1.split(",");

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getIntent().getStringExtra("Name"));
       /* arr.add(R.drawable.mobile);
        arr.add(R.drawable.mobiles);
        arr.add(R.drawable.computer);
        viewPager= (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new ImageSliderAdapter(product_details.this,arr));*/


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Picasso.with(product_details.this).load(getIntent().getStringExtra("Image")).into(productimage);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter(this,R.layout.bullet_list_layout, words);
        listView.setAdapter(arrayAdapter);
    }

}
