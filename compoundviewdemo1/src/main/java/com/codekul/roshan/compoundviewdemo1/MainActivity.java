package com.codekul.roshan.compoundviewdemo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layout=(LinearLayout) findViewById(R.id.layoutroot);

        inflater = LayoutInflater.from(this);

        final View view=inflater.inflate(R.layout.compoundview,layout,true);
        ((ImageView)view.findViewById(R.id.imgFinger)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TextView)view.findViewById(R.id.txtText)).setText("Matched: Lock Opened");
            }
        });

    }
}
