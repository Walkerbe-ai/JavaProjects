package com.example.ezkhelptranslater.models;

import java.util.ArrayList;

public class ListTranslate {

    public static ArrayList<Translate> translates = new ArrayList<>();

    private Translate translate;

    public ListTranslate(Translate translate) {
        this.translate = translate;
    }
    public void insertContact(Translate translate) {
        translates.add(translate);
    }
    public ArrayList<Translate> getTranslates() {
        return translates;
    }
}
