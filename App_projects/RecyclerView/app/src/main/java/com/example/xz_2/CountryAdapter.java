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

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    interface OnCountryClickListener{
        void onCountryClick(Country country, int position);
    }
    private OnCountryClickListener onCountryClickListener;
    private LayoutInflater inflater;
    private ArrayList<Country> countries;

    public CountryAdapter(Context context, ArrayList<Country> countries,
                          OnCountryClickListener onCountryClickListener) {
        this.inflater = LayoutInflater.from(context);
        this.countries = countries;
        this.onCountryClickListener = onCountryClickListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Country country = countries.get(position);
        holder.flag.setImageResource(country.getFlagResource());
        holder.name.setText(country.getName());
        holder.capital.setText(country.getCapital());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCountryClickListener.onCountryClick(country, holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }


    public static class ViewHolder extends  RecyclerView.ViewHolder {

        private ImageView flag;
        private TextView name;
        private TextView capital;

        public ViewHolder(@NonNull View view) {
            super(view);
            flag = view.findViewById(R.id.tvFlag);
            name = view.findViewById(R.id.ivName);
            capital = view.findViewById(R.id.ivCapital);
        }
    }
}
