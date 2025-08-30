package com.example.staffuimobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.staffuimobile.adapters.ProjectAdapter;
import com.example.staffuimobile.models.Project;
import com.example.staffuimobile.models.Staff;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnotherActivity extends AppCompatActivity {
    ArrayList<String> arrayInt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        Spinner spinnerProject = findViewById(R.id.spinnerProject);
        ListView listProject = findViewById(R.id.listProject);

        Intent b = getIntent();
        arrayInt = new ArrayList<String>(Arrays.asList(b.getStringExtra("ids").split(" ")));

        InputStream inputStream = getResources().openRawResource(R.raw.project);
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
            int Id;
            String nameProject, startDate, endDate;
            List<Integer> ProjectName;

            ArrayList<Project> projects = new ArrayList<>();
            ArrayList<String> dates = new ArrayList<>();

            for(int i = 0; i < jsonArray.length(); i++){
                Id = jsonArray.getJSONObject(i).getInt("Id");
                nameProject = jsonArray.getJSONObject(i).getString("Name");
                startDate = jsonArray.getJSONObject(i).getString("StartDate");
                endDate = jsonArray.getJSONObject(i).getString("EndDate");
                int finalId = Id;
                String finalNameProject = nameProject;
                String finalStartDate = startDate;
                String finalEndDate = endDate;
                arrayInt.forEach(a ->{
                    if(a.equals(String.valueOf(finalId))){
                        projects.add(new Project(finalId, finalNameProject, finalStartDate, finalEndDate));
                        dates.add(finalStartDate);
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
                    ArrayList<Project> projects_in_date = new ArrayList<>();
                    projects.forEach(project -> {
                        if(project.getStartDate().equals(item)){
                            projects_in_date.add(project);
                        }
                    });
                    ProjectAdapter adapter = new ProjectAdapter(getApplicationContext(), R.layout.item_list, projects_in_date);
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