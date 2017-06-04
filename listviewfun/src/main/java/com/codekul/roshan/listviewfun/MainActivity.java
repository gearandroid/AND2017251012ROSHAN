package com.codekul.roshan.listviewfun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //textList();
        customList();
    }

    private void textList(){
        final List<String> dataset = new ArrayList<>();
        dataset.add("Android");
        dataset.add("Apple");
        dataset.add("Symbian");
        dataset.add("Gada");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dataset);
        ((ListView)findViewById(R.id.listView)).setAdapter(adapter);
        adapter.notifyDataSetChanged();

        findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate);
                findViewById(R.id.btnAdd).startAnimation(anim);
                ArrayAdapter<String> adapter1 = (ArrayAdapter<String>) ((ListView)findViewById(R.id.listView)).getAdapter();
                adapter1.add(((EditText)findViewById(R.id.edtText)).getText().toString());
                adapter1.notifyDataSetChanged();
            }
        });

        ((ListView) findViewById(R.id.listView)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<String> adapter2 = (ArrayAdapter<String>) parent.getAdapter();
                String str = (adapter2.getItem(position)).toString();
                ((EditText)findViewById(R.id.edtText)).setText(str);
            }
        });
    }

    private void customList(){
        List<Myitem> dataset=new ArrayList<>();
        dataset.add(new Myitem(R.mipmap.ic_launcher_round,"Vidya"));
        dataset.add(new Myitem(R.mipmap.ic_launcher_round,"Kangna"));
        dataset.add(new Myitem(R.mipmap.ic_launcher_round,"Rekha"));
        dataset.add(new Myitem(R.mipmap.ic_launcher_round,"Katrina"));
        dataset.add(new Myitem(R.mipmap.ic_launcher_round,"Kate"));

        final MyAdapter myAdapter=new MyAdapter(this,dataset);
        ((ListView)findViewById(R.id.listView)).setAdapter(myAdapter);

        ((ListView)findViewById(R.id.listView)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this,R.anim.fade_in);
                ((ListView)findViewById(R.id.listView)).startAnimation(anim);
            }
        });

    }
}
