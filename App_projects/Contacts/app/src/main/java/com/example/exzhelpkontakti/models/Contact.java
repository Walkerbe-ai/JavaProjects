package com.example.exzhelpkontakti.models;

import java.util.ArrayList;

public class Contact {

    private String name;
    private String number;
    private String note;

    public Contact(String name, String number, String note) {
        this.name = name;
        this.number = number;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }



}
