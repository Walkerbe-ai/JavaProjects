package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalDateTime;

public class AddNoteActivity extends AppCompatActivity {

    private EditText name, text, date;
    private Button add, back;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        name = findViewById(R.id.NameEditText);
        text = findViewById(R.id.TextEditText);
        date = findViewById(R.id.DateEditText);
        date.setText(LocalDateTime.now().toLocalDate().toString());

        add = findViewById(R.id.AddButton);
        back = findViewById(R.id.BackButton);

        Intent intent = getIntent();
        if(intent.hasExtra("position")){
            position = intent.getIntExtra("position", -1);
            name.setText(MainActivity.notes.get(position).getName());
            text.setText(MainActivity.notes.get(position).getText());
            add.setText("save");
        }
        else
            add.setText("add");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!intent.hasExtra("position"))
                    MainActivity.notes.add(new Note(name.getText().toString(), text.getText().toString(), date.getText().toString()));
                else {
                    MainActivity.notes.remove(position);
                    MainActivity.notes.add(position, new Note(name.getText().toString(), text.getText().toString(), date.getText().toString()));
                }

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}