package com.example.bilet3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>
{

private LayoutInflater layoutInflater;
private int layout;
private ArrayList<Reis> reiss;

    public OnReisClickListener onReisClick;

    public interface OnReisClickListener {
        void onReisClick(Reis reis, int position);
    }
    public void setReisClickListener(OnReisClickListener onReisClick){
        this.onReisClick = onReisClick;
    }

    public RecyclerAdapter(Context context, int layout, ArrayList<Reis> reiss) {
        this.layoutInflater = LayoutInflater.from(context);
        this.layout = layout;
        this.reiss = reiss;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        Reis reis = reiss.get(position);
        holder.bind(reis, position);
    }

    @Override
    public int getItemCount() {
        return reiss.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView id, dateOfOut, dateOfCome;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.idReis);
            dateOfOut = itemView.findViewById(R.id.dateOfOut);
            dateOfCome = itemView.findViewById(R.id.dateOfCome);
        }

        public void bind(Reis reis, int position){

            id.setText(reis.getId());
            dateOfOut.setText(reis.getDateOfOut());
            dateOfCome.setText(reis.getDateOfCome());
            itemView.setOnClickListener(view -> {
                onReisClick.onReisClick(reis, position);
            });
        }

    }
}

