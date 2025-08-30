package com.example.instruments;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CatActivity extends AppCompatActivity {

    private ListView catList;
    private ArrayList<Cat> cats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        cats = new ArrayList<>();
        cats.add(new Cat(getString(R.string.cat1_title),getString(R.string.cat1_info), R.drawable.cat1));
        cats.add(new Cat(getString(R.string.cat2_title),getString(R.string.cat2_info), R.drawable.cat2));
        cats.add(new Cat(getString(R.string.cat3_title),getString(R.string.cat3_info), R.drawable.cat3));
        catList = findViewById(R.id.catList);
        ArrayAdapter<Cat> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, cats);
        catList.setAdapter(adapter);
        catList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                Cat cat = cats.get(pos);
                Intent intent = new Intent(getApplicationContext(), CatInfoActivity.class);
                intent.putExtra("title", cat.getTitle());
                intent.putExtra("info", cat.getInfo());
                intent.putExtra("imgId", cat.getImageId());
                startActivity(intent);
            }
        });
    }
}