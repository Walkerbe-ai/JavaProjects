package com.example.ezamen1.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ezamen1.Views.Models.Card;
import com.example.ezamen1.Views.Models.User;
import com.example.ezamen1.R;

public class MainActivity extends AppCompatActivity {
    EditText login_edit, password_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login_edit = findViewById(R.id.login_edit);
        password_edit = findViewById(R.id.password_edit);

        Card card = new Card("fdfds",1234567812,12,12,333);
        User user = new User("1","1");
        user.insertCard(card);
        User.Users.add(user);

    }

    public void onClickSignIn(View view) {
        String login = login_edit.getText().toString();
        String password = password_edit.getText().toString();
        for (User user:
             User.Users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)){
                Intent intent = new Intent(this,WalletActivity.class);
                intent.putExtra("login", user.getLogin());
                startActivity(intent);
            }
        }
    }

    public void onClickSignUp(View view) {
        String login = login_edit.getText().toString();
        String password = password_edit.getText().toString();
        if (login.trim().length() == 0 || password.trim().length() == 0){
            Toast.makeText(this,"Логин или пароль пустые", Toast.LENGTH_LONG);
        }
        else{
            for (User user:
                 User.Users) {
                if (user.getLogin().equals(login)){
                    Toast.makeText(this,"Такой логин уже испольузется", Toast.LENGTH_LONG);
                    return;
                }
            }
            User.Users.add(new User(login,password));
        }
    }
}