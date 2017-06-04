package com.codekul.roshan.interactivitycommunicationeg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import static com.codekul.roshan.interactivitycommunicationeg.NextActivity.KEY_IMG_BACK;
import static com.codekul.roshan.interactivitycommunicationeg.R.anim.fade_in;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_IMG = "image";
    public static final int REQ_CODE = 1234;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.imgWork).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate);
                findViewById(R.id.imgWork).startAnimation(anim);

                (findViewById(R.id.imgWork)).setVisibility(View.INVISIBLE);
            }
        });

        findViewById(R.id.btnMonday).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               intBun(R.drawable.angrybaby);
            }
        });

        findViewById(R.id.btnFriday).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                intBun(R.drawable.friday);
            }
        });
    }
    private void intBun(int image){

        Intent intent=new Intent(MainActivity.this,NextActivity.class);
        Bundle bundle=new Bundle();
        bundle.putInt(KEY_IMG,image);
        intent.putExtras(bundle);

        startActivityForResult(intent,REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ((requestCode == REQ_CODE) && (resultCode == RESULT_OK)){
            Bundle bundle = data.getExtras();
            ((ImageView)findViewById(R.id.imgWork)).setImageResource(bundle.getInt(KEY_IMG_BACK));

            Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate);
            findViewById(R.id.imgWork).startAnimation(animation);
        }
    }
}
