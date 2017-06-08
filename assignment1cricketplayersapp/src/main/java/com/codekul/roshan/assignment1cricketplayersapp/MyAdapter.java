package com.codekul.roshan.assignment1cricketplayersapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rtb on 8/6/17.
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rootView = null;
        if(convertView == null){
            rootView = inflater.inflate(R.layout.my_layout,parent,false);
        }else{
            rootView = convertView;
        }

        ((ImageView)rootView.findViewById(R.id.imgOfPlayer)).setImageResource(dataset.get(position).imgid);
        ((TextView)rootView.findViewById(R.id.txtPlayerName)).setText(dataset.get(position).itmName);
        ((TextView)rootView.findViewById(R.id.txtPLayerAge)).setText(dataset.get(position).itmAge);;

        return rootView;
    }
}
