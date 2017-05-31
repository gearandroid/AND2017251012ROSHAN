package com.codekul.roshan.listviewexample4customized;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mt("onCreate");
        //textListDisplay();
        customListDisplay();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mt("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        mt("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        mt("OnPause");
    }

    public void textListDisplay(){

        List<String> dataset=new ArrayList<>();
        dataset.add("Mr. Raman");
        dataset.add("Mr. Champat");
        dataset.add("Mr. Faizaan");
        dataset.add("Mr. Amar");
        dataset.add("Mr. Mani");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dataset);
        ((ListView)findViewById(R.id.lstList)).setAdapter(adapter);

        ((ListView) findViewById(R.id.lstList)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<String> adapter2= (ArrayAdapter<String>) parent.getAdapter();
                String str = adapter2.getItem(position).toString();
                ((EditText) findViewById(R.id.edtxName)).setText(str);
            }
        });

    }
    private void mt(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    public void onAdd(View view) {

        ArrayAdapter<String> adapter1= (ArrayAdapter<String>) ((ListView)findViewById(R.id.lstList)).getAdapter();
        adapter1.add(((EditText)findViewById(R.id.edtxName)).getText().toString());
        adapter1.notifyDataSetChanged();
    }

    public void customListDisplay(){

        ((Button)findViewById(R.id.btnAddName)).setEnabled(false);

        List<MyItem> dataset = new ArrayList<>();
        dataset.add(new MyItem(R.drawable.os,"Mr Android"));
        dataset.add(new MyItem(R.drawable.menu,"Mr Menu"));
        dataset.add(new MyItem(R.drawable.apple,"Mr Apple"));
        dataset.add(new MyItem(R.drawable.wifi,"Mr Wifi"));
        dataset.add(new MyItem(R.drawable.windows,"Mr Windows"));
        dataset.add(new MyItem(R.drawable.monkey,"Mr Monkey"));

        MyAdapter myAdapter = new MyAdapter(this,dataset);
        ((ListView)findViewById(R.id.lstList)).setAdapter(myAdapter);
    }


}
