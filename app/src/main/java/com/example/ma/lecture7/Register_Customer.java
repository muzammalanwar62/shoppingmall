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

/**
 * Created by MA on 7/14/2017.
 */

public class Register_Customer extends AsyncTask<String,Void,Void> {
    String status;
    Context context;

    public Register_Customer(Context context) {
        this.context = context;
    }

    @Override
    protected Void doInBackground(String... params) {
        String Username=params[0];
        String Password=params[1];
        String Name=params[2];
        String Email=params[3];
        String Address=params[4];
        String Cell=params[5];
        try {
            URL url=new URL("https://helloworldshopingmall.000webhostapp.com/Signup.php");
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
            StringBuffer data=new StringBuffer();
            data.append(URLEncoder.encode("username","UTF-8"));
            data.append("=");
            data.append(URLEncoder.encode(Username,"UTF-8"));
            data.append("&");
            data.append(URLEncoder.encode("password","UTF-8"));
            data.append("=");
            data.append(URLEncoder.encode(Password,"UTF-8"));
            data.append("&");
            data.append(URLEncoder.encode("Name","UTF-8"));
            data.append("=");
            data.append(URLEncoder.encode(Name,"UTF-8"));
            data.append("&");
            data.append(URLEncoder.encode("Address","UTF-8"));
            data.append("=");
            data.append(URLEncoder.encode(Address,"UTF-8"));
            data.append("&");
            data.append(URLEncoder.encode("Cell","UTF-8"));
            data.append("=");
            data.append(URLEncoder.encode(Cell,"UTF-8"));
            data.append("&");
            data.append(URLEncoder.encode("Email","UTF-8"));
            data.append("=");
            data.append(URLEncoder.encode(Email,"UTF-8"));

            writer.write(data.toString());
            writer.flush();
            writer.close();
            BufferedReader reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String Json;
            StringBuffer sb=new StringBuffer();
            while((Json=reader.readLine())!=null){
                sb.append(Json);
            }
           status=sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Toast.makeText(context,status,Toast.LENGTH_LONG).show();
    }
}
