package com.codekul.roshan.listviewtextlist;

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

        List<String> dataset = new ArrayList<>();
        dataset.add("One");
        dataset.add("Two");
        dataset.add("Three");
        dataset.add("Four");
        dataset.add("Five");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dataset);
        ((ListView)findViewById(R.id.lstTextList)).setAdapter(adapter);

        ((ListView) findViewById(R.id.lstTextList)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<String> adapter1 = (ArrayAdapter<String>) parent.getAdapter();
                ((EditText)findViewById(R.id.edtList)).setText(adapter1.getItem(position));
            }
        });

    }

    public void onAdd(View view) {
        ArrayAdapter<String> adapter = (ArrayAdapter<String>) ((ListView)findViewById(R.id.lstTextList)).getAdapter();
        adapter.add(((EditText)findViewById(R.id.edtList)).getText().toString());
        adapter.notifyDataSetChanged();

    }
}
