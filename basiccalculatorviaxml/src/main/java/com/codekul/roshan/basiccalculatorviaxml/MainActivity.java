package com.codekul.roshan.basiccalculatorviaxml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtInput1=(EditText)findViewById(R.id.txtInput1);
        final EditText txtInput2=(EditText)findViewById(R.id.txtInput2);
        final EditText txtOutput=(EditText)findViewById(R.id.txtOutput);

        Button btnAdd=(Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer num1=Integer.parseInt(txtInput1.getText().toString());
                Integer num2=Integer.parseInt(txtInput2.getText().toString());

                String result=Integer.toString(num1+num2);
                txtOutput.setText(result);
            }
        });

        Button btnSub=(Button) findViewById(R.id.btnSub);
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer num1=Integer.parseInt(txtInput1.getText().toString());
                Integer num2=Integer.parseInt(txtInput2.getText().toString());

                String result=Integer.toString(num1-num2);
                txtOutput.setText(result);
            }
        });

        Button btnMult=(Button) findViewById(R.id.btnMult);
        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer num1=Integer.parseInt(txtInput1.getText().toString());
                Integer num2=Integer.parseInt(txtInput2.getText().toString());

                String result=Integer.toString(num1*num2);
                txtOutput.setText(result);
            }
        });

        Button btnDiv=(Button) findViewById(R.id.btnDiv);
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer num1=Integer.parseInt(txtInput1.getText().toString());
                Integer num2=Integer.parseInt(txtInput2.getText().toString());

                String result=Double.toString(num1/num2);
                txtOutput.setText(result);
            }
        });

        Button btnReset=(Button) findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtInput1.setText(" ");
                txtInput2.setText(" ");
                txtOutput.setText(" ");
            }
        });
    }
}
