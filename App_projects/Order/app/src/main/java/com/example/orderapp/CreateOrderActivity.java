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

    private TextView text1;
    private TextView text2;
    private CheckBox check1;
    private CheckBox check2;
    private CheckBox check3;
    private Spinner teaSpinner;
    private Spinner coffeeSpinner;

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

        check1 = findViewById(R.id.checkBox6);
        check2 = findViewById(R.id.checkBox7);
        check3 = findViewById(R.id.checkBox8);
        teaSpinner = findViewById(R.id.spinnerTea);
        coffeeSpinner = findViewById(R.id.spinnerCoffee);

        drink = "Tea";

        text1 = findViewById(R.id.textView);
        text2 = findViewById(R.id.textView4);
        String hello = String.format("Hi %s, what is your order?", name);
        text1.setText(hello);

        String add = String.format(getString(R.string.secondString), drink);
        text2.setText(add);

        builderAdd = new StringBuilder();
    }

    public void radioButtonClick(View view) {
        RadioButton radioButton = (RadioButton) view;
        int id = radioButton.getId();
        if (id == R.id.radioButton5){
            drink = "Tea";
            teaSpinner.setVisibility(View.VISIBLE);
            coffeeSpinner.setVisibility(View.INVISIBLE);
            check3.setVisibility(View.VISIBLE);

        }
        else{
            drink = "Coffee";
            coffeeSpinner.setVisibility(View.VISIBLE);
            teaSpinner.setVisibility(View.INVISIBLE);
            check3.setVisibility(View.INVISIBLE);
        }
    }

    public void sendOrderClick(View view) {
        builderAdd.setLength(0);
        if(check1.isChecked())
            builderAdd.append("Milk ");
        if(check2.isChecked())
            builderAdd.append("Sugar ");
        if(check3.isChecked())
            builderAdd.append("Lemon ");
        String optionOfDrink = "";
        if(drink.equals("Tea"))
            optionOfDrink = teaSpinner.getSelectedItem().toString();
        else
            optionOfDrink = coffeeSpinner.getSelectedItem().toString();
        String order  = String.format("Name: %s \nPassword: %s \nEmail: %s \nDrink: %s \nType of drink: %s \n", name, password, email, drink, optionOfDrink);
        String additions;
        if(builderAdd.length()>0)
            additions = "Additions: " + builderAdd.toString();
        else
            additions = "";
        String fullOrder = order +additions;
        Intent intent = new Intent(this, FullOrderActivity.class);
        intent.putExtra("order", fullOrder);
        startActivity(intent);
    }

    public void milkClick(View view) {
        if(check1.isChecked())
            check3.setEnabled(false);
        else
            check3.setEnabled(true);
    }

    public void lemonClick(View view) {
        if(check3.isChecked())
            check1.setEnabled(false);
        else
            check1.setEnabled(true);
    }
}