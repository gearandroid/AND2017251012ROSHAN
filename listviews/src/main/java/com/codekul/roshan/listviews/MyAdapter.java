package com.codekul.roshan.listviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rtb on 3/6/17.
 */

public class MyAdapter extends BaseAdapter{

    private final Context context;
    private final List<MyListView> dataset;

    private LayoutInflater inflater;

    public MyAdapter(Context context, List<MyListView> dataset) {
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
        return position * 5;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View root= inflater.inflate(R.layout.my_list,parent,false);
        ((ImageView)root.findViewById(R.id.imgPic)).setImageResource(dataset.get(position).imgImage);
        ((TextView)root.findViewById(R.id.txtName)).setText(dataset.get(position).textContact);

        return root;
    }
}
