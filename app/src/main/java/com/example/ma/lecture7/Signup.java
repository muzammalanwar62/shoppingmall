package com.example.ma.lecture7;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Signup extends AppCompatActivity {
     EditText Name,username,password,email,address,cell;
    Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
     Name= (EditText) findViewById(R.id.nametxt);
        username= (EditText) findViewById(R.id.usertxt);
        password= (EditText) findViewById(R.id.passwordtxt);
        email= (EditText) findViewById(R.id.emailtxt);
        address= (EditText) findViewById(R.id.addresstxt);
        cell= (EditText) findViewById(R.id.celltxt);
        signup=(Button)findViewById(R.id.signup_btn);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register_Customer rc=new Register_Customer(Signup.this);
                rc.execute(username.getText().toString(),password.getText().toString(),Name.getText().toString(),email.getText().toString(),address.getText().toString(),cell.getText().toString());
            }
        });



    }

}
