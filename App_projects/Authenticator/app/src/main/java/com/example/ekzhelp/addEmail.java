package com.example.ekzhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class addEmail extends AppCompatActivity {
    TextView email;
    List<list> list1 = new ArrayList<list>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_email);
        email = findViewById(R.id.emailText);
    }

    public void clickAddEmail(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("email", String.valueOf(email.getText()));
        startActivity(intent);
    }
}