package com.example.myshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView logo;
    private EditText namef;
    private EditText passwordf;
    private EditText emailf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logo = findViewById(R.id.logo);
        logo.setImageDrawable(getResources().getDrawable(R.drawable.cloth));
        namef = findViewById(R.id.nameField);
        passwordf = findViewById(R.id.passwordField);
        emailf = findViewById(R.id.emailField);
    }
    public void createStyleClick(View view) {
        String name = namef.getText().toString().trim();
        String pass = passwordf.getText().toString().trim();
        String email = emailf.getText().toString().trim();
        if(!name.isEmpty() && !pass.isEmpty() && !email.isEmpty() && email.contains("@")){
            Intent intent = new Intent(this, CreateStyle.class);
            intent.putExtra("name", name);
            intent.putExtra("password", pass);
            intent.putExtra("email", email);
            startActivity(intent);
        }
        else
            Toast.makeText(this, "Не все поля заполнены!", Toast.LENGTH_SHORT).show();
    }
}