package com.codekul.roshan.interactivitycommunication3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NextActivity extends AppCompatActivity {

    public static final String MY_NEXT = "myNext" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Intent responsibleIntent=getIntent();

        Bundle bundle=responsibleIntent.getExtras();

        if(bundle != null){

            String strNext=bundle.getString(MainActivity.MY_KEY);

            ((EditText)findViewById(R.id.edtBack)).setText(strNext);

        }

        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentback=new Intent();

                Bundle bundle=new Bundle();

                String strBack=((EditText)findViewById(R.id.edtBack)).getText().toString();
                bundle.putString(MY_NEXT,strBack);

                intentback.putExtras(bundle);

                setResult(RESULT_OK,intentback);
                finish();
            }
        });

    }
}
