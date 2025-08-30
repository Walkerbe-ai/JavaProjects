package com.example.xz_2;

public class Country {
    private String name;
    private String capital;
    private int flagResource;
    public Country(String name, String capital, int flagResource){

        this.name=name;
        this.capital=capital;
        this.flagResource=flagResource;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return this.capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getFlagResource() {
        return this.flagResource;
    }

    public void setFlagResource(int flagResource) {
        this.flagResource = flagResource;
    }

}
