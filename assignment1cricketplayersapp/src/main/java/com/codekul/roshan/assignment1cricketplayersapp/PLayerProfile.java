package com.codekul.roshan.assignment1cricketplayersapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PLayerProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_profile);

        Intent intentResp = getIntent();
        Bundle bundle = intentResp.getExtras();


        if(bundle != null) {

             String currentName = bundle.getString(PLayerList.P_NAME);
             String currentAge = bundle.getString(PLayerList.P_AGE);
            if(currentName.equals(" ")) {

                findViewById(R.id.btnAddNewPlayer).setEnabled(false);
            }

           // ((TextView) findViewById(R.id.txtPlayerName)).setText(currentName);
            //((TextView)findViewById(R.id.txtplrProfAge)).setText(currentAge);

        }

        findViewById(R.id.imgLikeGray).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(findViewById(R.id.imgLikeGray).getTag().equals("gray")){
                    ((ImageView)findViewById(R.id.imgLikeGray)).setImageResource(R.drawable.ic_like);
                    findViewById(R.id.imgLikeGray).setTag("red");
                }else {
                    ((ImageView)findViewById(R.id.imgLikeGray)).setImageResource(R.drawable.ic_likegray);
                    findViewById(R.id.imgLikeGray).setTag("gray");

                }
            }
        });

    }

    public void onAdd(View view) {
        startActivity(new Intent(PLayerProfile.this,PlayerProfileAdd.class));
        finish();
    }
}
