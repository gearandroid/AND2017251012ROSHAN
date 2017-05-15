package com.codekul.roshan.interactivitycommunication;

import android.content.Intent;
//import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Date;
import java.text.SimpleDateFormat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((TextView)findViewById(R.id.txtDate)).setText(new SimpleDateFormat("dd MMM yyyy").format(new Date()));

    }


    public void goNext(View view) {

        Bundle bundle=new Bundle();
        bundle.putString("keyDate",((TextView)findViewById(R.id.txtDate)).getText().toString());

        //Class cls=NextActivity.class;  this cls can be passed to the source field of Intent class
        //instead we are directly mentioning NextActivity.class as the target.
        Intent intent=new Intent(this,NextActivity.class);
        intent.putExtras(bundle);

        startActivity(intent);
        //If we want to just open a new UI we use this, but if we want some response(i.e result)
        // from the UI to be opened, we use the following i,e. with Result

        startActivityForResult(intent,1111);
        //Opening next activity-passing intent and response code as there can be many responses from
        //different actions done by user
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1111)
        {
            if(resultCode== RESULT_OK){
                if(data != null)
                {
                    Bundle bundle=data.getExtras();
                    int img=bundle.getInt("keyImg");

                    ((ImageView)findViewById(R.id.imgMain)).setImageResource(img);

                }
            }
        }
    }
}
