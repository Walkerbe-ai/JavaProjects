package com.example.exzhelpkontakti.models;

import java.util.ArrayList;

public class ContactList {
    public static ArrayList<Contact> contacts = new ArrayList<>();
    private Contact contact;
    public ContactList(Contact contact) {
        this.contact = contact;
    }
    public void insertContact(Contact contact) {
        contacts.add(contact);
    }
    public ArrayList<Contact> getContact() {
        return contacts;
    }
}
