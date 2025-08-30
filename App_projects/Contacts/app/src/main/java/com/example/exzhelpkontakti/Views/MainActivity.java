package com.example.exzhelpkontakti.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.exzhelpkontakti.Adapters.AdapterConact;
import com.example.exzhelpkontakti.R;
import com.example.exzhelpkontakti.models.Contact;
import com.example.exzhelpkontakti.models.ContactList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

RecyclerView recyclerView;
AdapterConact adapter;
    Contact contact;
    public static ContactList list1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        contact = new Contact("fdfds","1234567812","12");
        list1 = new ContactList(contact);
        if(list1.getContact() != null){
        }
        else {
            list1.insertContact(contact);
        }


        AdapterConact.OnContactClickListener onContactClickListener = new AdapterConact.OnContactClickListener() {
            @Override
            public void onContactClick(com.example.exzhelpkontakti.models.Contact contact, int position) {
            Intent intent = new Intent(getApplicationContext(), ContactActivity.class);
            intent.putExtra("name", contact.getName());
            intent.putExtra("number", contact.getNumber());

            startActivity(intent);
            }
        };
        adapter = new AdapterConact();
        adapter.setContext(this);
        recyclerView.setAdapter(adapter);
        adapter.setContactClickListener(onContactClickListener);
    }
    @Override
    protected void onResume() {
        super.onResume();
        adapter.setData(list1.getContact());
    }
    public void addContact(View view) {
        Intent intent = new Intent(this, AddContact.class);
        startActivity(intent);

    }
}