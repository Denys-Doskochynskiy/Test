package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView hello;
    SharedPreferences sharePref;
    final String SAVED_TEXT = "saved_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hello = findViewById(R.id.hello);
        getStringName();

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                saveAndGoToNextActivity();
                break;
            case R.id.refresh:
                loadText();
                break;
        }


    }

    void saveText() {
        sharePref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor edit = sharePref.edit();
        edit.putString(SAVED_TEXT, hello.getText().toString());
        edit.commit();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }

    public void loadText() {
        sharePref = getPreferences(MODE_PRIVATE);
        String savedText = sharePref.getString(SAVED_TEXT, "");
        hello.setText(savedText);
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();

    }

    public void saveAndGoToNextActivity() {
        Intent intent = new Intent(this, Calc.class);
        saveText();
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.go_to_web:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com"));
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void getStringName() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");


        if (name == null) {
            hello.setText("Hello ");
        } else
           hello.setText(("Hello " + name));

    }

}
