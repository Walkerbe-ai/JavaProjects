package com.example.myshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class StyleDetail extends AppCompatActivity {

    private TextView textViewBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style_detail);
        textViewBuy = findViewById(R.id.textViewBuy);
        Intent intent = getIntent();
        if (intent.hasExtra("order")){
            String order = intent.getStringExtra("order");
            textViewBuy.setText(order);
        }else {
            Intent backToLogin = new Intent(this, MainActivity.class);
            startActivity(backToLogin);
        }
    }
}