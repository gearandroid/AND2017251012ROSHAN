package com.codekul.roshan.fragmentation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(FirstFragment.getInstance(R.mipmap.ic_launcher_round));
    }

    public void loadFragment(Fragment frag){

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction txn = manager.beginTransaction();

        txn.setCustomAnimations(R.anim.enter,R.anim.exit);
        txn.replace(R.id.frameContainer,frag);
        txn.commit();
    }
}
