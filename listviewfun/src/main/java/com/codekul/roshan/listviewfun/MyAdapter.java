package com.codekul.roshan.listviewfun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by rtb on 4/6/17.
 */

public class MyAdapter extends BaseAdapter {

    private final Context context;
    private final List<Myitem> dataset;

    private LayoutInflater inflater;

    public MyAdapter(Context context, List<Myitem> dataset) {
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
        return position * 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
