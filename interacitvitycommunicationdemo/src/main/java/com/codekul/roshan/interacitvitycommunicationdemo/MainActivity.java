package com.codekul.roshan.interacitvitycommunicationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_MY_NAME = "myName";
    public static final String KEY_BOOL = "boolean" ;
    public static final int REQUEST_CODE_NEW = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1
                //create Intent-parameters as source this and Target that is next Activity to be opened
                Intent intent=new Intent(MainActivity.this,NextActivity.class);

                //2
                //created bundle and few keys of it
                Bundle bundle=new Bundle();

                //keys creation: alt enter to key names when they show errors: at top keys get created
                // Make sure keys should be public..at the top

                //3
                //creating few bundle keys
                String maintxt=((EditText)findViewById(R.id.edtName)).getText().toString();
                bundle.putString(KEY_MY_NAME,maintxt);
                bundle.putString(KEY_BOOL,"true");

                //4
                //passing bundle object to intent
                intent.putExtras(bundle);

                //5
                //start next activity by passing intent object which is bundled by bundle object.
                //startActivity(intent); use this if next activity does not sends any response/result back
                //If next Activity is sending any response/result back to this main activity, we need
                //to check the response hence we use the following

                startActivityForResult(intent,1234);

            }
        });
    }

    //6
    //if you are expecting some response from next activity, the explicitly form
    //method: onActivityResult

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_NEW)
        {
            if (resultCode == RESULT_OK)
            {
                //create bundle object and extract response/result by data.getExtras();
                Bundle bundleback = data.getExtras();
                String result=bundleback.getString(NextActivity.KEY_MY_RESULT);

                ((EditText)findViewById(R.id.edtName)).setText(result);
            }
        }

    }
}
