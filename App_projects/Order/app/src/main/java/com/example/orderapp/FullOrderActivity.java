package com.example.orderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FullOrderActivity extends AppCompatActivity {

    private TextView fullOrderTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_order);
        fullOrderTextView = findViewById(R.id.orderTextView);
        Intent intent = getIntent();
        if(intent.hasExtra("order")){
            String order = intent.getStringExtra("order");
            fullOrderTextView.setText(order);
        }
        else{
            Intent backToLogin = new Intent(this, MainActivity.class);
            startActivity(backToLogin);
        }
    }
}