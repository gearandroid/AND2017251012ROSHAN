package com.codekul.roshan.toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onToast(View view) {

        //one way of displaying toast
          Toast toast = Toast.makeText(this,"This is Toast",Toast.LENGTH_LONG);
//        toast.show();

        //Another way

        Button btn = new Button(this);
        btn.setText("TEXT");
        toast.setView(btn);
        toast.show();

    }
}
