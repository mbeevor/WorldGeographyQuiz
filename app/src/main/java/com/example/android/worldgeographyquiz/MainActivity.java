package com.example.android.worldgeographyquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static int score = 0;
    private String playerName;

    // Identifies all cards when app created //
    CardView cardViewOne;
    CardView cardViewTwo;
    CardView cardViewThree;
    CardView cardViewFour;
    CardView cardViewFive;
    CardView cardViewSix;
    CardView cardViewSeven;
    CardView cardViewLast;

    // Find all views by ID //
    TextView startTextView;
    CheckBox questionOneAnswerA;
    CheckBox questionOneAnswerB;
    CheckBox questionOneAnswerC;
    CheckBox questionOneAnswerD;
    RadioButton questionTwoAnswerB;
    EditText questionThreeAnswerEditText;
    RadioButton questionFourAnswerA;
    RadioButton questionFiveAnswerB;
    CheckBox questionSixAnswerA;
    CheckBox questionSixAnswerB;
    CheckBox questionSixAnswerC;
    CheckBox questionSixAnswerD;
    CheckBox questionSixAnswerE;
    CheckBox questionSixAnswerF;
    CheckBox questionSixAnswerG;
    CheckBox questionSixAnswerH;
    EditText questionSevenAnswerEditText;
    TextView finalScore;
    ImageView scoreImage;

    /**
     * Start of quiz - starting with score of zero.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // restores player's name from StartActivity //
        playerName = getIntent().getExtras().getString("playerName");
        score = 0;

        // Identifies all cards when app created //
        cardViewOne = (CardView) findViewById(R.id.card_view_one);
        cardViewTwo = (CardView) findViewById(R.id.card_view_two);
        cardViewThree = (CardView) findViewById(R.id.card_view_three);
        cardViewFour = (CardView) findViewById(R.id.card_view_four);
        cardViewFive = (CardView) findViewById(R.id.card_view_five);
        cardViewSix = (CardView) findViewById(R.id.card_view_six);
        cardViewSeven = (CardView) findViewById(R.id.card_view_seven);
        cardViewLast = (CardView) findViewById(R.id.card_view_last);

        // Find all views by ID //
        startTextView = (TextView) findViewById(R.id.start);
        questionOneAnswerA = (CheckBox) findViewById(R.id.question_one_answer_a);
        questionOneAnswerB = (CheckBox) findViewById(R.id.question_one_answer_b);
        questionOneAnswerC = (CheckBox) findViewById(R.id.question_one_answer_c);
        questionOneAnswerD = (CheckBox) findViewById(R.id.question_one_answer_d);
        questionTwoAnswerB = (RadioButton) findViewById(R.id.question_two_answer_b);
        questionThreeAnswerEditText = (EditText) findViewById(R.id.question_three_answer);
        questionFourAnswerA = (RadioButton) findViewById(R.id.question_four_answer_a);
        questionFiveAnswerB = (RadioButton) findViewById(R.id.question_five_answer_b);
        questionSixAnswerA = (CheckBox) findViewById(R.id.question_six_answer_a);
        questionSixAnswerB = (CheckBox) findViewById(R.id.question_six_answer_b);
        questionSixAnswerC = (CheckBox) findViewById(R.id.question_six_answer_c);
        questionSixAnswerD = (CheckBox) findViewById(R.id.question_six_answer_d);
        questionSixAnswerE = (CheckBox) findViewById(R.id.question_six_answer_e);
        questionSixAnswerF = (CheckBox) findViewById(R.id.question_six_answer_f);
        questionSixAnswerG = (CheckBox) findViewById(R.id.question_six_answer_g);
        questionSixAnswerH = (CheckBox) findViewById(R.id.question_six_answer_h);
        questionSevenAnswerEditText = (EditText) findViewById(R.id.question_seven_answer);
        finalScore = (TextView) findViewById(R.id.result);
        scoreImage = (ImageView) findViewById(R.id.score_image);


        // Hides all cards, except question one //
        cardViewOne.setVisibility(View.VISIBLE);
        cardViewTwo.setVisibility(View.GONE);
        cardViewThree.setVisibility(View.GONE);
        cardViewFour.setVisibility(View.GONE);
        cardViewFive.setVisibility(View.GONE);
        cardViewSix.setVisibility(View.GONE);
        cardViewSeven.setVisibility(View.GONE);
        cardViewLast.setVisibility(View.GONE);


        // creates new String welcome message that recalls player's name //
        String openingString = getString(R.string.hello) + ", " + getString(R.string.entered_name, playerName) + " " + getString(R.string.begin);
        startTextView.setText(openingString);

    }

    /**
     * This method is called when the player clicks 'submit' on question One.
     */
    public void questionOneSubmit(View view) {

        if ((questionOneAnswerA.isChecked()) && (!questionOneAnswerB.isChecked()) && (questionOneAnswerC.isChecked()) && (!questionOneAnswerD.isChecked())) {
            score += 10;
        }
        Toast.makeText(this, getString(R.string.score_message) + " " + score, Toast.LENGTH_SHORT).show();
        cardViewOne.setVisibility(View.GONE);
        cardViewTwo.setVisibility(View.VISIBLE);
    }

    /**
     * This method is called when the player clicks 'submit' on question Two.
     */
    public void questionTwoSubmit(View view) {
        if (questionTwoAnswerB.isChecked()) {
            score += 10;
        }
        Toast.makeText(this, getString(R.string.score_message) + " " + score, Toast.LENGTH_SHORT).show();

        cardViewTwo.setVisibility(View.GONE);
        cardViewThree.setVisibility(View.VISIBLE);
    }

    /**
     * This method is called when the player clicks 'submit' on question Three.
     */
    public void questionThreeSubmit(View view) {

        if (questionThreeAnswerEditText.getText().toString().equals(getString(R.string.question_three_answer))) {
            score += 10;
        }
        Toast.makeText(this, getString(R.string.score_message) + " " + score, Toast.LENGTH_SHORT).show();
        cardViewThree.setVisibility(View.GONE);
        cardViewFour.setVisibility(View.VISIBLE);
    }

    /**
     * This method is called when the player clicks 'submit' on question Four.
     */
    public void questionFourSubmit(View view) {
        if (questionFourAnswerA.isChecked()) {
            score += 10;
        }
        Toast.makeText(this, getString(R.string.score_message) + " " + score, Toast.LENGTH_SHORT).show();

        cardViewFour.setVisibility(View.GONE);
        cardViewFive.setVisibility(View.VISIBLE);
    }

    /**
     * This method is called when the player clicks 'submit' on question Five.
     */
    public void questionFiveSubmit(View view) {
        if (questionFiveAnswerB.isChecked()) {
            score += 10;
        }
        Toast.makeText(this, getString(R.string.score_message) + " " + score, Toast.LENGTH_SHORT).show();

        cardViewFive.setVisibility(View.GONE);
        cardViewSix.setVisibility(View.VISIBLE);
    }

    /**
     * This method is called when the player clicks 'submit' on question Six.
     */
    public void questionSixSubmit(View view) {


        if ((questionSixAnswerA.isChecked()) && (!questionSixAnswerB.isChecked()) && (questionSixAnswerC.isChecked()) && (!questionSixAnswerD.isChecked())
                && (!questionSixAnswerE.isChecked()) && (questionSixAnswerF.isChecked()) && (questionSixAnswerG.isChecked()) && (!questionSixAnswerH.isChecked())) {
            score += 10;
        }
        Toast.makeText(this, getString(R.string.score_message) + " " + score, Toast.LENGTH_SHORT).show();
        cardViewSix.setVisibility(View.GONE);
        cardViewSeven.setVisibility(View.VISIBLE);
    }

    /**
     * This method is called when the player clicks 'submit' on question Seven.
     */
    public void questionSevenSubmit(View view) {

        if (questionSevenAnswerEditText.getText().toString().equals(getString(R.string.question_seven_answer))) {
            score += 10;
        }
        cardViewSeven.setVisibility(View.GONE);
        cardViewLast.setVisibility(View.VISIBLE);


        // final String to display final score //


        if (score <= 20) {
            String summary = getString(R.string.entered_name, playerName) + ", " + getString(R.string.final_score_message) + " " + score + " " + getString(R.string.possible) + "\n" + getString(R.string.worst);
            finalScore.setText(summary);
            scoreImage.setImageResource(R.drawable.lost);
        } else if (score <= 40) {
            String summary = getString(R.string.entered_name, playerName) + ", " + getString(R.string.final_score_message) + " " + score + " " + getString(R.string.possible) + "\n" + getString(R.string.okay);
            finalScore.setText(summary);
            scoreImage.setImageResource(R.drawable.middle);
        } else if (score <= 70) {
            String summary = getString(R.string.entered_name, playerName) + ", " + getString(R.string.final_score_message) + " " + score + " " + getString(R.string.possible) + "\n" + getString(R.string.best);
            finalScore.setText(summary);
            scoreImage.setImageResource(R.drawable.summit);
        }

    }

//    /**
//     * This method ensures the player's score is saved if the device is rotated.
//     */
//
//    @Override
//    protected void onSaveInstanceState(Bundle savedInstanceState) {
//        super.onSaveInstanceState(savedInstanceState);
//        savedInstanceState.putInt("Score", score);
//    }
//
//    /**
//     * This method ensures the player's score is restored from savedInstanceState if the device is rotated.
//     */
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        score = savedInstanceState.getInt("Score");
//    }


}