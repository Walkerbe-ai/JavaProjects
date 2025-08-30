package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView notesRecyclerView;
    private Button addNoteButton;
    public static List<Note> notes = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notesRecyclerView = findViewById(R.id.NotesRecyclerView);
        addNoteButton = findViewById(R.id.AddNoteButton);
        addNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddNoteActivity.class);
                startActivity(intent);
            }
        });
        OnNoteClickListener onNoteClickListener = new OnNoteClickListener() {
            @Override
            public void OnNoteClick(Note note, int pos) {
                Intent intent = new Intent(getApplicationContext(), AddNoteActivity.class);
                intent.putExtra("position", pos);
                startActivity(intent);
            }
        };
        NoteAdapter adapter = new NoteAdapter(this, notes, onNoteClickListener);
        notesRecyclerView.setAdapter(adapter);

    }
}