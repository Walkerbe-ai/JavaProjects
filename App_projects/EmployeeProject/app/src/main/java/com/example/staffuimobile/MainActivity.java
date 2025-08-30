package com.example.staffuimobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.staffuimobile.models.Staff;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText textNumber;
    ArrayList<Staff> staffs = new ArrayList<>();
    ArrayList<String> a = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textNumber = findViewById(R.id.textNumber);

        InputStream inputStream = getResources().openRawResource(R.raw.staff);
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
            int Id;
            String FirstName, LastName, MiddleName;
            List<Integer> ProjectName;

            for(int i = 0; i < jsonArray.length(); i++){
                Id = jsonArray.getJSONObject(i).getInt("Id");
                FirstName = jsonArray.getJSONObject(i).getString("FirstName");
                LastName = jsonArray.getJSONObject(i).getString("LastName");
                MiddleName = jsonArray.getJSONObject(i).getString("MiddleName");
                staffs.add(new Staff(Id, FirstName, LastName, MiddleName));
                a.add(String.valueOf(jsonArray.getJSONObject(i).getJSONArray("ProjectName")));
                //Log.i("TAG", String.valueOf(jsonArray.getJSONObject(i).getJSONArray("ProjectName")));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void onClickSignIn(View view) throws JSONException {
        if(textNumber.getText().toString().isEmpty()){
            Toast.makeText(this, "Табельный номер пуст", Toast.LENGTH_SHORT).show();
        }
        else {
            staffs.forEach(staff -> {
                if(String.valueOf(staff.getId()).equals(textNumber.getText().toString())){
                    Intent intent = new Intent(getApplicationContext(), AnotherActivity.class);
                    intent.putExtra("ids", a.get(staff.getId()-1).replace("[", "").replace("]", "").replace(",", " "));
                    startActivity(intent);
                }
            });
        }
    }
}