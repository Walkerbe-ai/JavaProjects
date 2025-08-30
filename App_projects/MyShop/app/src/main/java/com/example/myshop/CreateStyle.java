package com.example.myshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class CreateStyle extends AppCompatActivity {

    private TextView textViewHello;
    private CheckBox checkBoxTshirt;
    private CheckBox checkBoxJeans;
    private CheckBox checkBoxSocks;
    private Spinner spinnerColor;
    private Spinner spinnerSize;


    private String name;
    private String password;
    private String email;
    private String gender;
    private StringBuilder builderAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_style);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        password = intent.getStringExtra("password");
        email = intent.getStringExtra("email");

        checkBoxTshirt = findViewById(R.id.checkBoxTshirt);
        checkBoxJeans = findViewById(R.id.checkBoxJeans);
        checkBoxSocks = findViewById(R.id.checkBoxSocks);
        spinnerColor = findViewById(R.id.spinnerColor);
        spinnerSize = findViewById(R.id.spinnerSize);

        gender = "Мужской";

        textViewHello = findViewById(R.id.textViewHello);
        String hello = String.format("Здравствуйте, %s, выберите пол", name);
        textViewHello.setText(hello);
        builderAdd = new StringBuilder();
    }

    public void radioButtonClick(View view) {
        RadioButton radioButton = (RadioButton) view;
        int id = radioButton.getId();
        if (id == R.id.radioButton5){
            gender = "Мужской";
        }
        else{
            gender = "Женский";
        }
    }
    public void onClickSendBuy(View view) {
        builderAdd.setLength(0);
        if(checkBoxTshirt.isChecked()){
            builderAdd.append("Футболка.");
        }
        if(checkBoxJeans.isChecked()){
            builderAdd.append("Джинсы.");
        }
        if(checkBoxSocks.isChecked()){
            builderAdd.append("Носочки.");
        }
        String clothColor = spinnerColor.getSelectedItem().toString();
        String clothSize = spinnerSize.getSelectedItem().toString();
        String order = String.format("Имя: %s.\nПароль: %s.\nEmail: %s.\nПол: %s.\nЦвет одежды: %s. \nРазмер одежды: %s.", name, password,email, gender , clothColor, clothSize);
        String additions;
        if(builderAdd.length()>0){
            additions = "\nВид одежды: " +builderAdd.toString();
        } else {
            additions = "";
        }
        String fullOrder = order + additions;
        Intent intent = new Intent(this, StyleDetail.class);
        intent.putExtra("order", fullOrder);
        startActivity(intent);
    }

    public void ClickSocks(View view) {
        if(checkBoxSocks.isChecked()){
            checkBoxJeans.setEnabled(false);
            checkBoxTshirt.setEnabled(false);
        }
        else{
            checkBoxJeans.setEnabled(true);
            checkBoxTshirt.setEnabled(true);
        }
    }

    public void ClickJeans(View view) {
        if(checkBoxJeans.isChecked()){
            checkBoxSocks.setEnabled(false);
            checkBoxTshirt.setEnabled(false);
        }
        else{
            checkBoxSocks.setEnabled(true);
            checkBoxTshirt.setEnabled(true);
        }
    }

    public void ClickShirt(View view) {
        if(checkBoxTshirt.isChecked()){
            checkBoxJeans.setEnabled(false);
            checkBoxSocks.setEnabled(false);
        }
        else{
            checkBoxJeans.setEnabled(true);
            checkBoxSocks.setEnabled(true);
        }
    }
}