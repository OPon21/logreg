package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_UserName, et_Password;
    private Button btn_Login, btn_Registration;

    static String userInput;

    DBhelper adatbazis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });

        btn_Registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registration = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(registration);
                finish();
            }
        });
    }


    private void Login() {
        String password = et_Password.getText().toString().trim();

        userInput = et_UserName.getText().toString().trim();

        if (userInput.isEmpty()) {
            Toast.makeText(this, "A felhasználónév vagy E-mail cím megadása kötelező!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.isEmpty()) {
            Toast.makeText(this, "A jelszó megadása kötelező!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!adatbazis.loginQuery(userInput, password)) {
            Toast.makeText(this, "Hibás felhasználónév vagy jelszó!", Toast.LENGTH_SHORT).show();
        }

        else {
            Intent login = new Intent(MainActivity.this, LoggedIn.class);
            startActivity(login);
            finish();
        }
    }


    private void init() {
        et_UserName = findViewById(R.id.et_UserName);
        et_Password = findViewById(R.id.et_Password);
        btn_Login = findViewById(R.id.btn_Login);
        btn_Registration = findViewById(R.id.btn_Registration);

        adatbazis = new DBhelper(MainActivity.this);
    }
}

