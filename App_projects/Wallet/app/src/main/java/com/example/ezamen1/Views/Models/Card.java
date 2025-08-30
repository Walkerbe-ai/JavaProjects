package com.example.ezamen1.Views.Models;

import java.io.Serializable;
import java.util.Date;

public class Card {
    private String bank;
    private long cardNumber;
    private int endMonth;
    private int endYear;
    private int ccv;

    public Card(String bank, long cardNumber, int endMonth, int endYear, int ccv) {
        this.bank = bank;
        this.cardNumber = cardNumber;
        this.endMonth = endMonth;
        this.endYear = endYear;
        this.ccv = ccv;
    }

    public Card(String bank, long cardNumber, int endMonth, int endYear) {
        this.bank = bank;
        this.cardNumber = cardNumber;
        this.endMonth = endMonth;
        this.endYear = endYear;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(int endMonth) {
        this.endMonth = endMonth;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public int getCcv() {
        return ccv;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }
}
