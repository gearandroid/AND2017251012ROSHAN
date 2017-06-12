package com.codekul.roshan.internalstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "myTextInfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnWrite(View view) throws IOException {
        FileOutputStream fod = openFileOutput("my.txt", MODE_APPEND);
        fod.write("This is the Text".getBytes());
        fod.close();
    }

    public void onRead(View view) throws IOException {
        StringBuilder builder = new StringBuilder();
        FileInputStream fis = openFileInput("my.txt");

        while (true){
            int ch = fis.read();
            if(ch == -1) break;
            else {
                builder.append((char)ch);
            }
        }
        //Text in log is not appearing as required: Will be updated soon
        Log.i(TAG,builder.toString());
        ((TextView)findViewById(R.id.txtInfo)).setText(builder);
    }
}
