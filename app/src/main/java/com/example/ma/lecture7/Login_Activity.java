package com.example.ma.lecture7;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login_Activity extends AppCompatActivity {
EditText username,password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        username=(EditText) findViewById(R.id.usernametxt);
        password=(EditText) findViewById(R.id.passwordtxt);
        login=(Button) findViewById(R.id.login_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authenticate_customer auth=new authenticate_customer(Login_Activity.this);
                auth.execute(username.getText().toString(),password.getText().toString());
            }
        });
    }

}
