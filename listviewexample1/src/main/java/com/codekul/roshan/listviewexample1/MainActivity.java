package com.codekul.roshan.listviewexample1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        custom();
        //simple();
    }

    //3: Functionality of button:Adding new country after clicking the button
    public void addCountries(View view){
        ArrayAdapter<String> listAdapter1= (ArrayAdapter<String>) ((ListView)findViewById(R.id.lstvCountry)).getAdapter();
        listAdapter1.add(((EditText)findViewById(R.id.etxtCountry)).getText().toString());
        listAdapter1.notifyDataSetChanged();
    }

    private void simple(){
        //1: Created list : dataset
        List<String> dataSet = new ArrayList<String>();
        dataSet.add("India");
        dataSet.add("China");
        dataSet.add("SriLanka");
        dataSet.add("Sigapore");

        //2: Displaying list on Activity: Showing list in list-view.
        //We took ArrayAdapter<> as it deals with only TEXT.
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dataSet);
        ((ListView)findViewById(R.id.lstvCountry)).setAdapter(listAdapter);

        //4: As we click on any Country, it gets displayed in the Text Box.
        ((ListView) findViewById(R.id.lstvCountry)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<String> localAdatper = (ArrayAdapter<String>) parent.getAdapter();
                String str=localAdatper.getItem(position);
                ((EditText)findViewById(R.id.etxtCountry)).setText(str);
            }
        });

    }

    private void custom(){

        List<MyItem> dataset = new ArrayList<>();
        dataset.add(new MyItem(R.mipmap.ic_launcher_round,"Android"));
        dataset.add(new MyItem(R.mipmap.ic_launcher_round,"Apple"));
        dataset.add(new MyItem(R.mipmap.ic_launcher_round,"gada"));

        MyAdapter adapter = new MyAdapter(this,dataset);
        ((ListView)findViewById(R.id.lstvCountry)).setAdapter(adapter);

    }
}
