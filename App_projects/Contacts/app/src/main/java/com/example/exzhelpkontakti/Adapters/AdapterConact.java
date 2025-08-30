package com.example.exzhelpkontakti.Adapters;

import android.content.Context;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exzhelpkontakti.R;
import com.example.exzhelpkontakti.models.Contact;

import java.util.ArrayList;

public class AdapterConact extends RecyclerView.Adapter<AdapterConact.ViewHolder> {

    ArrayList<Contact> contacts = new ArrayList<Contact>();
    LayoutInflater layoutInflater;
public OnContactClickListener onContactClick;

    public interface OnContactClickListener {
        void onContactClick(Contact contact, int position);
    }
    public void setContactClickListener(OnContactClickListener onContactClick){
        this.onContactClick = onContactClick;
    }
    public void setContext(Context context)
    {
        layoutInflater = LayoutInflater.from(context);
    }
    public void setData(ArrayList<Contact> contacts){
        this.contacts.clear();
        this.contacts.addAll(contacts);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterConact.ViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        holder.bind(contact, position);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView name, number;
        public ViewHolder(@NonNull View view)
        {
            super(view);
            name = view.findViewById(R.id.name);
            number = view.findViewById(R.id.number);
        }
        public void bind(Contact contact, int position){
            name.setText(contact.getName());
            number.setText(contact.getNumber());
            itemView.setOnClickListener(view -> {
                onContactClick.onContactClick(contact, position);
            });
        }

    }

}
