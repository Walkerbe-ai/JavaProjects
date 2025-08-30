package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class LevelTwo extends AppCompatActivity {
    private TextView countLevel;
    private TextView clickCount;
    private TextView countSkill;
    private TextView countStrench;
    private TextView countAuto;

    private int strenchClick = 1;
    private int strenchAutoClick;
    private int countskill = 1;

    private  int click;
    Timer myTimer;

    private Button addClick;
    private Button addAutoClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_two);
        countLevel = findViewById(R.id.countLevel);
        clickCount = findViewById(R.id.clickCount);
        countSkill = findViewById(R.id.countSkills);
        countStrench = findViewById(R.id.countStrench);
        countAuto = findViewById(R.id.countAuto);
        addClick = findViewById(R.id.buttonAddClick);
        addAutoClick = findViewById(R.id.buttonAddAutoClick);

        countLevel.setText(String.format(getResources().getString(R.string.Level), "2"));
        countSkill.setText(String.format(getResources().getString(R.string.countSkills), String.valueOf(countskill)));
        countStrench.setText(String.format(getResources().getString(R.string.strenchClick), String.valueOf(strenchClick)));
        countAuto.setText(String.format(getResources().getString(R.string.autoClick), String.valueOf(strenchAutoClick)));

        if(strenchAutoClick == 0){
            myTimer = new Timer();
            myTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Test();
                }
            }, 0, 1000);
        }
    }
    public  void Test(){
        click += strenchAutoClick;
        clickCount.setText(String.valueOf(click));
        if(click > 60){
            myTimer.cancel();
            Intent intent = new Intent(getApplicationContext(), LevelThree.class);
            intent.putExtra("countskill", countskill);
            intent.putExtra("strenchClick", strenchClick);
            intent.putExtra("strenchAutoClick", strenchAutoClick);
            startActivity(intent);
        }
    }

    public void AddClick(View view) {
        click += strenchClick;
        clickCount.setText(String.valueOf(click));
        if(click > 60){
            Intent intent = new Intent(getApplicationContext(), LevelThree.class);
            intent.putExtra("countskill", countskill);
            intent.putExtra("strenchClick", strenchClick);
            intent.putExtra("strenchAutoClick", strenchAutoClick);
            startActivity(intent);
        }
    }

    public void UpgradeClick(View view) {
        if(countskill > 0){
            countskill--;
            countSkill.setText(String.format(getResources().getString(R.string.countSkills), String.valueOf(countskill)));
            strenchClick++;
            countStrench.setText(String.format(getResources().getString(R.string.strenchClick), String.valueOf(strenchClick)));
            addClick.setVisibility(View.INVISIBLE);
            addAutoClick.setVisibility(View.INVISIBLE);
        }
    }
    public void UpgradeAutoClick(View view) {
        if(countskill > 0){
            countskill--;
            countSkill.setText(String.format(getResources().getString(R.string.countSkills), String.valueOf(countskill)));
            strenchAutoClick++;
            countAuto.setText(String.format(getResources().getString(R.string.autoClick), String.valueOf(strenchAutoClick)));
            if(strenchAutoClick == 0){
                myTimer = new Timer();
                myTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Test();
                    }
                }, 0, 1000);
            }
            addClick.setVisibility(View.INVISIBLE);
            addAutoClick.setVisibility(View.INVISIBLE);
        }
    }
}