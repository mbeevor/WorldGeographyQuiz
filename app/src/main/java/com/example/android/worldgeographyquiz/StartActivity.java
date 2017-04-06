package com.example.android.worldgeographyquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {

    private String playerName;
    EditText yourName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        yourName = (EditText) findViewById(R.id.player_name);
    }

    public void startQuiz(View view) {
        playerName = yourName.getText().toString();

        if (playerName.equals("")) {
            Toast.makeText(this, "You must enter your name", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent proceedToMain = new Intent(this, MainActivity.class);
        proceedToMain.putExtra("playerName", playerName);
        startActivity(proceedToMain);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("playerName", playerName);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        playerName = savedInstanceState.getString("playerName");
    }

}

