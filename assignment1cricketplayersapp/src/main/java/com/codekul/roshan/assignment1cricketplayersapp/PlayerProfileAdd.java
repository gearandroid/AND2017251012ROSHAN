package com.codekul.roshan.assignment1cricketplayersapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PlayerProfileAdd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_profile_add);
    }

    public void onAdd(View view) {

        String pName = ((EditText)findViewById(R.id.edtEnterName)).getText().toString();
        String pAge = ((EditText)findViewById(R.id.edtEnterAge)).getText().toString();

        MyListDatabase.myDataset.add(new MyItem(R.drawable.cricketlogo,pName,pAge,"Info of Player"));
    }
}
