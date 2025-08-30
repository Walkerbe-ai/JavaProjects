package com.example.ekzhelp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterList extends ArrayAdapter<list> {

    private LayoutInflater inflater;
    private int layout;
    private List<list> lists;

    public AdapterList(Context context, int layout, List<list> lists) {
        super(context, layout, lists);
        this.inflater = LayoutInflater.from(context);
        this.layout = layout;
        this.lists = lists;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layout, parent, false);
        }
        TextView email = convertView.findViewById(R.id.email);
        TextView key = convertView.findViewById(R.id.keyText);

        list list1 = lists.get(position);
        email.setText(list1.getEmail());
        key.setText(list1.getKey());

        return convertView;
    }

}