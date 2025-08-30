package com.example.xz_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EatAdapter extends RecyclerView.Adapter<EatAdapter.ViewHolder> {
    interface OnEatClickListener{
        void onEatClick(Eat eat, int position);
    }
    private OnEatClickListener onEatClickListener;
    private LayoutInflater inflater;
    private ArrayList<Eat> eats;

    public EatAdapter(Context context, ArrayList<Eat> eat,
                      OnEatClickListener onEatClickListener) {
        this.inflater = LayoutInflater.from(context);
        this.eats = eat;
        this.onEatClickListener = onEatClickListener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Eat eat = eats.get(position);
        if(eat.getEatResource() != 0)
            holder.eat.setImageResource(eat.getEatResource());
        else
            holder.eat.setImageBitmap(eat.getBitmap());
        holder.name.setText(eat.getName());
        holder.description.setText(eat.getDsctiption());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onEatClickListener.onEatClick(eat, holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return eats.size();
    }


    public static class ViewHolder extends  RecyclerView.ViewHolder {

        private ImageView eat;
        private TextView name;
        private TextView description;

        public ViewHolder(@NonNull View view) {
            super(view);
            eat = view.findViewById(R.id.tvEat);
            name = view.findViewById(R.id.ivName);
            description = view.findViewById(R.id.ivDescription);
        }
    }
}
