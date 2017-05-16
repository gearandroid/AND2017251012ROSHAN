package com.codekul.roshan.interacitvitycommunicationdemo;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Date;

public class NextActivity extends AppCompatActivity {

    public static final String KEY_MY_RESULT = "myResult";

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        //every activity knows who is RESPONSIBLE its creation

        //1
        //create Intent object
        //Onserve below : its getintent() which gives started this intent;
        Intent responsibleIntent=getIntent();

        //2
        //extract bundle from intent(by getExtras()) which was set by setExtras() in Main Activity
        Bundle bundle = responsibleIntent.getExtras();

        //4
        //if this activity is started by main activity, bundle will not be null but if we start this
        //activity directly, bundle will be empty hence we are checking if bundle is null or not
        if(bundle != null) {
            //3
            //Access keys and store it in variable:
            String myName = bundle.getString(MainActivity.KEY_MY_NAME);
            Boolean bool = bundle.getBoolean(MainActivity.KEY_BOOL);

            //5
            //set text to edittext of this activity: we are setting name by its key and current time
            //observe the System.currentTimeMillis()
            ((EditText)findViewById(R.id.edtResult)).setText(myName + (new SimpleDateFormat("dd MM yyyy").format(new Date())));
        }

        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //LAST PART: SENDING RESPONSE BACK TO MAIN ACTIVITY
                //1....create object of Intent
                Intent intent=new Intent();

                //2...Create object of bundle
                Bundle bundleBack=new Bundle();

                //3...put response in bundle object: can be anything
                bundleBack.putString(KEY_MY_RESULT,((EditText)findViewById(R.id.edtResult)).getText().toString());

                //4......Binding bundle object to intent object by putExtras()
                intent.putExtras(bundleBack);

                //5....Throw data back to main Activity by following method as this method invokes
                //onActivityResult of main activity
                setResult(RESULT_OK,intent);

                //00
                finish();
            }
        });
    }
}
