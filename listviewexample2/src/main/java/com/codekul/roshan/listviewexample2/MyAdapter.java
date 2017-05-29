package com.codekul.roshan.listviewexample2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by rtb on 29/5/17.
 */

public class MyAdapter extends BaseAdapter {

    private final Context context;
    private final List<MyItem> dataset;

    private LayoutInflater inflater;

    public MyAdapter(Context context, List<MyItem> dataset) {

        this.context = context;
        this.dataset = dataset;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dataset.size();
    }

    @Override
    public Object getItem(int position) {
        return dataset.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position * 15;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View root = inflater.inflate(R.layout.my_view,parent,false);
        ((ImageView)root.findViewById(R.id.imgImage)).setImageResource(dataset.get(position).imgid);
        ((EditText)root.findViewById(R.id.edtxtText)).setText(dataset.get(position).text);

        return root;
    }
}
