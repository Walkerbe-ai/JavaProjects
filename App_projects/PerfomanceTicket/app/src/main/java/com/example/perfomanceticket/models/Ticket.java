package com.example.perfomanceticket.models;

public class Ticket {
    public String idPerfomance, numberTicket, dateBuyTicket;

    public Ticket(String idPerfomance, String numberTicket, String dateBuyTicket) {
        idPerfomance = idPerfomance;
        numberTicket = numberTicket;
        dateBuyTicket = dateBuyTicket;
    }

    public String getIdPerfomance() {
        return idPerfomance;
    }

    public String getNumberTicket() {
        return numberTicket;
    }

    public String getDateBuyTicket() {
        return dateBuyTicket;
    }
}
