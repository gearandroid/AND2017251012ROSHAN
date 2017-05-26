package com.codekul.roshan.compoundview4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inflater = LayoutInflater.from(this);

        findViewById(R.id.btnShow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FrameLayout frameOne=(FrameLayout) findViewById(R.id.frameOne);
                frameOne.removeAllViews();
                FrameLayout frameTwo=(FrameLayout) findViewById(R.id.frameTwo);
                frameTwo.removeAllViews();

                View inflatedview1=inflater.inflate(R.layout.mycompound,frameOne,true);
                //frameOne.addView(view1); --this can also be used to add the compound view..
                //..to the frame but in that case, the 3rd parameter of inflate() should be false

                ((CheckBox)inflatedview1.findViewById(R.id.chkBox)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        ((TextView)findViewById(R.id.txtView)).setText(Boolean.toString(isChecked));
                    }
                });

                View inflatedview2=inflater.inflate(R.layout.mycompound,frameTwo,true);
                ((CheckBox)inflatedview2.findViewById(R.id.chkBox)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        ((TextView)findViewById(R.id.txtView)).setText(Boolean.toString(isChecked));
                    }
                });

            }
        });
    }
}
