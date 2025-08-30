package com.example.timer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView textViewTimer;
    private int seconds = 0;
    private boolean isRunning = false;
    private  boolean wasRunning = false;
    private Spinner spinnerItem;
    private final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewTimer = findViewById(R.id.textViewTimer);
        if(savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds");
            isRunning = savedInstanceState.getBoolean("isRunning");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        spinnerItem = findViewById(R.id.spinnerItem);
        Log.d(TAG, "onCreate");
        runTimer();
    }

    private void runTimer() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs);
                textViewTimer.setText(time);

                if (isRunning) {
                    seconds--;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }


    public void onClickResetTimer(View view) {
        isRunning = false;
        seconds = 0;

    }

    public void onClickStopTimer(View view) {isRunning = false;
        String msg = textViewTimer.getText().toString();
        Intent intent = new Intent(this, createMessange.class);
        intent.putExtra("msg", msg);
        startActivity(intent);

    }

    public void onClickStartTimer(View view)
    {
        int position = spinnerItem.getSelectedItemPosition();
        if(position == 1 && seconds==0)
            seconds = 10;
        if(position == 2 && seconds==0)
            seconds = 20;
        if(position == 3 && seconds==0)
            seconds = 30;
        if(position == 4 && seconds==0)
            seconds = 40;
        if(position == 5 && seconds==0)
            seconds = 50;
        if(position == 6 && seconds==0)
            seconds = 60;
        isRunning = true;

    }
    @Override
    protected  void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("seconds", seconds);
        outState.putBoolean("isRunning", isRunning);
        outState.putBoolean("wasRunning", wasRunning);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "onStart");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "onStop");
        isRunning = false;
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "onRestart");
    }




}