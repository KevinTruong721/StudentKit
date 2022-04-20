package com.example.studentkit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class login extends AppCompatActivity {

    EditText username, password;
    Button login;
    databasehelp d;
    ConstraintLayout log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.et_username1);
        password = findViewById(R.id.et_pass1);
        login = findViewById(R.id.btn_signin1);
        log = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u = username.getText().toString();
                String p = password.getText().toString();
                    Boolean valid = d.exist_password(u, p);
                    if (valid == true) {
                        Intent intent_menu= new Intent(getApplicationContext(), menu.class);
                        startActivity(intent_menu);
                    }
                    else {
                        Snackbar.make(log, "Unsuccessful login", Snackbar.LENGTH_LONG).show();
                    }
            }
        });
    }
}