package com.codekul.roshan.assignment1cricketplayersapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLogin(View view) {
        String uname=((EditText)findViewById(R.id.edtUsername)).getText().toString();
        String password=((EditText)findViewById(R.id.edtPassword)).getText().toString();

        if(uname.equals("1") && password.equals("1")){
            startActivity(new Intent(this,PLayerList.class));
        }else {
            ((TextView)findViewById(R.id.txtMessage)).setText("Wrong Credentials..Retry..!!");
        }
    }
}
