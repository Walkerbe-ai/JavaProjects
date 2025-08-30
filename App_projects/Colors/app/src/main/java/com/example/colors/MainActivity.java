package com.example.colors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerEat;
    private TextView textViewDescriptionTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerEat = findViewById(R.id.spinnerEat);
        textViewDescriptionTemp = findViewById(R.id.textViewDescriptionTemp);
    }

    public void showDescription(View view) {
        int position = spinnerEat.getSelectedItemPosition(); // позиция спинера
        String description = getDescriptionByPosition(position); //
        textViewDescriptionTemp.setText(description); // изменяется текст
    }

    private String getDescriptionByPosition(int position) {
        String[] descriptions = getResources().getStringArray(R.array.description_of_temp); // массив других айтемов
        return descriptions[position]; //
    }
}