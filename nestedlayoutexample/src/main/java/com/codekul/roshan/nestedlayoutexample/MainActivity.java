package com.codekul.roshan.nestedlayoutexample;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText txtText = (EditText)findViewById(R.id.txtTextBT);
        //txtText.setEnabled(false);
        txtText.setTextColor(Color.BLACK);

        EditText txtTextWF=(EditText) findViewById(R.id.txtTextWF);
        txtTextWF.setEnabled(false);
        txtTextWF.setTextColor(Color.BLACK);

    }
}
