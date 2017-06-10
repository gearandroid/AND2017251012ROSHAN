package com.codekul.roshan.intentandintentfilters;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        //test();
        call();
        //dial();
    }

    private void test() {

        Intent intent = new Intent();
        //intent.setAction("com.codekul.intent.Red");
        //intent.setAction("com.codekul.intent.Green");
        //intent.setAction("android.intent.action.Blue");

        intent.addCategory("android.intent.category.Blue");
        //intent.setData(Uri.parse("http://codekul.com"));
        startActivity(intent);
    }

    public  void call(){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel://9657855046"));
        //startActivity(intent);
    }
    public void dial(){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        startActivity(intent);
    }
}
