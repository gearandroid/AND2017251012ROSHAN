package com.codekul.roshan.assignment1cricketplayersapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PLayerList extends AppCompatActivity {

    public static final String P_NAME = "playerName";
    public static final String P_AGE = "playerAge";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list);

        //List<MyItem> dataset = new ArrayList<>();

        MyListDatabase.myDataset.add(new MyItem(R.drawable.clogo,"Sachin","41"," "));
        MyListDatabase.myDataset.add(new MyItem(R.drawable.clogo,"M S Dhoni","40"," "));
        MyListDatabase.myDataset.add(new MyItem(R.drawable.clogo,"Yuvraj Singh","38"," "));
        MyListDatabase.myDataset.add(new MyItem(R.drawable.clogo,"R Ashwin ","33"," "));
        MyListDatabase.myDataset.add(new MyItem(R.drawable.clogo,"R Dhawan","28"," "));

        final MyAdapter myAdapter = new MyAdapter(this,MyListDatabase.myDataset);
        ((ListView)findViewById(R.id.lstListPlayer)).setAdapter(myAdapter);

        ((ListView) findViewById(R.id.lstListPlayer)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                MyItem clickedItem = (MyItem) myAdapter.getItem(position);

//                String namePlayer = clickedItem.itmName;
//                String nameAge = clickedItem.itmAge;
//
//                Bundle bundle = new Bundle();
//                bundle.putString(P_NAME,namePlayer);
//                bundle.putString(P_AGE,nameAge);
//
//                Intent intent = new Intent(PLayerList.this,PLayerProfile.class);
//                intent.putExtras(bundle);

                startActivityForResult(new Intent(PLayerList.this,PLayerProfile.class),1234);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Casting
        ((MyAdapter)((ListView)findViewById(R.id.lstListPlayer)).getAdapter()).notifyDataSetChanged();
    }
}
