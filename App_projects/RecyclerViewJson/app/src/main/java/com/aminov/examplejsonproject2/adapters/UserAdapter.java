package com.aminov.examplejsonproject2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.aminov.examplejsonproject2.R;
import com.aminov.examplejsonproject2.models.User;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {

    private LayoutInflater inflater;
    private int layout;
    private List<User> users;

    public UserAdapter(Context context, int layout, List<User> users) {
        super(context, layout, users);
        this.inflater = LayoutInflater.from(context);
        this.layout = layout;
        this.users = users;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layout, parent, false);
        }
        TextView id = convertView.findViewById(R.id.tv_id);
        TextView name = convertView.findViewById(R.id.tv_name);
        TextView login = convertView.findViewById(R.id.tv_login);
        TextView password = convertView.findViewById(R.id.tv_password);
        TextView age = convertView.findViewById(R.id.tv_age);
        TextView group = convertView.findViewById(R.id.tv_group);

        User user = users.get(position);
        id.setText(String.valueOf(user.getId()));
        name.setText(user.getName());
        login.setText(user.getLogin());
        password.setText(user.getPassword());
        age.setText(String.valueOf(user.getAge()));
        group.setText(user.getGroup());

        return convertView;
    }
}
