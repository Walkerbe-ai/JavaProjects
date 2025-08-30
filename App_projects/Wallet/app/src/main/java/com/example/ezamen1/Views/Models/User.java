package com.example.ezamen1.Views.Models;

import java.util.ArrayList;

public class User{
    private String login;
    private String password;
    private ArrayList<Card> cards = new ArrayList<>();
    public static ArrayList<User> Users = new ArrayList<>();

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void insertCard(Card card) {
        cards.add(card);
    }

    public void deleteCard(Card card){
        cards.remove(card);
    }

    public void updateCard(Card card){
        for (int i = 0; i < cards.size();i++) {
            if (cards.get(i).getCardNumber() == card.getCardNumber()){
                cards.set(i,card);
            }
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
