package com.example.finalgame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

class GrridAdapter extends BaseAdapter {

    int[] num;
    Context contxt;
    public GrridAdapter(int[] numin,Context context){
        num = numin;
        contxt=context;
    }
    @Override
    public int getCount() {
        return num.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) contxt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;
        gridView = null;
        convertView = null;
        if (convertView ==null){
            gridView = new View(contxt);
            gridView = inflater.inflate(R.layout.set_layout,null);
            TextView textView=(TextView) gridView.findViewById(R.id.shownum);
            textView.setText(""+num[position]);
        }
        return gridView;
    }
}
