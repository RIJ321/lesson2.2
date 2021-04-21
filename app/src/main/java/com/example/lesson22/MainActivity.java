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


        int[] numberIds = new int[]{
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

        int[] actionsIds = new int[]{
                R.id.plus,
                R.id.minus,
                R.id.umnojenie,
                R.id.delenie,
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

        findViewById(R.id.clear_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.reset();
                text.setText(calculator.getText());
            }
        });


    }

    /*<TableLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/tt_result"

        >

        <TableRow
            android:id="@+id/row_index_key1"
            android:layout_width="match_parent"
            android:layout_marginTop="10dp"

            >

            <Button
                android:id="@+id/clear"
                android:layout_marginHorizontal="5dp"
                android:layout_marginStart="10dp"
                android:width="80dp"
                android:height="90dp"
                android:background="@drawable/oval"
                android:text="AC"
                android:textSize="25sp"
                android:textColor="@color/white"
                android:backgroundTint="#FF5722"

                />

            <Button
                android:id="@+id/pozitive_or_negative"
                android:layout_marginHorizontal="5dp"
                android:width="80dp"
                android:height="90dp"
                android:background="@drawable/oval"
                android:text="+/-"
                android:textSize="30sp"

                />

            <Button
                android:id="@+id/percents"
                android:layout_marginHorizontal="5dp"
                android:width="80dp"
                android:height="90dp"
                android:background="@drawable/oval"
                android:text="%"
                android:textSize="30sp"

                />

            <Button
                android:id="@+id/delelenie"
                android:layout_marginHorizontal="5dp"
                android:width="80dp"
                android:height="90dp"
                android:background="@drawable/oval"
                android:text="/"
                android:textSize="30sp"

                />


        </TableRow>

        <TableRow android:layout_marginTop="10dp">

            <Button
                android:id="@+id/seven"
                android:layout_marginHorizontal="5dp"
                android:layout_marginStart="10dp"
                android:width="80dp"
                android:height="90dp"
                android:background="@drawable/oval"
                android:text="7"
                android:textSize="35sp"

                />

            <Button
                android:id="@+id/eight"
                android:layout_marginHorizontal="5dp"
                android:width="80dp"
                android:height="90dp"
                android:background="@drawable/oval"
                android:text="8"
                android:textSize="35sp"

                />

            <Button
                android:id="@+id/nine"
                android:layout_marginHorizontal="5dp"
                android:width="80dp"
                android:height="90dp"
                android:background="@drawable/oval"
                android:text="9"
                android:textSize="35sp"

                />

            <Button
                android:id="@+id/umnojenie"
                android:layout_marginHorizontal="5dp"
                android:width="80dp"
                android:height="90dp"
                android:background="@drawable/oval"
                android:text="*"
                android:textSize="35sp"

                />


        </TableRow>

        <TableRow android:layout_marginTop="10dp">

            <Button
                android:id="@+id/four"
                android:layout_marginHorizontal="5dp"
                android:layout_marginStart="10dp"
                android:width="80dp"
                android:height="90dp"
                android:background="@drawable/oval"
                android:text="4"
                android:textSize="35sp"

                />

            <Button
                android:id="@+id/five"
                android:layout_marginHorizontal="5dp"
                android:width="80dp"
                android:height="90dp"
                android:background="@drawable/oval"
                android:text="5"
                android:textSize="35sp"

                />

            <Button
                android:id="@+id/six"
                android:layout_marginHorizontal="5dp"
                android:width="80dp"
                android:height="90dp"
                android:background="@drawable/oval"
                android:text="6"
                android:textSize="35sp"

                />

            <Button
                android:id="@+id/minus"
                android:layout_marginHorizontal="5dp"
                android:width="80dp"
                android:height="90dp"
                android:background="@drawable/oval"
                android:text="-"
                android:textSize="45sp"

                />


        </TableRow>

        <TableRow android:layout_marginTop="10dp">

            <Button
                android:id="@+id/one"
                android:layout_marginHorizontal="5dp"
                android:layout_marginStart="10dp"
                android:width="80dp"
                android:height="90dp"
                android:background="@drawable/oval"
                android:text="1"
                android:textSize="35sp"

                />

            <Button
                android:id="@+id/two"
                android:layout_marginHorizontal="5dp"
                android:width="80dp"
                android:height="90dp"
                android:background="@drawable/oval"
                android:text="2"
                android:textSize="35sp"

                />

            <Button
                android:id="@+id/three"
                android:layout_marginHorizontal="5dp"
                android:width="80dp"
                android:height="90dp"
                android:background="@drawable/oval"
                android:text="3"
                android:textSize="35sp"

                />

            <Button
                android:id="@+id/plus"
                android:layout_marginHorizontal="5dp"
                android:width="80dp"
                android:height="90dp"
                android:background="@drawable/oval"
                android:text="+"
                android:textSize="35sp"

                />


        </TableRow>

        <TableRow android:layout_marginTop="10dp">

            <Button
                android:id="@+id/zero"
                android:layout_column="1"
                android:layout_marginHorizontal="5dp"
                android:width="80dp"
                android:height="90dp"
                android:background="@drawable/oval"
                android:text="0"

                android:textSize="35sp" />

            <Button
                android:id="@+id/floating"
                android:layout_marginHorizontal="5dp"
                android:width="80dp"
                android:height="90dp"
                android:background="@drawable/oval"
                android:text="."
                android:textSize="35sp"
                android:textColor="@color/white"
                android:backgroundTint="@color/light"


                />

            <Button
                android:id="@+id/resulting"
                android:layout_marginHorizontal="5dp"
                android:width="80dp"
                android:height="90dp"
                android:background="@drawable/oval"
                android:text="="
                android:textColor="@color/white"
                android:backgroundTint="#FF5722"

                android:textSize="35sp"

                />


        </TableRow>


    </TableLayout>

*/
}