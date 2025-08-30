package com.example.perfomanceticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.perfomanceticket.models.Perfomance;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText surname;
    EditText name;
    EditText patronymic;
    ArrayList<Perfomance> perfomances = new ArrayList<>();
    ArrayList<String> a = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        surname = findViewById(R.id.surname);
        name = findViewById(R.id.name);
        patronymic = findViewById(R.id.patronymic);

        InputStream inputStream = getResources().openRawResource(R.raw.perfomance);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int ctr;
        try {
            ctr = inputStream.read();
            while (ctr != -1){
                byteArrayOutputStream.write(ctr);
                ctr = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.i("onCreate: ", byteArrayOutputStream.toString());
        try {
            JSONArray jsonArray = new JSONArray(byteArrayOutputStream.toString());
            String idPerfomance,namePerfomance, datePerfomance;
            List<Integer> ProjectName;

            for(int i = 0; i < jsonArray.length(); i++){
                idPerfomance = jsonArray.getJSONObject(i).getString("idPerfomance");
                namePerfomance = jsonArray.getJSONObject(i).getString("namePerfomance");
                datePerfomance = jsonArray.getJSONObject(i).getString("datePerfomance");
                perfomances.add(new Perfomance(idPerfomance, namePerfomance, datePerfomance));
                a.add(String.valueOf(jsonArray.getJSONObject(i).getJSONArray("ProjectName")));
                //Log.i("TAG", String.valueOf(jsonArray.getJSONObject(i).getJSONArray("ProjectName")));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void onClickSignIn(View view) throws JSONException {
        if(surname.getText().toString().isEmpty()){
            Toast.makeText(this, "Поле Фамилия пустое", Toast.LENGTH_SHORT).show();
            return;
        }
        if(name.getText().toString().isEmpty()){
            Toast.makeText(this, "Поле Имя пустое", Toast.LENGTH_SHORT).show();
            return;
        }
        if(patronymic.getText().toString().isEmpty()){
            Toast.makeText(this, "Поле Отчество пустое", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            if (surname.getText().toString().equals("M") && name.getText().toString().equals("M") && patronymic.getText().toString().equals("M")){
                Intent intent = new Intent(getApplicationContext(), Another.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(this, "Неверные данные", Toast.LENGTH_SHORT).show();
                return;
            }
        }
    }
}