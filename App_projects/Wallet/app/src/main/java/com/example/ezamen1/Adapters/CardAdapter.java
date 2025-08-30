package com.example.ezamen1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezamen1.Views.Models.Card;
import com.example.ezamen1.R;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    public interface OnCardClickListener {
        void onCardClick(Card card, int position);
    }

    public OnCardClickListener onClickListener;

    ArrayList<Card> cards = new ArrayList<>();
    LayoutInflater layoutInflater;

    public void setCardClickListener(OnCardClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

    public void setData(ArrayList<Card> cards){
        this.cards.clear();
        this.cards.addAll(cards);
        notifyDataSetChanged();
    }

    public void setContext(Context context){
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.wallet_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Card card = cards.get(position);
        holder.bind(card,position);
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {
        private final TextView bank_text, number_card_text, date_text,ccv_text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bank_text = itemView.findViewById(R.id.bank_text);
            number_card_text = itemView.findViewById(R.id.number_card_text);
            date_text = itemView.findViewById(R.id.date_text);
            ccv_text = itemView.findViewById(R.id.ccv_text);
        }

        public void bind(Card card, int position){
            bank_text.setText(card.getBank());
            number_card_text.setText("**** **** **** " + String.valueOf(card.getCardNumber()).substring(4,6));
            date_text.setText(card.getEndMonth() + "/" + card.getEndYear());
            ccv_text.setText(String.valueOf(card.getCcv()));

            itemView.setOnClickListener(view -> {
                onClickListener.onCardClick(card, position);
            });
        }
    }
}
