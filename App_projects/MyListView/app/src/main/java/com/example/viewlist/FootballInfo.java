package com.example.viewlist;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FootballInfo extends AppCompatActivity {

    private TextView titleText;
    private TextView infoText;
    private ImageView footballImage;

    private String title;
    private String info;
    private int img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football_info);
        titleText = findViewById(R.id.titleText);
        infoText = findViewById(R.id.infoText);
        footballImage = findViewById(R.id.footballImage);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Intent intent = getIntent();
        if(intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("imgId")){
            title = intent.getStringExtra("title");
            info = intent.getStringExtra("info");
            img = intent.getIntExtra("imgId", -1);
            titleText.setText(title);
            infoText.setText(info);
            footballImage.setImageResource(img);
        }
        else{
            Intent back = new Intent(this, FootballActivity.class);
            startActivity(intent);
        }
    }
}