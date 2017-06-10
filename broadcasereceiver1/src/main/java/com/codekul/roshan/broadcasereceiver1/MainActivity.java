package com.codekul.roshan.broadcasereceiver1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"Air Plane Mode Changed", Toast.LENGTH_LONG).show();
            if(intent.getBooleanExtra("state",false)){
                ((ImageView)findViewById(R.id.imgPlane)).setImageResource(R.drawable.ic_airplanemode_active_black_24dp);
            }else {
                ((ImageView)findViewById(R.id.imgPlane)).setImageResource(R.drawable.ic_airplanemode_inactive_black_24dp);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);

        registerReceiver(receiver,filter);
        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(receiver);
        super.onStop();
    }
}
