package com.example.viewlist;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FootballActivity extends AppCompatActivity {

    private ListView footballList;
    private ArrayList<None> footballActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        footballActivity = new ArrayList<>();
        footballActivity.add(new None(getString(R.string.football1_title), getString(R.string.football1_info),R.drawable.football1));
        footballActivity.add(new None(getString(R.string.football2_title),getString(R.string.football2_info), R.drawable.football2));
        footballActivity.add(new None(getString(R.string.football3_title),getString(R.string.football3_info), R.drawable.football3));
        footballList = findViewById(R.id.footballList);
        ArrayAdapter<None> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, footballActivity);
        footballList.setAdapter(adapter);
        footballList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                None none = footballActivity.get(pos);
                Intent intent = new Intent(getApplicationContext(), FootballInfo.class);
                intent.putExtra("title", none.getTitle());
                intent.putExtra("info", none.getInfo());
                intent.putExtra("imgId", none.getImageResourceId());
                startActivity(intent);
            }
        });
    }
}