package com.codekul.roshan.testbundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_PIC = "image";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onText(View view) {
        Intent intent = new Intent(this,NextActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_PIC,R.drawable.clogo);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
