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
import com.google.android.material.textfield.TextInputEditText;

import org.mozilla.javascript.tools.jsc.Main;

public class MainActivity extends AppCompatActivity {

    EditText username;
    Button register, signin;
    databasehelp d;
    TextInputEditText password, passwordagain;
    ConstraintLayout main_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.et_username1);
        password = findViewById(R.id.et_pass1);
        passwordagain = findViewById(R.id.et_passagain);
        register = findViewById(R.id.btn_signin1);
        signin = findViewById(R.id.btn_signin);
        main_layout = findViewById(R.id.main);
        d= new databasehelp(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u = username.getText().toString();
                String p = password.getText().toString();
                String pa = passwordagain.getText().toString();


                if (p.equals(pa)) {
                    Boolean exist_user = d.exist_username(u);
                    if(exist_user==false) {
                        Boolean i = d.insert_userAndPassword(u,p);
                        if (i == true) {
                            Snackbar.make(main_layout, "Successful registration", Snackbar.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), menu.class);
                            startActivity(intent);
                        }
                        else {
                            Snackbar.make(main_layout, "Unsuccessful registration", Snackbar.LENGTH_LONG).show();
                        }
                    }
                    else {
                        Snackbar.make(main_layout, "This username is already taken", Snackbar.LENGTH_LONG).show();
                    }

                }
                else {
                    Snackbar.make(main_layout, "The two passwords are not the same, try again", Snackbar.LENGTH_LONG).show();
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), login.class);
                startActivity(i);
            }
        });
    }
}