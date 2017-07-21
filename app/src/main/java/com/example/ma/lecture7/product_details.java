package com.example.ma.lecture7;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
    CartDB cdb = new CartDB(product_details.this);
    String specs,name,img, username;
    int id, price, discount, quantity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        text1= (TextView) findViewById(R.id.specs);
        ImageView productimage=(ImageView) findViewById(R.id.productimage);
        listView= (ListView) findViewById(R.id.specsdetail);
      specs=getIntent().getStringExtra("Specifications");
         name=getIntent().getStringExtra("Name");
        img=getIntent().getStringExtra("Image");
        id=getIntent().getIntExtra("ID",0);
         discount=getIntent().getIntExtra("DISCOUNT",0);
        price=getIntent().getIntExtra("PRICE",0);
         quantity=getIntent().getIntExtra("QUANTITY",0);
        String[] words=specs.split(",");
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
                SharedPreferences spc = PreferenceManager.getDefaultSharedPreferences(product_details.this);
                username = spc.getString("Username",null);
                if(discount!=0) {
                  boolean b= cdb.insert_item_to_cart(name, price, quantity, img, username);
                    if(b){
                         Snackbar.make(view, "Product Added To Cart", Snackbar.LENGTH_LONG).show();

                        //.setAction("Action", null).show();
                    }
                    else if(!b){
                        Snackbar.make(view, "Process Failed", Snackbar.LENGTH_LONG).show();
                    }
                }

               /* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });
        Picasso.with(product_details.this).load(getIntent().getStringExtra("Image")).into(productimage);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter(this,R.layout.bullet_list_layout, words);
        listView.setAdapter(arrayAdapter);
    }
}
