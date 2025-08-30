package com.example.viewlist;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class BorbaInfo extends AppCompatActivity {

    private TextView titleText;
    private TextView infoText;
    private ImageView borbaImage;

    private String title;
    private String info;
    private int img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borba_info);
        titleText = findViewById(R.id.titleText);
        infoText = findViewById(R.id.infoText);
        borbaImage = findViewById(R.id.borbaImage);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Intent intent = getIntent();
        if(intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("imgId")){
            title = intent.getStringExtra("title");
            info = intent.getStringExtra("info");
            img = intent.getIntExtra("imgId", -1);
            titleText.setText(title);
            infoText.setText(info);
            borbaImage.setImageResource(img);
        }
        else{
            Intent back = new Intent(this, BorbaActivity.class);
            startActivity(intent);
        }
    }
}