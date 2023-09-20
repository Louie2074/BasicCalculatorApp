package com.cs407.basiccalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CalculatorPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView textView;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_page);
        textView = findViewById(R.id.answer);
        Intent intent = getIntent();
        String operation = intent.getStringExtra("op");
        double first = intent.getDoubleExtra("firstNum",0.0);
        double second = intent.getDoubleExtra("secNum",0.0);
        double answer;
        boolean divideByZero = false;
        switch (operation) {
            case "+":
                answer = first+second;
                break;

            case "-":
                answer = first-second;
                break;
            case "*":
                answer = first*second;
                break;
            case "/":
                if(second==0.0) divideByZero = true;
                answer = first/second;
                break;

            default:
                answer = 0.0;
        }
        String show = divideByZero ? "Cannot divide by 0": Double.toString(answer);
        textView.setText(show);
    }
}