package com.example.perfomanceticket.models;

public class Perfomance {
    public String idPerfomance, namePerfomance, datePerfomance;

    public Perfomance(String idPerfomance, String namePerfomance, String datePerfomance) {
        idPerfomance = idPerfomance;
        namePerfomance = namePerfomance;
        datePerfomance = datePerfomance;
    }

    public String getIdPerfomance() {
        return idPerfomance;
    }

    public String getNamePerfomance() {
        return namePerfomance;
    }

    public String getDatePerfomance() {
        return datePerfomance;
    }
}
