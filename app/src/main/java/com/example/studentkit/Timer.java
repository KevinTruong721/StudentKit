package com.example.studentkit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Timer extends AppCompatActivity {
    static final long START_TIME_IN_MILLIS = 1500000;

    TextView t_timer;
    Button b_start, b_reset, b_menu;

    CountDownTimer time;
    boolean time_running;
    long time_remaining = START_TIME_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        t_timer = findViewById(R.id.tv_timer);
        b_start = findViewById(R.id.btn_start);
        b_reset = findViewById(R.id.btn_reset);
        b_menu = findViewById(R.id.btn_menu1);


        b_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Timer.this, menu.class);
                startActivity(i);
            }
        });

        b_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (time_running == true) {
                    time_pause();
                }
                else if(time_running == false) {
                    time_start();
                }
            }
        });

        b_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time_reset();
            }
        });

        updateTimer();
    }

    public void time_pause() {
        time_running = false;
        time.cancel();
        b_start.setText("Start");
        b_reset.setVisibility(View.VISIBLE);
    }

    public void time_start() {
        time = new CountDownTimer(time_remaining, 1000) {
            @Override
            public void onTick(long time_done) {
                time_remaining = time_done;
                updateTimer();
            }

            @Override
            public void onFinish() {
                time_running = false;
                b_start.setText("Start");
                b_start.setVisibility(View.INVISIBLE);
                b_reset.setVisibility(View.VISIBLE);
            }
        }.start();
        time_running = true;
        b_start.setText("pause");
        b_reset.setVisibility(View.INVISIBLE);
    }

    public void updateTimer() {
        int convertMin = (int)time_remaining/1000/60;
        int convertSec = (int)time_remaining/1000%60;

        String time = String.format(Locale.getDefault(), "%02d:%02d", convertMin, convertSec);
        t_timer.setText(time);
    }

    public void time_reset() {
        time_remaining = START_TIME_IN_MILLIS;
        updateTimer();
        b_reset.setVisibility(View.INVISIBLE);
        b_start.setVisibility(View.VISIBLE);
    }
}