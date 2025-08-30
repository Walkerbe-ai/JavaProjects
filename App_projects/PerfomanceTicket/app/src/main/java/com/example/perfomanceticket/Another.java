package com.example.perfomanceticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.perfomanceticket.adapters.TicketAdapter;
import com.example.perfomanceticket.models.Ticket;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Another extends AppCompatActivity {

    ArrayList<String> arrayInt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        Spinner spinnerProject = findViewById(R.id.spinnerProject);
        ListView listProject = findViewById(R.id.listProject);


        InputStream inputStream = getResources().openRawResource(R.raw.ticket);
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
        try {
            JSONArray jsonArray = new JSONArray(byteArrayOutputStream.toString());
            String idPerfomance, namePerfomance, datePerfomance;
            List<Integer> ProjectName;

            ArrayList<Ticket> projects = new ArrayList<>();
            ArrayList<String> dates = new ArrayList<>();

            for(int i = 0; i < jsonArray.length(); i++){
                idPerfomance = jsonArray.getJSONObject(i).getString("idPerfomance");
                namePerfomance = jsonArray.getJSONObject(i).getString("namePerfomance");
                datePerfomance = jsonArray.getJSONObject(i).getString("datePerfomance");
                String finalidPerfomance = idPerfomance;
                String finalnamePerfomance = namePerfomance;
                String finaldatePerfomance = datePerfomance;
                arrayInt.forEach(a ->{
                    if(a.equals(String.valueOf(finalidPerfomance))){
                        projects.add(new Ticket(finalidPerfomance, finalnamePerfomance, finaldatePerfomance));
                        dates.add(finalnamePerfomance);
                    }
                });


            }

            ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, dates);
            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinnerProject.setAdapter(spinnerAdapter);

            AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String item = (String) adapterView.getItemAtPosition(i);
                    ArrayList<Ticket> projects_in_date = new ArrayList<>();
                    projects.forEach(project -> {
                        if(project.getIdPerfomance().equals(item)){
                            projects_in_date.add(project);
                        }
                    });
                    TicketAdapter adapter = new TicketAdapter(getApplicationContext(), R.layout.item_list, projects_in_date);
                    listProject.setAdapter(adapter);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            };
            spinnerProject.setOnItemSelectedListener(itemSelectedListener);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}