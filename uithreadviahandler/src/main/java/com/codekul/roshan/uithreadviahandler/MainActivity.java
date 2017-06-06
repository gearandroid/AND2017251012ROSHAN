package com.codekul.roshan.uithreadviahandler;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//Concept of handler is we need a handler which uses Looper which runs message loop for a thread
    //New thread will not touch the views rather it will execute and post the update to the main UI
    //If we dont use looper in thread, exception will arise from handler

    //So, flow is on button click=> new Thread(new Runnable), in new Thread=>handler(Looper)
    // .post(new Runnable)=>business logic.

    public void onStart(View view) {
        workerHandler();
    }

    private void workerHandler(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(i=0;i<=100;i++){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //we add handler here where Looper.getMainLooper() posts the progress to the main UI
                    new Handler(Looper.getMainLooper()).post(new Runnable() {

                        @Override
                        public void run() {
                            ((TextView)findViewById(R.id.txtCounter)).setText(String.valueOf(i));
                        }
                    });
                }
            }
        }).start();
    }


}
