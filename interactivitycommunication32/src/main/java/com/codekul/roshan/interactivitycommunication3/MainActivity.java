package com.codekul.roshan.interactivitycommunication3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static final String MY_KEY = "myKey" ;
    public static final int REQ_CODE = 2222;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       ((EditText)findViewById(R.id.edtMain)).setText(new SimpleDateFormat("dd MMM yyyy").format(new Date()));

        findViewById(R.id.btnNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,NextActivity.class);
                Bundle bundle=new Bundle();

                String string=((EditText)findViewById(R.id.edtMain)).getText().toString();
                bundle.putString(MY_KEY,string);

                intent.putExtras(bundle);

                startActivityForResult(intent,REQ_CODE);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQ_CODE)
        {
            if(resultCode == RESULT_OK)
            {
                Bundle bundleback=data.getExtras();
                
                String now=bundleback.getString(NextActivity.MY_NEXT);

                ((EditText)findViewById(R.id.edtMain)).setText(now);
            }
        }
    }
}
