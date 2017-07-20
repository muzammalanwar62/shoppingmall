package com.example.ma.lecture7;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by MA on 7/16/2017.
 */

public class gets_product_task extends AsyncTask<String,Void,Void> {
    Context context;
    ArrayList<products> arrayList;
    RecyclerView.Adapter rvadapter;

    public gets_product_task(Context context, RecyclerView rv) {
        this.context = context;
        this.rv = rv;
        arrayList=new ArrayList<>();
        rvadapter=new productlistadapter(arrayList,context);
    }

    RecyclerView rv;




    @Override
    protected Void doInBackground(String... params) {
        String Categorie=params[0];
        try {
            URL url = new URL("https://helloworldshopingmall.000webhostapp.com/get_products_by_catorgery.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
            StringBuffer data = new StringBuffer();
            data.append(URLEncoder.encode("Category", "UTF-8"));
            data.append("=");
            data.append(URLEncoder.encode(Categorie, "UTF-8"));
            writer.write(data.toString());
            writer.flush();
            writer.close();
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
                p.setDiscount(jo.getString("discount"));
                p.setPrice(jo.getString("Price"));
                p.setSpecification(jo.getString("Specifications"));
                arrayList.add(p);
            }

        }
        catch (Exception e) {
                e.printStackTrace();
            }
            return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
      rv.setAdapter(rvadapter);

    }
}
