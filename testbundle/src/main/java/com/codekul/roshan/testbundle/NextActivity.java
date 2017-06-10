package com.codekul.roshan.testbundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        ((ImageView)findViewById(R.id.imgNxt)).setImageResource(bundle.getInt(MainActivity.KEY_PIC));
    }
}
