package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Hello extends Activity implements OnClickListener {
    Button saveName;
    EditText name;
    TextView timeNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        saveName = (Button) findViewById(R.id.save);
        name = findViewById(R.id.name);
        timeNow = findViewById(R.id.timeNow);
        saveName.setOnClickListener(this);
        showTime();

    }

    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("name", name.getText().toString());
        startActivity(intent);
    }

    public void showTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(new Date(System.currentTimeMillis()));
        timeNow.setText(time);
    }
}
