package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoggedIn extends AppCompatActivity {

    private TextView tv_LoggedUserName;
    private Button btn_Logout;

    DBhelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        init();

        loggedIn();

        btn_Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logout = new Intent(LoggedIn.this, MainActivity.class);
                startActivity(logout);
                finish();
            }
        });
    }


    private void loggedIn() {
        String userInput = MainActivity.userInput;

        Cursor adatok = adatbazis.dataQuery(userInput);

        StringBuilder builder = new StringBuilder();
        while (adatok.moveToNext()) {
            builder.append("Üdvözöllek ").append(adatok.getString(0)).append("\n\n");

            tv_LoggedUserName.setText(builder.toString());

        }
    }


    private void init() {
        tv_LoggedUserName = findViewById(R.id.tv_LoggedUserName);
        btn_Logout = findViewById(R.id.btn_Logout);

        adatbazis = new DBhelper(LoggedIn.this);
    }
}
