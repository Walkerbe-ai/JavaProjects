package com.example.hz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {

    private LayoutInflater inflater;
    private int resourse;
    private List<User> users;


    public UserAdapter(Context context, int resource, List<User> users) {
        super(context, resource, users);
        this.inflater = LayoutInflater.from(context);
        this.resourse = resource;
        this.users = users;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = inflater.inflate(this.resourse, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        User user = users.get(position);
        viewHolder.photo.setImageResource(user.getPhotoPath());
        viewHolder.name.setText(user.getName());
        viewHolder.password.setText(user.getPassword());

        return convertView;

    }
    private class ViewHolder{
        ImageView photo;
        TextView name, password;
        public ViewHolder(View view) {
            this.photo = view.findViewById(R.id.ivPhoto);
            this.name = view.findViewById(R.id.tvName);
            this.password = view.findViewById(R.id.tvPassword);
        }
    }
}
