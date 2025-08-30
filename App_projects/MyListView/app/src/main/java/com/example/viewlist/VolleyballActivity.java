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

public class VolleyballActivity extends AppCompatActivity {

    private ListView volleyballList;
    private ArrayList<None> volleyballActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volleyball);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        volleyballActivity = new ArrayList<>();
        volleyballActivity.add(new None(getString(R.string.volleyball1_title), getString(R.string.volleyball1_info),R.drawable.volleyball1));
        volleyballActivity.add(new None(getString(R.string.volleyball2_title),getString(R.string.volleyball2_info), R.drawable.volleyball2));
        volleyballActivity.add(new None(getString(R.string.volleyball3_title),getString(R.string.volleyball3_info), R.drawable.volleyball3));
        volleyballList = findViewById(R.id.footballballlList);
        ArrayAdapter<None> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, volleyballActivity);
        volleyballList.setAdapter(adapter);
        volleyballList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                None none = volleyballActivity.get(pos);
                Intent intent = new Intent(getApplicationContext(), VolleyballInfo.class);
                intent.putExtra("title", none.getTitle());
                intent.putExtra("info", none.getInfo());
                intent.putExtra("imgId", none.getImageResourceId());
                startActivity(intent);
            }
        });
    }
}