package com.example.ma.lecture7;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by MA on 7/14/2017.
 */

public class authenticate_customer extends AsyncTask<String,Void,Void> {
    ArrayList<Customers> customerses;
    Context context;
    public authenticate_customer(Context context){
        this.context=context;
        customerses=new ArrayList<>();
    }
    @Override
    protected Void doInBackground(String... params) {
        String Username=params[0];
        String Password=params[1];
        try {
            URL url=new URL("https://helloworldshopingmall.000webhostapp.com/customerlogin.php");
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
            StringBuffer data=new StringBuffer();
            data.append(URLEncoder.encode("Username","UTF-8"));
            data.append("=");
            data.append(URLEncoder.encode(Username,"UTF-8"));
            data.append("&");
            data.append(URLEncoder.encode("Password","UTF-8"));
            data.append("=");
            data.append(URLEncoder.encode(Password,"UTF-8"));
            writer.write(data.toString());
            writer.flush();
            writer.close();
            BufferedReader reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String Json;
            StringBuffer sb=new StringBuffer();
            while((Json=reader.readLine())!=null){
                sb.append(Json);
            }
            JSONArray array=new JSONArray(sb.toString());
            for(int i=0; i<array.length();i++){
                Customers customers=new Customers();
                JSONObject jo=array.getJSONObject(i);
                customers.setCell(jo.getString("Cell"));
                customers.setAddress(jo.getString("Address"));
                customers.setEmail(jo.getString("Email"));
                customers.setName(jo.getString("Name"));
                customers.setUsername(jo.getString("Username"));
                customers.setLoginstatus(jo.getString("status"));
                customerses.add(customers);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if(customerses.size()!=0){
            Toast.makeText(context,customerses.get(0).getLoginstatus(),Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(context,"Login Failed",Toast.LENGTH_LONG).show();
        }
    }
}
