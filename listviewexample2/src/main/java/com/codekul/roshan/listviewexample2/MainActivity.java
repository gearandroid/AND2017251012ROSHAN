package com.codekul.roshan.listviewexample2;

import android.support.annotation.IdRes;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simple();
        //custom();
    }

    public void simple(){
        List<String> dataset = new ArrayList<>();
        dataset.add("India");
        dataset.add("China");
        dataset.add("Newzealand");
        dataset.add("Bangladesh");
        dataset.add("Japan");
        dataset.add("Australia");
        dataset.add("Turkey");


        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dataset);
        ((ListView)findViewById(R.id.lstView)).setAdapter(adapter);


        findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayAdapter<String> adapter = (ArrayAdapter<String>) ((ListView)findViewById(R.id.lstView)).getAdapter();
                adapter.add(((EditText)findViewById(R.id.etxtCountry)).getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        ((ListView) findViewById(R.id.lstView)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<String> adapterlocal = (ArrayAdapter<String>) parent.getAdapter();
                String str = adapterlocal.getItem(position);
                ((EditText)findViewById(R.id.etxtCountry)).setText(str);
            }
        });
    }


    public void custom(){

        ((Button)findViewById(R.id.btnAdd)).setEnabled(false);

        List<MyItem> dataset = new ArrayList<>();
        dataset.add(new MyItem(R.drawable.monkey,"Mr. Vanar1"));
        dataset.add(new MyItem(R.drawable.monkey,"Mr. Vanar2"));
        dataset.add(new MyItem(R.drawable.monkey,"Mr. Vanar3"));
        dataset.add(new MyItem(R.drawable.monkey,"Mr. Vanar4"));
        dataset.add(new MyItem(R.drawable.monkey,"Mr. Vanar5"));
        dataset.add(new MyItem(R.drawable.monkey,"Mr. Vanar6"));
        dataset.add(new MyItem(R.drawable.monkey,"Mr. Vanar7"));
        dataset.add(new MyItem(R.drawable.monkey,"Mr. Vanar8"));
        dataset.add(new MyItem(R.drawable.monkey,"Mr. Vanar9"));
        dataset.add(new MyItem(R.drawable.monkey,"Mr. Vanar10"));

        MyAdapter adapter = new MyAdapter(this, dataset);
        ((ListView)findViewById(R.id.lstView)).setAdapter(adapter);

    }
}
