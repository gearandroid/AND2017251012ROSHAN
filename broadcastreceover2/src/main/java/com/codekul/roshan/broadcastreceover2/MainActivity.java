package com.codekul.roshan.broadcastreceover2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

        }
    };
    //This broadcast receiver will work even if the App is not running as, for the registration of the
    //broadcast receiver, one new broadcast receiver class is created and the broadcast receiver registered
    // in the Manifest file: there the action is mentioned: Check that
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
