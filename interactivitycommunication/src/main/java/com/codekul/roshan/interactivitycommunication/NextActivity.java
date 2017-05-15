package com.codekul.roshan.interactivitycommunication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        final Intent nxtintent=getIntent();

         Bundle bundle=nxtintent.getExtras();

        if(bundle != null){

            String date= bundle.getString("keyDate");
            ((TextView)findViewById(R.id.txtNext)).setText(date);
        }
    }

    public void onImageAndroid(View view) {
        Bundle bundle=new Bundle();
        bundle.putInt("keyImg",R.drawable.andro);

        Intent intent=new Intent();
        intent.putExtras(bundle);
        setResult(RESULT_OK,intent);

        finish();
    }

    public void onImageApple(View view) {
        Bundle bundle =new Bundle();
        bundle.putInt("keyImg",R.drawable.apple);

        Intent intent=new Intent();
        intent.putExtras(bundle);
        setResult(RESULT_OK,intent);
        finish();
    }

    public void onImageWindows(View view) {
        Bundle bundle=new Bundle();
        bundle.putInt("keyImg",R.drawable.windows);

        Intent intent=new Intent();
        intent.putExtras(bundle);
        setResult(RESULT_OK,intent);
        finish();
    }
}
