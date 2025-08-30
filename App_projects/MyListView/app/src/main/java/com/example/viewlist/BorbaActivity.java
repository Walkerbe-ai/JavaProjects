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

public class BorbaActivity extends AppCompatActivity {

    private ListView borbaList;
    private ArrayList<None> borbaActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borba);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        borbaActivity = new ArrayList<>();
        borbaActivity.add(new None(getString(R.string.borba1_title), getString(R.string.borba1_info),R.drawable.borba1));
        borbaActivity.add(new None(getString(R.string.borba2_title),getString(R.string.borba2_info), R.drawable.borba2));
        borbaActivity.add(new None(getString(R.string.borba3_title),getString(R.string.borba3_info), R.drawable.borba3));
        borbaList = findViewById(R.id.borbaList);
        ArrayAdapter<None> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, borbaActivity);
        borbaList.setAdapter(adapter);
        borbaList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                None none = borbaActivity.get(pos);
                Intent intent = new Intent(getApplicationContext(), BorbaInfo.class);
                intent.putExtra("title", none.getTitle());
                intent.putExtra("info", none.getInfo());
                intent.putExtra("imgId", none.getImageResourceId());
                startActivity(intent);
            }
        });
    }
}