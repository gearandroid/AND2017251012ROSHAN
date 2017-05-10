package com.codekul.roshan.expressioncalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layoutroot=new LinearLayout(this);
        layoutroot.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams paramroot=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        layoutroot.setLayoutParams(paramroot);

        final EditText txtInput=new EditText(this);
        txtInput.setHint("Type Expression");
        LinearLayout.LayoutParams paramtxtinput=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        txtInput.setLayoutParams(paramtxtinput);
        layoutroot.addView(txtInput);

        final EditText txtOutput=new EditText(this);
        txtOutput.setHint("Get Answer");
        LinearLayout.LayoutParams paramtxtoutput=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        txtInput.setLayoutParams(paramtxtoutput);
        layoutroot.addView(txtOutput);

        Button btn=new Button(this);
        btn.setText("CALCULATE");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtOutput.setText("14");
            }
        });
        LinearLayout.LayoutParams parambtn=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        btn.setLayoutParams(parambtn);
        layoutroot.addView(btn);


        setContentView(layoutroot);

    }
}
