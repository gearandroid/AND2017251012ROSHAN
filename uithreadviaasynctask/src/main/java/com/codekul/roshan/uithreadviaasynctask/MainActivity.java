package com.codekul.roshan.uithreadviaasynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onGo(View view) {

    }
    //followig generic class has parameters as<params type,progress type,result Boolean>
    private class MyTask extends AsyncTask<Integer,Integer, Boolean>{

        @Override
        //result type is Boolean here
        protected  Boolean doInBackground(Integer... params) {
            for(i=params[0];i<=params[100];i++){

            }
            return null;
        }
    }
}
