package com.codekul.roshan.listviewexample4customized;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rtb on 31/5/17.
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
        return position * 11;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View root = null;
        if(convertView == null){
            root = inflater.inflate(R.layout.my_view,parent,false);
        }else {
            root = convertView;
        }
        ((TextView)root.findViewById(R.id.txtText)).setText(dataset.get(position).text);
        ((ImageView)root.findViewById(R.id.imgImage)).setImageResource(dataset.get(position).imgId);

        return root;

    }
}
