package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    public EditText et_RegistrationEmail, et_RegistrationUserName, et_RegistrationPassword, et_RegistrationFullName;
    public Button btn_Registration, btn_Back;

    DBhelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();
        listeners();
    }

    private void init() {
    }

    private void listeners() {
        btn_Registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Registration();
            }
        });

        btn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(back);
                finish();
            }
        });
    }

    private void Registration() {
        String email = et_RegistrationEmail.getText().toString().trim();
        String username = et_RegistrationUserName.getText().toString().trim();
        String password = et_RegistrationPassword.getText().toString().trim();
        String name = et_RegistrationFullName.getText().toString().trim();

        if (email.isEmpty()) {
            Toast.makeText(this, "E-mail megadása kötelező!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (username.isEmpty()) {
            Toast.makeText(this, "Felhasználónév megadása kötelező!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.isEmpty()) {
            Toast.makeText(this, "Jelszó megadása kötelező!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (name.isEmpty()) {
            Toast.makeText(this, "Teljes név megadása kötelező!", Toast.LENGTH_SHORT).show();
            return;
        }



        et_RegistrationEmail = findViewById(R.id.et_RegistrationEmail);
        et_RegistrationUserName = findViewById(R.id.et_RegistrationUserName);
        et_RegistrationPassword = findViewById(R.id.et_RegistrationPassword);
        et_RegistrationFullName = findViewById(R.id.et_RegistrationFullName);
        btn_Registration = findViewById(R.id.btn_Registration);
        btn_Back = findViewById(R.id.btn_Back);

        adatbazis = new DBhelper(RegisterActivity.this);
    }
}