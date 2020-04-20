package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;

import androidx.appcompat.app.AppCompatActivity;

public class Calc extends AppCompatActivity implements OnClickListener {
    EditText firstNumb, secondNumb;
    TextView sumbol, result;
    Button minus, add, mult, div;
    String oper = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        firstNumb = findViewById(R.id.firstNumber);
        secondNumb = findViewById(R.id.secondNumber);
        sumbol = findViewById(R.id.sumbol);
        result = findViewById(R.id.res);
        minus = findViewById(R.id.minus);
        add = findViewById(R.id.add);
        mult = findViewById(R.id.mult);
        div = findViewById(R.id.div);
        add.setOnClickListener(this);
        mult.setOnClickListener(this);
        minus.setOnClickListener(this);
        div.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.calc_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_back_to_main:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.go_to_web:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com"));
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public double calculate(int operatorId, double numberOne, double numberTwo) {
        double res = 0;
        switch (operatorId) {
            case R.id.div:
                if (numberTwo == 0) {
                    res = 0;

                    break;
                }

                res = numberOne / numberTwo;
                break;

            case R.id.add:
                res = numberOne + numberTwo;


                break;

            case R.id.minus:
                res = numberOne - numberTwo;
                break;

            case R.id.mult:
                res = numberOne * numberTwo;

                break;

        }
        return res;
    }

    public String operator(int operatorId, String oper) {
        switch (operatorId) {
            case R.id.div:
                oper = "/";
                break;
            case R.id.add:
                oper = "+";
                break;
            case R.id.minus:
                oper = "-";
                break;
            case R.id.mult:
                oper = "*";
                break;
        }
        return oper;
    }

    @Override
    public void onClick(View v) {
        if (TextUtils.isEmpty(firstNumb.getText().toString())
                || TextUtils.isEmpty(firstNumb.getText().toString())) {
            return;
        }
        double numberOne = Double.parseDouble(firstNumb.getText().toString());
        double numberTwo = Double.parseDouble(secondNumb.getText().toString());


        sumbol.setText(String.valueOf(operator(v.getId(), oper)));

        result.setText(String.valueOf(calculate(v.getId(), numberOne, numberTwo)));

    }

}


