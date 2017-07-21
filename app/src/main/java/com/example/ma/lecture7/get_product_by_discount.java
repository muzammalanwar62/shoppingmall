package com.example.ma.lecture7;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by MA on 7/20/2017.
 */

public class get_product_by_discount extends AsyncTask {
    ArrayList<products>arrayList;
    Context context;

    RecyclerView.Adapter rvadapter;

    public get_product_by_discount(Context context, RecyclerView rv) {
        this.context = context;
        this.rv = rv;
        arrayList=new ArrayList<>();
        rvadapter=new Discount_adapter(arrayList,context);
    }

    RecyclerView rv;


    @Override
    protected Object doInBackground(Object[] params) {
        try {
            URL url = new URL("https://helloworldshopingmall.000webhostapp.com/get_products_by_discount.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String Json;
            StringBuffer sb = new StringBuffer();
            while ((Json = reader.readLine()) != null) {
                sb.append(Json);
            }
            JSONArray jarray=new JSONArray(sb.toString());
            for (int i=0;i<jarray.length();i++){
                JSONObject jo=jarray.getJSONObject(i);
                products p=new products();
                p.setName(jo.getString("Name"));
                p.setCatorgery(jo.getString("Category"));
                p.setQuantity(jo.getInt("Quantity"));
                p.setImage(jo.getString("Image"));
                p.setDiscount(jo.getInt("discount"));
                p.setPrice(jo.getInt("Price"));
                p.setSpecification(jo.getString("Specifications"));
                arrayList.add(p);
            }
        } catch (Exception e){

        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        rv.setAdapter(rvadapter);
    }
}
