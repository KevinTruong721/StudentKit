package com.example.studentkit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calculator1 extends AppCompatActivity {

    Button b_zero, b_one, b_two, b_three, b_four, b_five, b_six, b_seven, b_eight, b_nine, b_ac, b_division, b_multiplication, b_addition, b_subtraction, b_menu, b_decimal, b_equal;
    TextView t_equation, t_answer;

    String equations = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator1);

        b_menu = findViewById(R.id.bt_menu);

        b_equal = findViewById(R.id.bt_equal);
        b_decimal = findViewById(R.id.bt_decimal);

        b_zero = findViewById(R.id.bt_zero);
        b_one = findViewById(R.id.bt_one);
        b_two = findViewById(R.id.bt_two);
        b_three = findViewById(R.id.bt_three);
        b_four = findViewById(R.id.bt_four);
        b_five = findViewById(R.id.bt_five);
        b_six = findViewById(R.id.bt_six);
        b_seven = findViewById(R.id.bt_seven);
        b_eight = findViewById(R.id.bt_eight);
        b_nine = findViewById(R.id.bt_nine);

        b_ac = findViewById(R.id.bt_ac);
        b_division = findViewById(R.id.bt_division);
        b_multiplication = findViewById(R.id.bt_multiplication);
        b_addition = findViewById(R.id.bt_addition);
        b_subtraction = findViewById(R.id.bt_subtraction);


        t_equation = findViewById(R.id.tvv_equation);
        t_answer = findViewById(R.id.tvv_answer);

        b_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Calculator1.this, menu.class);
                startActivity(i);
            }
        });

        b_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equal();
            }
        });

        b_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ac();
            }
        });


        b_decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decimal();
            }
        });


        b_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                division();
            }
        });

        b_multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multiplication();
            }
        });

        b_addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addition();
            }
        });

        b_subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subtraction();
            }
        });

        b_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zero();
            }
        });

        b_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                one();
            }
        });


        b_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                two();
            }
        });

        b_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                three();
            }
        });

        b_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                four();
            }
        });

        b_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                five();
            }
        });

        b_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                six();
            }
        });

        b_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seven();
            }
        });

        b_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eight();
            }
        });

        b_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nine();
            }
        });


    }

    public void equation(String value) {
        equations = equations + value;
        t_equation.setText(equations);
    }

    public void equal() {
        Double a = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

        try {
            a = (double) engine.eval(equations);
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        if (a != null) {
            t_answer.setText(String.valueOf(a.doubleValue()));
        }
    }



    public void ac() {
        t_equation.setText("");
        equations = "";
        t_answer.setText("");
    }

    public void division() {
        equation("/");
    }
    public void multiplication() {
        equation("*");
    }
    public void addition() {
        equation("+");
    }
    public void subtraction() {
        equation("-");
    }
    public void decimal() {
        equation(".");
    }
    public void zero() {
        equation("0");
    }
    public void one() {
        equation("1");
    }
    public void two() {
        equation("2");
    }
    public void three() {
        equation("3");
    }
    public void four() {
        equation("4");
    }
    public void five() {
        equation("5");
    }
    public void six() {
        equation("6");
    }
    public void seven() {
        equation("7");
    }
    public void eight() {
        equation("8");
    }
    public void nine() {
        equation("9");
    }

}