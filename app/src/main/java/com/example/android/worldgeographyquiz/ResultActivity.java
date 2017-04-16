package com.example.android.worldgeographyquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }

    /**
     * This method is called when the player clicks 'play again'.
     * @param view
     */

    public void restart(View view) {
        Intent startAgain = new Intent(this, StartActivity.class);
        startActivity(startAgain);
    }

}
