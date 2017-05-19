package com.codekul.roshan.interactivitycommunication4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.StringTokenizer;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Intent intentResponsible = getIntent();
        Bundle bundle=intentResponsible.getExtras();

        if(bundle != null){
            ((Button)findViewById(R.id.btnGenerate)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((ImageView)findViewById(R.id.imgGenerate)).setImageResource(R.drawable.monkey);
                }
            });
        }

       findViewById(R.id.btnAccept).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Bundle bundle=new Bundle();
               bundle.putInt("KEY1",1111);

               Intent intentAccept=new Intent();
               intentAccept.putExtras(bundle);

               setResult(RESULT_OK,intentAccept);
               finish();

           }
       });

        findViewById(R.id.btnDeny).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                bundle.putInt("KEY2",2222);

                Intent intentDeny=new Intent();
                intentDeny.putExtras(bundle);

                setResult(RESULT_OK,intentDeny);
                finish();
            }
        });
    }
}
