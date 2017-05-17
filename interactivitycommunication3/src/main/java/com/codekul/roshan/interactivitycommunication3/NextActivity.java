package com.codekul.roshan.interactivitycommunication3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Intent responsibleIntent=getIntent();

        Bundle bundle=responsibleIntent.getExtras();

        if(bundle != null){

            ((ImageView)findViewById(R.id.imgNext)).setImageResource(R.drawable.androidglows);
        }


        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();

                Bundle bundleBack=new Bundle();

                intent.putExtras(bundleBack);

                setResult(RESULT_OK,intent);

                finish();


            }
        });

    }
}
