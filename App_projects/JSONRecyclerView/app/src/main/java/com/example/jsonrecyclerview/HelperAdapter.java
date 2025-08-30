package com.example.jsonrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HelperAdapter extends RecyclerView.Adapter<HelperAdapter.ViewHolder>{
    private ArrayList<MyViewClass> users;
    private LayoutInflater inflater;
    private int layout;

    public HelperAdapter(Context context, int layout,ArrayList<MyViewClass> users ) {
        this.inflater = LayoutInflater.from(context);
        this.layout = layout;
        this.users = users;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyViewClass user = users.get(position);
        holder.id.setText(user.getName());
        holder.name.setText(user.getName());
        holder.login.setText(user.getName());
        holder.password.setText(user.getName());
        holder.age.setText(user.getName());
        holder.group.setText(user.getName());
    }


    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView id;
        private TextView name;
        private TextView login;
        private TextView password;
        private TextView age;
        private TextView group;
        public ViewHolder(@NonNull View view) {
            super(view);

            id = view.findViewById(R.id.tv_id);
            name = view.findViewById(R.id.tv_name);
            login = view.findViewById(R.id.tv_login);
            password = view.findViewById(R.id.tv_password);
            age = view.findViewById(R.id.tv_age);
            group = view.findViewById(R.id.tv_group);
        }
    }



}
