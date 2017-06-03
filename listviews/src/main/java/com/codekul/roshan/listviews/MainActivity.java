package com.codekul.roshan.listviews;

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

        //createTextList();
        addCustomList();
    }

    public void createTextList(){
        final List<String> dataset = new ArrayList<>();
        dataset.add("Contact 1");
        dataset.add("Contact 2");
        dataset.add("Contact 3");
        dataset.add("Contact 4");

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dataset);
        ((ListView)findViewById(R.id.lisList)).setAdapter(adapter);

        ((ListView)findViewById(R.id.lisList)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<String> adapter1= (ArrayAdapter<String>) parent.getAdapter();
                String str=adapter1.getItem(position).toString();
                ((EditText)findViewById(R.id.edtContact)).setText(str);
            }
        });
    }

    public void OnAdd(View view) {
        ArrayAdapter<String> adapterLocal = (ArrayAdapter<String>) ((ListView)findViewById(R.id.lisList)).getAdapter();
        adapterLocal.add(((EditText)findViewById(R.id.edtContact)).getText().toString());
        adapterLocal.notifyDataSetChanged();
    }

    public void addCustomList(){

        List<MyListView> dataset=new ArrayList<>();
        dataset.add(new MyListView(R.drawable.ic_boy,"Mr Boy"));
        dataset.add(new MyListView(R.drawable.ic_owl,"Mr Owl"));
        dataset.add(new MyListView(R.drawable.employee,"Mr Employee"));
        dataset.add(new MyListView(R.drawable.friday,"Mr Friday"));
        dataset.add(new MyListView(R.drawable.ic_girl,"Miss Girl"));

        MyAdapter adapter = new MyAdapter(this,dataset);
        ((ListView)findViewById(R.id.lisList)).setAdapter(adapter);

        ((Button)findViewById(R.id.btnAdd)).setEnabled(false);
        //((EditText)findViewById(R.id.edtName)).setEnabled(false);
    }
}
