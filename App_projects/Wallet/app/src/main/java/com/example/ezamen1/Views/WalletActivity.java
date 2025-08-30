package com.example.ezamen1.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ezamen1.Adapters.CardAdapter;
import com.example.ezamen1.Views.Models.Card;
import com.example.ezamen1.Views.Models.User;
import com.example.ezamen1.R;

public class WalletActivity extends AppCompatActivity {

    User user;
    TextView login_text;
    RecyclerView cards_recycler;
    CardAdapter cardAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        login_text = findViewById(R.id.login_text);
        cards_recycler = findViewById(R.id.cards_recycler);



        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            String login = bundle.getString("login");
            for (User userEl:
                    User.Users) {
                if (userEl.getLogin().equals(login)){
                    user = userEl;
                }
            }

            login_text.setText(user.getLogin());

            CardAdapter.OnCardClickListener clickListener = new CardAdapter.OnCardClickListener(){

                @Override
                public void onCardClick(Card card, int position) {
                    Intent intent = new Intent(getApplicationContext(),InsertUpdateActivity.class);
                    intent.putExtra("login", user.getLogin());
                    intent.putExtra("card_number", card.getCardNumber());
                    startActivity(intent);
                }
            };

            cardAdapter = new CardAdapter();
            cardAdapter.setContext(this);
            cards_recycler.setAdapter(cardAdapter);
            cardAdapter.setCardClickListener(clickListener);


        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        cardAdapter.setData(user.getCards());

    }

    public void onClickShowInsertButton(View view) {
        Intent intent = new Intent(this,InsertUpdateActivity.class);
        intent.putExtra("login", user.getLogin());
        startActivity(intent);
    }
}