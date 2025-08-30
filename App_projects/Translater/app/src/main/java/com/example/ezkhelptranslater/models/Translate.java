package com.example.ezkhelptranslater.models;

public class Translate {
    private String Russian;
    private String English;
    private String Deutsch;

    public Translate(String russian, String english, String deutsch) {
        Russian = russian;
        English = english;
        Deutsch = deutsch;
    }

    public String getRussian() {
        return Russian;
    }

    public void setRussian(String russian) {
        Russian = russian;
    }

    public String getEnglish() {
        return English;
    }

    public void setEnglish(String english) {
        English = english;
    }

    public String getDeutsch() {
        return Deutsch;
    }

    public void setDeutsch(String deutsch) {
        Deutsch = deutsch;
    }
}
