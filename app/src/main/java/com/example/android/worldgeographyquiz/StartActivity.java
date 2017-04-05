package com.example.android.worldgeographyquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {

    private String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        final EditText yourName = (EditText) findViewById(R.id.player_name);
        playerName = yourName.getText().toString();
    }

    public void startQuiz(View view) {

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
        savedInstanceState.putString("playerName", playerName);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        playerName = savedInstanceState.getString("playerName");
    }

}

