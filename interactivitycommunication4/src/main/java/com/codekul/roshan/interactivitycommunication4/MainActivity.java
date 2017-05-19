package com.codekul.roshan.interactivitycommunication4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static final int MY_KEY1 = 1111;
    public static final int MY_KEY2 = 2222;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.imgFinger).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Button)findViewById(R.id.btnSEARCH)).setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.btnSEARCH).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,NextActivity.class);

                Bundle bundle=new Bundle();
                intent.putExtras(bundle);

                startActivityForResult(intent,MY_KEY1);
                startActivityForResult(intent,MY_KEY2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1111:

                if (resultCode == RESULT_OK && (data != null)) {
                    ((ImageView) findViewById(R.id.imgMainView)).setImageResource(R.drawable.hahaha);
                }
                break;
            case 2222:
                if (resultCode == RESULT_OK && (data != null))
                {
                    ((ImageView) findViewById(R.id.imgMainView)).setImageResource(R.drawable.liar);
                }
        }
    }
}

