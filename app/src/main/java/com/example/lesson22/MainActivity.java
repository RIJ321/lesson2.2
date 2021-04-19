package com.example.lesson22;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button sign_in;
    private EditText email, password;


    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.et_email);
        password = findViewById(R.id.pass);
        sign_in = findViewById(R.id.btn_signing);

        sign_in.setOnClickListener(v->{
           if (email.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
               Toast.makeText(this,"Fill the fields",Toast.LENGTH_SHORT).show();
           }else {
               sign_in.setBackground(getDrawable(R.drawable.after_field));
               Toast.makeText(this,"Welcome",Toast.LENGTH_SHORT).show();

           }

        });
    }
}