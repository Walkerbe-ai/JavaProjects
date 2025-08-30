package com.example.bilet3;

import java.util.List;

public class Reis {
    private String id;
    private String dateOfOut;
    private String dateOfCome;
    public static List<String> idRes;

    public Reis(String id, String dateOfOut, String dateOfCome) {
        this.id = id;
        this.dateOfOut = dateOfOut;
        this.dateOfCome = dateOfCome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateOfOut() {
        return dateOfOut;
    }

    public void setDateOfOut(String dateOfOut) {
        this.dateOfOut = dateOfOut;
    }

    public String getDateOfCome() {
        return dateOfCome;
    }

    public void setDateOfCome(String dateOfCome) {
        this.dateOfCome = dateOfCome;
    }

    public List<String> getIdRes() {
        return idRes;
    }

    public void setIdRes(List<String> idRes) {
        this.idRes = idRes;
    }
}
