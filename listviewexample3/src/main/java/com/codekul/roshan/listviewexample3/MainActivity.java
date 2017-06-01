package com.codekul.roshan.listviewexample3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textList();
    }

    public void textList(){
        List<String> dataset = new ArrayList<>();
        dataset.add("One");
        dataset.add("Two");
        dataset.add("Three");
        dataset.add("Four");

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dataset);
        ((ListView)findViewById(R.id.lstView)).setAdapter(adapter);

        findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayAdapter<String> adapter1= (ArrayAdapter<String>) ((ListView)findViewById(R.id.lstView)).getAdapter();
                adapter1.add(((EditText)findViewById(R.id.etxtName)).getText().toString());
                adapter1.notifyDataSetChanged();
            }
        });

        ((ListView) findViewById(R.id.lstView)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<String> adapter2 = (ArrayAdapter<String>) parent.getAdapter();
                String str = adapter2.getItem(position).toString();
                ((EditText)findViewById(R.id.etxtName)).setText(str);
            }
        });
    }

}
