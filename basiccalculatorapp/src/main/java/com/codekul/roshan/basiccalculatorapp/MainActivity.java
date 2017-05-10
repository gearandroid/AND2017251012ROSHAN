
package com.codekul.roshan.basiccalculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
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

        final EditText txtOne=new EditText(this);
        txtOne.setHint("Type First Number");
        LinearLayout.LayoutParams paramtxtOne=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        txtOne.setLayoutParams(paramtxtOne);
        layoutroot.addView(txtOne);

        final EditText txtTwo=new EditText(this);
        txtTwo.setHint("Type Second Number");
        LinearLayout.LayoutParams paramtxtTwo=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        txtOne.setLayoutParams(paramtxtTwo);
        layoutroot.addView(txtTwo);

        final EditText txtResult=new EditText(this);
        txtResult.setHint("RESULT");
        LinearLayout.LayoutParams paramtxtResult=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        txtOne.setLayoutParams(paramtxtResult);
        layoutroot.addView(txtResult);

        Button btnAdd=new Button(this);
        btnAdd.setText("+");
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Integer num1=Integer.parseInt(txtOne.getText().toString());
                    Integer num2=Integer.parseInt(txtTwo.getText().toString());
                    String result=Integer.toString(num1+num2);
                    txtResult.setText(result);

            }
        });
        LinearLayout.LayoutParams paramAdd=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        btnAdd.setLayoutParams(paramAdd);
        layoutroot.addView(btnAdd);

        Button btnSub=new Button(this);
        btnSub.setText("-");
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer num1=Integer.parseInt(txtOne.getText().toString());
                Integer num2=Integer.parseInt(txtTwo.getText().toString());
                String result=Integer.toString(num1-num2);
                txtResult.setText(result);
            }
        });


        LinearLayout.LayoutParams paramSub=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        btnAdd.setLayoutParams(paramSub);
        layoutroot.addView(btnSub);

        Button btnMult=new Button(this);
        btnMult.setText("x");
        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer num1=Integer.parseInt(txtOne.getText().toString());
                Integer num2=Integer.parseInt(txtTwo.getText().toString());
                String result=Integer.toString(num1*num2);
                txtResult.setText(result);
            }
        });
        LinearLayout.LayoutParams paramMult=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        btnAdd.setLayoutParams(paramMult);
        layoutroot.addView(btnMult);

        Button btnDiv=new Button(this);
        btnDiv.setText("/");
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer num1=Integer.parseInt(txtOne.getText().toString());
                Integer num2=Integer.parseInt(txtTwo.getText().toString());
                String result=Double.toString(num1/num2);
                txtResult.setText(result);
            }
        });
        LinearLayout.LayoutParams paramDiv=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        btnAdd.setLayoutParams(paramDiv);
        layoutroot.addView(btnDiv);

        Button btnReset=new Button(this);
        btnReset.setText("RESET FIELDS");
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtOne.setText(" ");
                txtTwo.setText(" ");
                txtResult.setText(" ");
            }
        });
        LinearLayout.LayoutParams paramReset=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        btnAdd.setLayoutParams(paramReset);
        layoutroot.addView(btnReset);

        setContentView(layoutroot);
    }
}
