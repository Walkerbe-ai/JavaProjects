package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class NoteUser extends AppCompatActivity {

    RecyclerView da;
    ArrayList<Note> notes1= new ArrayList<Note>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_user);
        da = findViewById(R.id.Recy);
        //notes = MainActivity.notes;
        Intent intent = getIntent();
        if(intent.hasExtra("User")){
            int i = intent.getIntExtra("User", -1);
            for(Note note: MainActivity.notes){
                if(MainActivity.notes.get(i).getName().equals(note.getName())){
                    notes1.add(note);

                }
            }
        }
        OnNoteClickListener onNoteClickListener = new OnNoteClickListener() {
            @Override
            public void OnNoteClick(Note note, int pos) {
                Log.e("jhgf", "jhgf");
                Toast.makeText(getApplicationContext(), "fghjkl", Toast.LENGTH_LONG ).show();
            }
        };
        Noteadapter noteadapter = new Noteadapter(notes1, this, onNoteClickListener);
        da.setAdapter(noteadapter);
    }
}