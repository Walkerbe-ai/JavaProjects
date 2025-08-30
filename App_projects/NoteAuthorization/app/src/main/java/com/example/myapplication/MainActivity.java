package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText name, password;
    Button vhod, reg;
    ArrayList<User> users = new ArrayList<>();
    public  static ArrayList<Note> notes = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        users.add(new User("Da", "qwerty"));
        users.add(new User("Net", "qwerty"));
        notes.add(new Note("Da", "Замеика 1", "Ну тут просто тектс", "22.12.2022"));
        notes.add(new Note("Net", "Замеика 2", "Ну тут просто тектс", "22.12.2022"));

        name = findViewById(R.id.ptName);
        password = findViewById(R.id.ptPassword);
        vhod = findViewById(R.id.Vhod);
        vhod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = 0;
                for (User user: users) {
                    if(user.getName().equals(name.getText().toString())){
                        Intent integer = new Intent(getApplicationContext(), NoteUser.class);
                        integer.putExtra("User", i);
                        startActivity(integer);
                        i++;
                    }
                }
            }
        });

    }
}