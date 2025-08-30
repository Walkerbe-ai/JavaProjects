package com.example.ezkhelptranslater.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ezkhelptranslater.R;
import com.example.ezkhelptranslater.models.ListTranslate;
import com.example.ezkhelptranslater.models.Translate;

public class AddTranslator extends AppCompatActivity {
    ListTranslate list;
    Translate translate;
EditText wordForTranslateEditText, wordTranslateOnEnglish, wordTranslateOnDeutsch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_translator);
        wordForTranslateEditText = findViewById(R.id.wordForTranslateEditText);
        wordTranslateOnEnglish = findViewById(R.id.wordTranslateOnEnglish);
        wordTranslateOnDeutsch = findViewById(R.id.wordTranslateOnDeutsch);

    }

    public void addWordClick(View view) {
        translate = new Translate(wordForTranslateEditText.getText().toString(),wordTranslateOnEnglish.getText().toString(),wordTranslateOnDeutsch.getText().toString());
        MainActivity.list.insertContact(translate);
        finish();
    }
}