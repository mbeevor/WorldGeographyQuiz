package com.example.android.worldgeographyquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerName = getIntent().getExtras().getString("playerName");
        TextView textView = (TextView) findViewById(R.id.start);
        String openingString = getString(R.string.hello) + " " + getString(R.string.entered_name, playerName) + " " + getString(R.string.begin);
        textView.setText(openingString);
    }

}