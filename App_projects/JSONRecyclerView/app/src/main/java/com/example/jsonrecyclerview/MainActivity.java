package com.example.jsonrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.json.JSONArray;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static int position1 = 0;
    ArrayList<MyViewClass> users = new ArrayList<>();
    static HelperAdapter helperAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.lv_users);
        Spinner spGroups = findViewById(R.id.sp_groups);

        InputStream inputStream =
                getResources().openRawResource(R.raw.users);
        ByteArrayOutputStream byteArrayOutputStream =
                new ByteArrayOutputStream();

        int ctr;
        try {
            ctr = inputStream.read();
            while (ctr != -1) {
                byteArrayOutputStream.write(ctr);
                ctr = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.v("Text Data", byteArrayOutputStream.toString());
        try {
            JSONArray jArray = new JSONArray(
                    byteArrayOutputStream.toString());
            int id;
            String name, login, password;
            int age;
            String group;
            ArrayList<String> groups = new ArrayList<>();
            for (int i = 0; i < jArray.length(); i++) {
                id = jArray.getJSONObject(i).getInt("id");
                name = jArray.getJSONObject(i).getString("name");
                login = jArray.getJSONObject(i).getString("login");
                password = jArray.getJSONObject(i).getString("password");
                age = jArray.getJSONObject(i).getInt("age");
                group = jArray.getJSONObject(i).getString("group");
                users.add(new MyViewClass(id, name, login, password, age, group));
                if (!groups.contains(group))
                    groups.add(group);
            }

            ArrayAdapter<String> spinnerAdapter =
                    new ArrayAdapter<String>(this,
                            android.R.layout.simple_spinner_item, groups);
            spinnerAdapter.setDropDownViewResource(
                    android.R.layout.simple_spinner_dropdown_item);


            spGroups.setAdapter(spinnerAdapter);

            AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item = (String) parent.getItemAtPosition(position);
                    ArrayList<MyViewClass> users_in_group = new ArrayList<MyViewClass>();
                    users.forEach(user -> {
                        if (user.getGroup().equals(item)) {
                            users_in_group.add(user);
                        }
                    });
                    helperAdapter= new HelperAdapter(getApplicationContext(),
                            R.layout.item_list, users_in_group);
                    recyclerView.setAdapter(helperAdapter);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            };
            spGroups.setOnItemSelectedListener(itemSelectedListener);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
