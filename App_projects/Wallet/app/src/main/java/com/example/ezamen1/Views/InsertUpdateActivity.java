package com.example.ezamen1.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ezamen1.Views.Models.Card;
import com.example.ezamen1.Views.Models.User;
import com.example.ezamen1.R;

public class InsertUpdateActivity extends AppCompatActivity {

    EditText bank_edit, number_card_edit, month_edit, year_edit, ccv_edit;
    Button delete_button, ok_button;
    User user;
    Card card = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_update);

        bank_edit = findViewById(R.id.bank_edit);
        number_card_edit = findViewById(R.id.number_card_edit);
        month_edit = findViewById(R.id.month_edit);
        year_edit = findViewById(R.id.year_edit);
        ccv_edit = findViewById(R.id.ccv_edit);
        delete_button = findViewById(R.id.delete_button);
        ok_button = findViewById(R.id.ok_button);


            String login  = getIntent().getStringExtra("login");
            for (User userEl:
                    User.Users) {
                if (userEl.getLogin().equals(login)){
                    user = userEl;
                }
            }
            if (getIntent().hasExtra("card_number")){
                long card_number  = getIntent().getLongExtra("card_number", 0);
                for (Card cardEl:
                        user.getCards()) {
                    if (cardEl.getCardNumber() == card_number){
                        card = cardEl;
                    }
                }
                bank_edit.setText(card.getBank());
                number_card_edit.setText(String.valueOf(card.getCardNumber()));
                month_edit.setText(String.valueOf(card.getEndMonth()));
                year_edit.setText(String.valueOf(card.getEndYear()));
                ccv_edit.setText(String.valueOf(card.getCcv()));
                delete_button.setVisibility(View.VISIBLE);
                ok_button.setText("Изменить");
            }
        }


    public void onClickInsert(View view) {
        if (card == null) {
            user.insertCard(new Card(bank_edit.getText().toString(), Long.parseLong(number_card_edit.getText().toString()),
                    Integer.parseInt(month_edit.getText().toString()), Integer.parseInt(year_edit.getText().toString()), Integer.parseInt(ccv_edit.getText().toString())));
        }
        else{
            card.setBank(bank_edit.getText().toString());
            card.setCardNumber(Long.parseLong(number_card_edit.getText().toString()));
            card.setEndMonth(Integer.parseInt(month_edit.getText().toString()));
            card.setEndYear(Integer.parseInt(year_edit.getText().toString()));
            card.setCcv(Integer.parseInt(ccv_edit.getText().toString()));
            user.updateCard(card);
        }
        finish();
    }

    public void onClickDelete(View view) {
        user.deleteCard(card);
        finish();
    }
}