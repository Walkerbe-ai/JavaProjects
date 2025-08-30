package com.example.viewlist;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView sport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
        sport = findViewById(R.id.ListViewSport);
        sport.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position){
                    case 0:
                        Intent integer = new Intent(getApplicationContext(), BorbaActivity.class);
                        startActivity(integer);
                        break;
                    case 1:
                        Intent integer1 = new Intent(getApplicationContext(), FootballActivity.class);
                        startActivity(integer1);
                        break;
                    case 2:
                        Intent integer2 = new Intent(getApplicationContext(), VolleyballActivity.class);
                        startActivity(integer2);
                        break;
                }
            }
        });

    }
}