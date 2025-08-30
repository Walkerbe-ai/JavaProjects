package com.example.hz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<User> users = new ArrayList<User>();
    public UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        users.add(new User("Shami", "1234",0));
        users.add(new User("Petya", "123456",R.drawable.img));


        ListView listUsers = findViewById(R.id.listUsers);
        adapter = new UserAdapter(this, R.layout.item_list, users);
        listUsers.setAdapter(adapter);
        listUsers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(),("нажат " + users.get(i).getName()), Toast.LENGTH_LONG).show();


            }
        });
    }

    public void addUser(View view) {
        User user = new User("Пусто", "1234", R.drawable.img);
        users.add(user);
        adapter.notifyDataSetChanged();
    }

    public void removeUser(View view) {
        adapter.remove(users.get(0));
        adapter.notifyDataSetChanged();
    }
}