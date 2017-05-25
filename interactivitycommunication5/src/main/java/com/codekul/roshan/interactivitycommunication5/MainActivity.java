package com.codekul.roshan.interactivitycommunication5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        findViewById(R.id.BtnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUn = ((EditText)findViewById(R.id.txtUsername)).getText().toString();
                String strUPw = ((EditText)findViewById(R.id.txtPassword)).getText().toString();

                if(strUn.equals("1") && strUPw.equals("1")){

                    Bundle bundle = new Bundle();
                    bundle.putString("keyUsername",strUn);

                    Intent intent =new Intent(MainActivity.this,ProfileActivity.class);

                    intent.putExtras(bundle);
                    //startActivity(intent);
                    startActivityForResult(intent,1234);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1234){
            if(resultCode == RESULT_OK){
                Bundle bundle=data.getExtras();
                String str=bundle.getString("keyRes");
                        ((EditText)findViewById(R.id.txtUsername)).setText(str);
            }
        }
    }
}
