package com.codekul.roshan.fragmentation2;

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

        loadFragment(R.id.frameContainor,FragMain.getInstance(R.drawable.employee));
        loadFragment(R.id.fragPanel,FragPanel.getInstance());
    }

    public void loadFragment(int container,Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction txn = manager.beginTransaction();

        txn.replace(container,fragment);
        txn.commit();
    }
}
