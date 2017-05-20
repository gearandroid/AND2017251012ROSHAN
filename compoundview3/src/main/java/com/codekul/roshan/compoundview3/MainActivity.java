package com.codekul.roshan.compoundview3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private static final String NET_AVAIL = "Networks are available";
    private static final String NET_NOT_AVAIL = "To see available networks, turn Wi-Fi on.";
    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Switch mySwitch;
        LinearLayout layoutroot=(LinearLayout)findViewById(R.id.layoutroot);

        inflater = LayoutInflater.from(this);

        inflater.inflate(R.layout.mycompound,layoutroot,true);

        mySwitch = (Switch)findViewById(R.id.swSwitch);
        mySwitch.setChecked(false);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(mySwitch.isChecked())
                    ((TextView) findViewById(R.id.txtDisplay)).setText(NET_AVAIL);
                else
                    ((TextView) findViewById(R.id.txtDisplay)).setText(NET_NOT_AVAIL);
            }
        });
    }
}
