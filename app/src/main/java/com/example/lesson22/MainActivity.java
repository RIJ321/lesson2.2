package com.example.lesson22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button sign_in;
    private TextView text;
    private EditText email, password;
    private Calculate calculator;

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.et_email);
        password = findViewById(R.id.pass);
        sign_in = findViewById(R.id.btn_signing);
        text = findViewById(R.id.tw_result);
        /*nine = findViewById(R.id.nine);
        eight = findViewById(R.id.eight);
        seven = findViewById(R.id.seven);
        six = findViewById(R.id.six);
        five = findViewById(R.id.five);
        four = findViewById(R.id.four);
        three = findViewById(R.id.three);
        two = findViewById(R.id.two);
        one = findViewById(R.id.one);
        minus = findViewById(R.id.minus);
        plus = findViewById(R.id.plus);
        delenie = findViewById(R.id.delelenie);
        umnojenie = findViewById(R.id.umnojenie);
        percents = findViewById(R.id.percents);
        clear_text = findViewById(R.id.clear);
        floating = findViewById(R.id.floating);

*/


        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!email.getText().toString().equals("") &&
                        !password.getText().toString().equals("")) {
                    sign_in.setBackground(getResources().getDrawable(R.drawable.after_field));
                } else {
                    sign_in.setEnabled(true);
                }
            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!email.getText().toString().equals("") &&
                        !password.getText().toString().equals("")) {
                    sign_in.setBackground(getResources().getDrawable(R.drawable.after_field));
                } else {
                    sign_in.setBackground(getResources().getDrawable(R.drawable.after_field));
                }
            }
        });


        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Fill the fields", Toast.LENGTH_SHORT).show();
                } else {
                    //sign_in.setBackground(getDrawable(R.drawable.after_field));
                    Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();

                }
            }

        });


        int[] numberIds = new int[] {
                R.id.zero,
                R.id.one,
                R.id.two,
                R.id.three,
                R.id.four,
                R.id.five,
                R.id.six,
                R.id.seven,
                R.id.eight,
                R.id.nine
        };

        int[] actionsIds = new int[] {
                R.id.plus,
                R.id.minus,
                R.id.umnojenie,
                R.id.delelenie,
                R.id.resulting
        };

        text = findViewById(R.id.tw_result);

        calculator = new Calculate();

        View.OnClickListener numberButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onNumPressed(view.getId());
                text.setText(calculator.getText());
            }
        };

        View.OnClickListener actionButtonOnclickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onActionPressed(view.getId());
                text.setText(calculator.getText());
            }
        };

        for (int i = 0; i < numberIds.length; i++) {
            findViewById(numberIds[i]).setOnClickListener(numberButtonClickListener);
        }

        for (int i = 0; i < actionsIds.length; i++) {
            findViewById(actionsIds[i]).setOnClickListener(actionButtonOnclickListener);
        }

        findViewById(R.id.clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.reset();
                text.setText(calculator.getText());
            }
        });


    }


}