package com.example.ekzhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    List<list> list1 = new ArrayList<list>();
    Timer myTimer;

//2.	Реализовать приложение "Аутентификатор", в котором на
// главном окне выводятся все адреса почты и их случайные сгенерированные ключи,
// который обновляются каждые 30 секунд. Сгенерированный ключ должен состоять из 6
// случайных букв и цифр одного регистра. Есть возможность добавить новый адрес почты.
    ListView listView;
    AdapterList adapter;
    String email1 = "";
    int z = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        list1.add(new list("gdfgdfg@gfdgdf.gfdgdf", "gdfgfd4*"));
        list1.add(new list("gdfgdfg@gfdgdf.gfdgdf1", "gdfgfd2*"));
        list1.add(new list("gdfgdfg@gfdgdf.gfdgdf1", "gdfgfd3*"));
        Intent intent = getIntent();
        email1 = intent.getStringExtra("email");
        if(intent.getStringExtra("email") != null) {
            list1.add(new list(email1, "gdfgfd3*"));
        }
        adapter = new AdapterList(getApplicationContext(),
        R.layout.list_item, list1);
        z = 1;


        listView.setAdapter(adapter);
        myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Test();
            }
        }, 0, 30000);

    }


    private static final String ALLOWED_CHARACTERS ="0123456789qwertyuiopasdfghjklzxcvbnm";
    public  void Test(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                list1.forEach(listItem -> {
                  listItem.key = getRandomString(6);
                });
                adapter.notifyDataSetChanged();
            }
        });

    }
    private static String getRandomString(final int sizeOfRandomString)
    {
        final Random random=new Random();
        final StringBuilder sb=new StringBuilder(sizeOfRandomString);
        for(int i=0;i<sizeOfRandomString;++i)
            sb.append(ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length())));
        return sb.toString();
    }
    public void clickAddEmail(View view) {
        Intent intent = new Intent(this, addEmail.class);
        startActivity(intent);
        z = 2;
    }
}