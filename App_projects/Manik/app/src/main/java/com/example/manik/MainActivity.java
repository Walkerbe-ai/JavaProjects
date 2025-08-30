package com.example.manik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void AdminLogin(View view) {
        Intent intent = new Intent(this, LoginAdmin.class);
        startActivity(intent);
    }

    public void ClientsCreateOrder(View view) {
        Intent intent = new Intent(this, CreateOrder.class);
        startActivity(intent);
    }
}