package com.example.perfomanceticket.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.perfomanceticket.R;
import com.example.perfomanceticket.models.Ticket;

import java.util.List;

public class TicketAdapter  extends ArrayAdapter<Ticket> {

    private LayoutInflater inflater;
    private int layout;
    private List<Ticket> tickets;

    public TicketAdapter(@NonNull Context context, int layout, List<Ticket> tickets) {
        super(context, layout, tickets);
        this.inflater = LayoutInflater.from(context);
        this.layout = layout;
        this.tickets = tickets;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = inflater.inflate(layout, parent, false);

        TextView name = convertView.findViewById(R.id.idPerfomance);
        TextView start = convertView.findViewById(R.id.numberTicket);
        TextView end = convertView.findViewById(R.id.dateBuyTicket);

        Ticket ticket = tickets.get(position);
        name.setText(ticket.getIdPerfomance());
        start.setText(ticket.getNumberTicket());
        end.setText(ticket.getDateBuyTicket());

        return convertView;
    }
}
