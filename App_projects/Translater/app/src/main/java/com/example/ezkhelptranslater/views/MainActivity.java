package com.example.ezkhelptranslater.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ezkhelptranslater.R;
import com.example.ezkhelptranslater.models.ListTranslate;
import com.example.ezkhelptranslater.models.Translate;

public class MainActivity extends AppCompatActivity {

    EditText translateEditText;
    Spinner spinnerEditTextOnTranslate, spinnerEditTextToTranslate;
    TextView translateText;
    public static ListTranslate list;
    Translate translate;
    String editWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        translateEditText = findViewById(R.id.translateEditText);
        translateText = findViewById(R.id.translateText);

        spinnerEditTextOnTranslate = findViewById(R.id.spinnerEditTextOnTranslate);
        spinnerEditTextToTranslate = findViewById(R.id.spinnerEditTextToTranslate);
        translate = new Translate("Привет", "Hello", "Hi");
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.translatesLanguage, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEditTextOnTranslate.setAdapter(adapter);
        spinnerEditTextToTranslate.setAdapter(adapter);
        list = new ListTranslate(translate);
        list.insertContact(translate);
    }

    public void transalteClick(View view) {

        String splitText = translateEditText.getText().toString();
        String editText = translateEditText.getText().toString();

        if(spinnerEditTextOnTranslate.getSelectedItem().toString().equals("Русский") && spinnerEditTextToTranslate.getSelectedItem().toString().equals("Английский"))
        {
            Log.i("kuku", spinnerEditTextOnTranslate.getSelectedItem().toString());
            for (String split : splitText.split(" ")) {

                for (Translate contactEl:
                        ListTranslate.translates) {
                    if(contactEl.getRussian().equals(split)){
                        editWord = contactEl.getEnglish();
                        editText = editText.replace(split, editWord);
                    }
                }
            }
            translateText.setText(editText);
        }
        if(spinnerEditTextOnTranslate.getSelectedItem().toString().equals("Русский") && spinnerEditTextToTranslate.getSelectedItem().toString().equals("Немецкий"))
        {
            for (String split : splitText.split(" ")) {
                for (Translate contactEl:
                        ListTranslate.translates) {
                    if(contactEl.getRussian().equals(split)){
                        editWord = contactEl.getDeutsch();
                        editText = editText.replace(split, editWord);

                    }
                }
            }
            translateText.setText(editText);
        }
        if(spinnerEditTextOnTranslate.getSelectedItem().toString().equals("Английский") && spinnerEditTextToTranslate.getSelectedItem().toString().equals("Русский"))
        {
            for (String split : splitText.split(" ")) {
                for (Translate contactEl:
                        ListTranslate.translates) {
                    if(contactEl.getEnglish().equals(split)){
                        editWord = contactEl.getRussian();
                        editText = editText.replace(split, editWord);

                    }
                }
            }
            translateText.setText(editText);
        }
        if(spinnerEditTextOnTranslate.getSelectedItem().toString().equals("Английский") && spinnerEditTextToTranslate.getSelectedItem().toString().equals("Немецкий"))
        { for (String split : splitText.split(" ")) {
            for (Translate contactEl:
                    ListTranslate.translates) {
                if(contactEl.getEnglish().equals(split)){
                    editWord = contactEl.getDeutsch();
                    editText = editText.replace(split, editWord);

                }
            }
        }
            translateText.setText(editText);
        }
        if(spinnerEditTextOnTranslate.getSelectedItem().toString().equals("Немецкий") && spinnerEditTextToTranslate.getSelectedItem().toString().equals("Английский"))
        {
            for (String split : splitText.split(" ")) {
                for (Translate contactEl:
                        ListTranslate.translates) {
                    if(contactEl.getDeutsch().equals(split)){
                        editWord = contactEl.getEnglish();
                        editText = editText.replace(split, editWord);

                    }
                }
            }
            translateText.setText(editText);
        }
        if(spinnerEditTextOnTranslate.getSelectedItem().toString().equals("Немецкий") && spinnerEditTextToTranslate.getSelectedItem().toString().equals("Русский"))
        {
            for (String split : splitText.split(" ")) {
                for (Translate contactEl:
                        ListTranslate.translates) {
                    if(contactEl.getDeutsch().equals(split)){
                        editWord = contactEl.getRussian();
                        editText = editText.replace(split, editWord);

                    }
                }
            }
            translateText.setText(editText);
        }

    }
    public void wordTotransalteClick(View view) {
        Intent intent = new Intent(this, AddTranslator.class);
        startActivity(intent);
    }
}