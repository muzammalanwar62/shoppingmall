package com.example.ma.lecture7;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
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

/**
 * Created by MA on 7/13/2017.
 */

public class logintask extends AsyncTask {
    String Username;
    String Password;
    Customers customers;
    Context context;
    public  logintask(String Username,String Password,Context context){
        this.Username=Username;
        this.Password=Password;
        customers=new Customers();
        this.context=context;
    }
    @Override
    protected Object doInBackground(Object[] params) {
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
                JSONObject jo=array.getJSONObject(i);
                customers.setCell(jo.getString("Cell"));
                customers.setAddress(jo.getString("Address"));
                customers.setEmail(jo.getString("Email"));
                customers.setName(jo.getString("Name"));
                customers.setUsername(jo.getString("Username"));
                customers.setLoginstatus(jo.getString("status"));
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
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        if(customers.getLoginstatus()=="login success"){
            Toast.makeText(context,customers.getLoginstatus(),Toast.LENGTH_LONG).show();
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
            sp.edit().putBoolean("IsLogin",true).commit();
            sp.edit().putString("Name",customers.getName()).commit();
            sp.edit().putString("Address", customers.getAddress()).commit();
            sp.edit().putString("Email", customers.getEmail()).commit();
            sp.edit().putString("Cell", customers.getCell()).commit();
            sp.edit().putString("Username", customers.getUsername()).commit();

        }else{
            Toast.makeText(context,"Login Failed",Toast.LENGTH_LONG).show();
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
            sp.edit().putBoolean("IsLogin",false);

        }

    }
}
