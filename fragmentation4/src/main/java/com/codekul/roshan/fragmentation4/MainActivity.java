package com.codekul.roshan.fragmentation4;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragments(R.id.frag_Top,Frag_Top.getInstance());
        loadFragments(R.id.frag_Bottom,FragBottom.getInstance());
        loadFragments(R.id.frag_Container,FragContainer.getInstance(R.drawable.ic_likeborder));
    }

    public void loadFragments(int container, Fragment frag){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction txn = manager.beginTransaction();

        txn.replace(container,frag);
        txn.commit();
    }

}
