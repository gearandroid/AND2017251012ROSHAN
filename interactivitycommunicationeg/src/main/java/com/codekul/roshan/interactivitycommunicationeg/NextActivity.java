package com.codekul.roshan.interactivitycommunicationeg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import static android.provider.Contacts.SettingsColumns.KEY;
import static com.codekul.roshan.interactivitycommunicationeg.MainActivity.KEY_IMG;

public class NextActivity extends AppCompatActivity {

    public static final String KEY_IMG_BACK = "imageBack";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_next);

        Intent intentresponsible=getIntent();
        Bundle bundle=intentresponsible.getExtras();

        if (bundle != null) {
            ((ImageView) findViewById(R.id.imgNext)).setImageResource(bundle.getInt(MainActivity.KEY_IMG));
            Animation anim = AnimationUtils.loadAnimation(this, R.anim.fade_in);
            ((ImageView) findViewById(R.id.imgNext)).startAnimation(anim);
        }

        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundleBack=new Bundle();
                Intent intentBack=new Intent();
                bundleBack.putInt(KEY_IMG_BACK,R.drawable.infantdress);
                intentBack.putExtras(bundleBack);

                setResult(RESULT_OK,intentBack);
                finish();
            }
        });
    }
}
