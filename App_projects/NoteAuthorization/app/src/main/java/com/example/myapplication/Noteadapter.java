package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class Noteadapter extends RecyclerView.Adapter<Noteadapter.ViewHolder> {

    ArrayList<Note> notes;
    LayoutInflater inflater;
    OnNoteClickListener onNoteClickListener;

    public Noteadapter(ArrayList<Note> note, Context context, OnNoteClickListener onNoteClickListener) {
        this.notes = note;
        this.inflater = LayoutInflater.from(context);
        this.onNoteClickListener = onNoteClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.Name.setText(note.getName());
        holder.Date.setText(note.getDate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNoteClickListener.OnNoteClick(note, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        final TextView Name, Date;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.NameTextView);
            Date = itemView.findViewById(R.id.DateTextView);
        }
    }
}
