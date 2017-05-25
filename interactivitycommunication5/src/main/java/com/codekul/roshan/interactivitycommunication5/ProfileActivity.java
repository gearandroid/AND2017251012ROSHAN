package com.codekul.roshan.interactivitycommunication5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent responsibleintent=getIntent();
        final Bundle bundle =responsibleintent.getExtras();

        String un = bundle.getString("keyUsername");

        if(bundle != null){
                ((TextView)findViewById(R.id.textView3)).setText(un);
        }


        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent();

                Bundle bundle1=new Bundle();

                bundle1.putString("keyRes",getDeviceName());

                intent.putExtras(bundle1);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
    private String getDeviceName(){
        return ((RadioGroup)findViewById(R.id.radioGroup)).getCheckedRadioButtonId()==R.id.rdbtnMobile ?
                "Mobile":"RBPi";
    }
}
