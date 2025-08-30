package com.example.bilet3;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import org.json.JSONArray;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Reis> reis = new ArrayList<>();
    ArrayList<Reis> reisCheck = new ArrayList<>();
    ArrayList<String> arrayList = new ArrayList<>();
    TextView dateOfOutText, dateOfComeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        dateOfOutText = findViewById(R.id.dateOfOutText);
        dateOfComeText = findViewById(R.id.dateOfComeText);

        Intent intent = getIntent();
        arrayList = new ArrayList<String>(Arrays.asList(intent.getStringExtra("lol")));

        arrayList.forEach(a -> {
            Log.i("onCreate", a);
        });

        InputStream inputStreamReis =
        getResources().openRawResource(R.raw.reis);
        ByteArrayOutputStream byteArrayOutputStreamReis =
        new ByteArrayOutputStream();
        int ctr1;
        try
        {
            ctr1 = inputStreamReis.read();
            while (ctr1 != -1)
            {
                byteArrayOutputStreamReis.write(ctr1);
                ctr1 = inputStreamReis.read();
            }
            inputStreamReis.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        String idRes, dateOfOut, dateOfCome;
        try{
            JSONArray jArrayReis = new JSONArray(byteArrayOutputStreamReis.toString());
            List<String> idReis;
            for (int i = 0; i < jArrayReis.length(); i++) {
                idRes = jArrayReis.getJSONObject(i).getString("idReis");
                dateOfOut = jArrayReis.getJSONObject(i).getString("dateOfOut");
                dateOfCome = jArrayReis.getJSONObject(i).getString("dateOfCome");
                reis.add(new Reis(idRes, dateOfOut, dateOfCome));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        arrayList.forEach(a ->  {
            reis.forEach(reis1 ->{
                Log.i("TAG", reis1.getId());
                Log.i("TAG", a);
                if(a.contains(String.valueOf(reis1.getId())))
                {
                    reisCheck.add(reis1);

                }
            });

        });
        RecyclerAdapter adapter =
                new RecyclerAdapter(getApplicationContext(),
                        R.layout.item_list, reisCheck);



        RecyclerAdapter.OnReisClickListener itemClickListener = new RecyclerAdapter.OnReisClickListener() {
            @Override
            public void onReisClick(Reis reis, int position) {
                Log.i("gdfs", reis.getId());
                reisCheck.forEach(items -> {
                    if(items.getId().equals(reis.getId())){
                        dateOfOutText.setText(items.getDateOfCome());
                        dateOfComeText.setText(items.getDateOfOut());
                    }
                });
            }
    };
        adapter.setReisClickListener(itemClickListener);
        recyclerView.setAdapter(adapter);
}}