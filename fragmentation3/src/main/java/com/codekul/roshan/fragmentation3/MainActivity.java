package com.codekul.roshan.fragmentation3;

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

        loadFragment(R.id.topPanel,fragTopPanel.getInstance());
        loadFragment(R.id.frameContainer,frameContainer.getInstance(R.drawable.cc));
        loadFragment(R.id.bottomPanel,fragBottomPanel.getInstance());
    }

    public void loadFragment(int id, Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction txn = manager.beginTransaction();

        txn.setCustomAnimations(R.anim.together,R.anim.fade_in);
        txn.replace(id, fragment);
        txn.commit();
    }
}
