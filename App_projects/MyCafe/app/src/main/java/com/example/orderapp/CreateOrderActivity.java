package com.example.orderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class CreateOrderActivity extends AppCompatActivity {

    private TextView textViewHello;
    private TextView textViewAdd;
    private CheckBox checkBoxMilk;
    private CheckBox checkBoxLemon;
    private CheckBox checkBoxSugar;
    private Spinner spinnerTea;
    private Spinner spinnerCoffee;

    private String drink;

    private String name;
    private String password;
    private String email;
    private StringBuilder builderAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        password = intent.getStringExtra("password");
        email = intent.getStringExtra("email");

        checkBoxMilk = findViewById(R.id.checkBoxMilk);
        checkBoxLemon = findViewById(R.id.checkBoxLemon);
        checkBoxSugar = findViewById(R.id.checkBoxSugar);
        spinnerCoffee = findViewById(R.id.spinnerCoffee);
        spinnerTea = findViewById(R.id.spinnerTea);

        drink = "Tea";

        textViewHello = findViewById(R.id.textViewHello);
        textViewAdd = findViewById(R.id.textViewAdd);
        String hello = String.format("Hi %s, what is your order?", name);
        textViewHello.setText(hello);

        String add = String.format(getString(R.string.secondString), drink);
        textViewAdd.setText(add);

        builderAdd = new StringBuilder();
    }

    public void radioButtonClick(View view) {
        RadioButton radioButton = (RadioButton) view;
        int id = radioButton.getId();
        if (id == R.id.radioButton5){
            drink = "Tea";
            spinnerTea.setVisibility(View.VISIBLE);
            spinnerCoffee.setVisibility(View.INVISIBLE);
            checkBoxLemon.setVisibility(View.VISIBLE);

        }
        else{
            drink = "Coffee";
            spinnerCoffee.setVisibility(View.VISIBLE);
            spinnerTea.setVisibility(View.INVISIBLE);
            if (checkBoxLemon.isChecked())
                checkBoxLemon.setChecked(false);
            checkBoxLemon.setVisibility(View.INVISIBLE);
        }
    }

    public void onClickSendOrder(View view) {
        builderAdd.setLength(0);
        if(checkBoxMilk.isChecked()){
            builderAdd.append("молоко").append(" ");
        }
        if(checkBoxSugar.isChecked()){
            builderAdd.append("сахар").append(" ");
        }
        if(checkBoxLemon.isChecked()){
            builderAdd.append("лимон").append(" ");
        }
        String optionOfDrink = "";
        if(drink.equals("Чай")){
            optionOfDrink = spinnerTea.getSelectedItem().toString();
        }else {
            optionOfDrink = spinnerCoffee.getSelectedItem().toString();
        }
        String order = String.format("Имя: %s.\nПароль: %s.\nEmail: %s.\nНапиток: %s.\nВид напитка: %s.", name, password,email ,drink, optionOfDrink);
        String additions;
        if(builderAdd.length()>0){
            additions = "\nНеобходимые добавки: " + builderAdd.toString();
        } else {
            additions = "";
        }
        String fullOrder = order + additions;
        Intent intent = new Intent(this, OrderDetailMainActivity.class);
        intent.putExtra("order", fullOrder);
        startActivity(intent);
    }

    public void ClickMilk(View view) {
        if(checkBoxMilk.isChecked()){
            checkBoxLemon.setEnabled(false);
        }else{
            checkBoxLemon.setEnabled(true);
        }
    }

    public void ClickLemon(View view) {
        if(checkBoxLemon.isChecked()){
            checkBoxMilk.setEnabled(false);
        }else{
            checkBoxMilk.setEnabled(true);
        }
    }
}