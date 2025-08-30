package com.example.xz_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<Country> countries = new ArrayList<>();
CountryAdapter countryAdapter;
private int abc = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countries.add(new Country("Канада", "Оттава", R.drawable.canada));
        countries.add(new Country("Россия", "Москва", R.drawable.russia));
        countries.add(new Country("Франция", "Париж", R.drawable.france));
        countries.add(new Country("США", "Вашингтон", R.drawable.usa));
        countries.add(new Country("Польша", "Варшава", R.drawable.polsha));

        CountryAdapter.OnCountryClickListener listener = new CountryAdapter.OnCountryClickListener() {
            @Override
            public void onCountryClick(Country country, int position) {
                Toast.makeText(getApplicationContext(), "Выбрана страна " + country.getName(), Toast.LENGTH_SHORT).show();
            }
        };
        RecyclerView recyclerView = findViewById(R.id.listCountries);
        countryAdapter = new CountryAdapter(this, countries, listener);
        recyclerView.setAdapter(countryAdapter);
        if (abc == 2){
            countries.set(4, new Country("Залупа", "Варшава", R.drawable.polsha));
            countryAdapter.notifyDataSetChanged();
        }




    }

    public void btnUpdate(View view) {
        countries.remove(0);
        countryAdapter.notifyItemRemoved(0);
        countryAdapter.notifyItemRangeChanged(0, countries.size());

    }
}