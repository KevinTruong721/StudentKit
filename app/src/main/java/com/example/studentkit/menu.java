package com.example.studentkit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu extends AppCompatActivity {

    Button b_timer, b_calculator, b_sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        b_timer = findViewById(R.id.btn_timer);
        b_calculator = findViewById(R.id.btn_calculator);
        b_sign = findViewById(R.id.btn_sign);


        b_timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(menu.this, Timer.class);
                startActivity(i);
            }
        });


        b_calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(menu.this, Calculator1.class);
                startActivity(i1);
            }
        });
        b_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(menu.this, MainActivity.class);
                startActivity(i2);
            }
        });


    }
}