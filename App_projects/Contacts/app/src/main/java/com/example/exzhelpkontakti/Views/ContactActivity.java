package com.example.exzhelpkontakti.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.exzhelpkontakti.R;
import com.example.exzhelpkontakti.models.Contact;
import com.example.exzhelpkontakti.models.ContactList;

import org.w3c.dom.Text;

public class ContactActivity extends AppCompatActivity {
    TextView nameContactText;
    TextView numberContactText;
    TextView noteContactText;
    Contact contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        nameContactText = findViewById(R.id.nameContactText);
        numberContactText = findViewById(R.id.numberContactText);
        noteContactText = findViewById(R.id.noteContactText);

        String name  = getIntent().getStringExtra("name");
        String number  = getIntent().getStringExtra("number");

        for (Contact contactEl:
                ContactList.contacts) {
            if (contactEl.getName().equals(name) && contactEl.getNumber().equals(number)){
                contact = contactEl;
            }
        }

            nameContactText.setText(contact.getName());
            numberContactText.setText(String.valueOf(contact.getNumber()));
            noteContactText.setText(String.valueOf(contact.getNote()));
        }
    public void backClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
    }
}
