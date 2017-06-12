package com.codekul.roshan.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref = getSharedPreferences("my_preference",MODE_APPEND);
    }


    public void onWrite(View view) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("aBoolean",true);
        editor.putFloat("aFloat",33.4f);
        editor.putString("aString","Its a string");
        editor.apply();
    }

    public void onRead(View view) {
        Boolean _boolean = pref.getBoolean("aBoolean",false);
        Float _float = pref.getFloat("aFloat", 11.11f);
        String _string = pref.getString("aString","No String");

        Log.i(TAG,"Boolean"+_boolean+"Float"+_float+"String"+_string);
        ((TextView)findViewById(R.id.txtInfo)).setText("Boolean"+_boolean+"Float"+_float+"String"+_string);
    }
}
