package com.codekul.roshan.broadcastreceover2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"App Not Running: Airplane Mode Changed",Toast.LENGTH_LONG).show();
    }
}
