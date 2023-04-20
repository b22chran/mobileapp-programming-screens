package com.example.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity {
    TextView textOutput;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textOutput = findViewById(R.id.textView);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("name");
            // Do something with the name and number
        }
        textOutput.setText(name);
    }
}