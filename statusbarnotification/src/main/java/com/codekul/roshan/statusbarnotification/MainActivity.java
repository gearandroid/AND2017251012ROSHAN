package com.codekul.roshan.statusbarnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private NotificationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public void onNotify(View view) {

        //intent to open new activity
        Intent intent = new Intent(this,NotificationActivity.class);
        //pending intent to make new activity pending till u click on the notification and ***
        PendingIntent pendingIntent = PendingIntent.getActivity(this,2222,intent,PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder builder=new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("Notification");
        builder.setContentInfo("Notification about XXX");
        builder.setContentText("Demo Text");

        builder.setDefaults(Notification.DEFAULT_ALL);
        builder.setOngoing(true);
        builder.setAutoCancel(true);

        //*** setting the pendingintent here
        builder.setContentIntent(pendingIntent);

        Notification notification =builder.build();

        manager.notify(1234,notification);

    }
}
