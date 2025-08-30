package com.example.exzhelpkontakti.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.exzhelpkontakti.R;
import com.example.exzhelpkontakti.models.Contact;
import com.example.exzhelpkontakti.models.ContactList;

public class AddContact extends AppCompatActivity {

    EditText nameContactEdit, numberContactEdit, noteContactEdit;
    Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        nameContactEdit = findViewById(R.id.nameContactEdit);
        numberContactEdit = findViewById(R.id.numberContactEdit);
        noteContactEdit = findViewById(R.id.noteContactEdit);

    }

    public void addContact(View view) {

        contact = new Contact(nameContactEdit.getText().toString(),numberContactEdit.getText().toString(),noteContactEdit.getText().toString());
        MainActivity.list1.insertContact(contact);
        finish();
    }
}