package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class LevelThree extends AppCompatActivity {
    private TextView countLevel;
    private TextView clickCount;
    private TextView countSkill;
    private TextView countStrench;
    private TextView countAuto;
    private int strenchClick;
    private int strenchAutoClick;
    private int countskill;
    private  int click;
    Timer myTimer;

    private Button addClick;
    private Button addAutoClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_three);

        countLevel = findViewById(R.id.countLevel);
        clickCount = findViewById(R.id.clickCount);
        countSkill = findViewById(R.id.countSkills);
        countStrench = findViewById(R.id.countStrench);
        countAuto = findViewById(R.id.countAuto);
        addClick = findViewById(R.id.buttonAddClick);
        addAutoClick = findViewById(R.id.buttonAddAutoClick);

        Bundle arg = getIntent().getExtras();
        strenchClick = arg.getInt("strenchClick");
        strenchAutoClick = arg.getInt("strenchAutoClick");
        countskill = arg.getInt("countskill");
        countskill++;

        countLevel.setText(String.format(getResources().getString(R.string.Level), "3"));
        countSkill.setText(String.format(getResources().getString(R.string.countSkills), String.valueOf(countskill)));
        countStrench.setText(String.format(getResources().getString(R.string.strenchClick), String.valueOf(strenchClick)));
        countAuto.setText(String.format(getResources().getString(R.string.autoClick), String.valueOf(strenchAutoClick)));

        if(strenchAutoClick > 0){
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
            if(countskill == 0){
            addClick.setVisibility(View.INVISIBLE);
            addAutoClick.setVisibility(View.INVISIBLE);
            }
        }
    }
    public void UpgradeAutoClick(View view) {
        if(countskill > 0){
            countskill--;
            countSkill.setText(String.format(getResources().getString(R.string.countSkills), String.valueOf(countskill)));
            strenchAutoClick++;
            countAuto.setText(String.format(getResources().getString(R.string.autoClick), String.valueOf(strenchAutoClick)));
            myTimer = new Timer();
            myTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Test();
                }
            }, 0, 1000);
            if(countskill == 0){
                addClick.setVisibility(View.INVISIBLE);
                addAutoClick.setVisibility(View.INVISIBLE);
            }
        }
    }
}