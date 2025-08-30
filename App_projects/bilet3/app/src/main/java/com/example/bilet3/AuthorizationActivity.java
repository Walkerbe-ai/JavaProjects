package com.example.bilet3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class AuthorizationActivity extends AppCompatActivity {

    EditText surname, name, otchestvo;

    ArrayList<String> idReis = new ArrayList<>();
    ArrayList<Passanger> pass = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        surname = findViewById(R.id.surname);
        name = findViewById(R.id.name);
        otchestvo = findViewById(R.id.otchestvo);
        InputStream inputStreamPassanger =
                getResources().openRawResource(R.raw.passanger);

        ByteArrayOutputStream byteArrayOutputStreamPassanger =
                new ByteArrayOutputStream();


        int ctr;
        try {
            ctr = inputStreamPassanger.read();
            while (ctr != -1) {
                byteArrayOutputStreamPassanger.write(ctr);
                ctr = inputStreamPassanger.read();
            }
            inputStreamPassanger.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            JSONArray jArrayPassanger = new JSONArray(byteArrayOutputStreamPassanger.toString());
            int idPassanger;
            String surname1, name1, otchestvo1;


            for (int i = 0; i < jArrayPassanger.length(); i++) {
                idPassanger = jArrayPassanger.getJSONObject(i).getInt("idPassanger");
                surname1 = jArrayPassanger.getJSONObject(i).getString("surname");
                name1 = jArrayPassanger.getJSONObject(i).getString("name");
                otchestvo1 = jArrayPassanger.getJSONObject(i).getString("otchestvo");
                idReis.add(String.valueOf(jArrayPassanger.getJSONObject(i).getJSONArray("idReis")));

                pass.add(new Passanger(idPassanger, surname1, name1, otchestvo1, idReis));
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }

    public void authorization(View view) {
        pass.forEach(passanger -> {
            if(surname.getText().toString().equals(passanger.getSurname()) && name.getText().toString().equals(passanger.getName()) && otchestvo.getText().toString().equals(passanger.getOtchestvo())){
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("lol", idReis.get(passanger.getIdPassanger()).replace("[", "").replace("]", "").replace(",", " "));
                startActivity(intent);
            }

        });
    }
}