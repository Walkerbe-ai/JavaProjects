package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private TextView countLevel;
    private TextView clickCount;
    private TextView countSkill;
    private TextView countStrench;
    private TextView countAuto;
    private  int click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countLevel = findViewById(R.id.countLevel);
        clickCount = findViewById(R.id.clickCount);
        countSkill = findViewById(R.id.countSkills);
        countStrench = findViewById(R.id.countStrench);
        countAuto = findViewById(R.id.countAuto);

        countLevel.setText(String.format(getResources().getString(R.string.Level), "1"));
        countSkill.setText(String.format(getResources().getString(R.string.countSkills), "0"));
        countStrench.setText(String.format(getResources().getString(R.string.strenchClick), "1"));
        countAuto.setText(String.format(getResources().getString(R.string.autoClick), "0"));
    }
    public void AddClick(View view) {
        click++;
        clickCount.setText(String.valueOf(click));
        if(click == 60){
            Intent intent = new Intent(getApplicationContext(), LevelTwo.class);
            startActivity(intent);
        }
    }

}