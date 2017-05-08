package com.example.roshan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       LinearLayout linearRoot=new LinearLayout(this);
       linearRoot.setOrientation(LinearLayout.VERTICAL);
       //LinearLayout.LayoutParams paramRoot=new LinearLayout.LayoutParams(500,500);
       //Here, the layout should fit to screen i.e, set to window parent,so we set it to MATCH the Parent
       LinearLayout.LayoutParams paramRoot=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
       linearRoot.setLayoutParams(paramRoot);

        final EditText txtbox=new EditText(this);
        txtbox.setHint("Type Here");
        //LinearLayout.LayoutParams paramtxt=new LinearLayout.LayoutParams(500,150);
        //Here, the width should fit to layout parent,so we set it to MATCH the Parent and height should fit according to the entered stuff so WRAP as per CONTENT
        LinearLayout.LayoutParams paramtxt=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        txtbox.setLayoutParams(paramtxt);
        linearRoot.addView(txtbox);

        Button btn=new Button(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strtxt=txtbox.getText().toString();
                txtbox.setText(strtxt.toUpperCase());
            }
        });
        btn.setText("CLICK");
        //LinearLayout.LayoutParams parambtn=new LinearLayout.LayoutParams(500,120);
        LinearLayout.LayoutParams parambtn=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        btn.setLayoutParams(parambtn);
        linearRoot.addView(btn);

        setContentView(linearRoot);

    }
}
