package com.codekul.roshan.compoundviewdemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    //1: create object of LayoutInflater
    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2: Set id to Main.xml and have a LinearLayout object
        LinearLayout layoutroot= (LinearLayout)findViewById(R.id.layoutroot);

        //3: Obtain the LayoutInflater from the current context
        inflater=LayoutInflater.from(this);

        //4: inflate method:takes name of xml to bind,main layout,boolean value-to show it on Main
        // Layout or not
        View view=inflater.inflate(R.layout.compound,layoutroot,true);

        //5: Provide desired action on click
        findViewById(R.id.imgStar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TextView)findViewById(R.id.txtSubtitle)).setText("Great..You rated a star! ");
            }
        });
    }
}
