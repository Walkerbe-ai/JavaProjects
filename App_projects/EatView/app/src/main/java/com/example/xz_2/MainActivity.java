package com.example.xz_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    static int position1 = 0;
 static ArrayList<Eat> eats = new ArrayList<>();
 static EatAdapter eatAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EatAdapter.OnEatClickListener listener = new EatAdapter.OnEatClickListener() {
            @Override
            public void onEatClick(Eat eat, int position) {
                position1 = position;
                Intent intent = new Intent(getApplicationContext(), EditItem.class);
                intent.putExtra("index", position);
                startActivity(intent);

            }
        };
        RecyclerView recyclerView = findViewById(R.id.listEats);
        eatAdapter = new EatAdapter(this, eats, listener);
        recyclerView.setAdapter(eatAdapter);

    }

    public void CreateView(View view) {
        Intent intent = new Intent(this, CreateEat.class);
        startActivity(intent);
    }
}