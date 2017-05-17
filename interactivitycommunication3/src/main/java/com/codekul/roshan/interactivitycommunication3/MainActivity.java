package com.codekul.roshan.interactivitycommunication3;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import static com.codekul.roshan.interactivitycommunication3.R.drawable.androidglows;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_MY_CODE = 2222;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnMagnify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ImageView) findViewById(R.id.imgMain)).setImageResource(R.drawable.androidglows);
            }
        });


        findViewById(R.id.btnNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,NextActivity.class);

                Bundle bundle=new Bundle();

                intent.putExtras(bundle);

                startActivityForResult(intent,2222);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        //((ImageView)findViewById(R.id.imgMain)).setImageResource(R.drawable.menu);
        if(requestCode == REQUEST_MY_CODE){
            if(requestCode == RESULT_OK){

                //findViewById(R.id.relMain).setBackgroundColor(Color.BLUE);
                ((ImageView)findViewById(R.id.imgMain)).setImageResource(R.drawable.menu);

            }
        }
    }
}
