package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonAdd, buttonSub, buttonMul, buttonDiv;
    EditText editTextN1, editTextN2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.btn_add);
        buttonSub = findViewById(R.id.btn_sub);
        buttonMul = findViewById(R.id.btn_mul);
        buttonDiv = findViewById(R.id.btn_div);
        editTextN1 = findViewById(R.id.number1);
        editTextN2 = findViewById(R.id.number2);
        textView = findViewById(R.id.answer);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });
    }

    private void calculate(char operator) {
        String num1Str = editTextN1.getText().toString();
        String num2Str = editTextN2.getText().toString();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            textView.setText("Please enter both numbers");
            return;
        }

        int num1 = Integer.parseInt(num1Str);
        int num2 = Integer.parseInt(num2Str);
        int result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    textView.setText("Cannot divide by zero");
                    return;
                }
                break;
        }

        textView.setText("Result: " + result);
    }
}
