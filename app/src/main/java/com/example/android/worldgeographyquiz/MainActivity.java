package com.example.android.worldgeographyquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static int score = 0;
    private String playerName;
    CardView cardViewOne;
    CardView cardViewTwo;
    CardView cardViewThree;
    CardView cardViewFour;
    CardView cardViewFive;
    CardView cardViewSix;
    CardView cardViewSeven;
    CardView cardViewLast;

    /**
     * Start of quiz - starting with score of zero.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // restores player's name from StartActivity //
        playerName = getIntent().getExtras().getString("playerName");
        // Identifies all cards when app created //
        cardViewOne = (CardView) findViewById(R.id.card_view_one);
        cardViewTwo = (CardView) findViewById(R.id.card_view_two);
        cardViewThree = (CardView) findViewById(R.id.card_view_three);
        cardViewFour = (CardView) findViewById(R.id.card_view_four);
        cardViewFive = (CardView) findViewById(R.id.card_view_five);
        cardViewSix = (CardView) findViewById(R.id.card_view_six);
        cardViewSeven = (CardView) findViewById(R.id.card_view_seven);
        cardViewLast = (CardView) findViewById(R.id.card_view_last);
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
        TextView textView = (TextView) findViewById(R.id.start);
        String openingString = getString(R.string.hello) + ", " + getString(R.string.entered_name, playerName) + " " + getString(R.string.begin);
        textView.setText(openingString);

    }

    /**
     * This method is called when the player clicks 'submit' on question One.
     */
    public void questionOneSubmit(View view) {
        CheckBox QuestionOneAnswerA = (CheckBox) findViewById(R.id.question_one_answer_a);
        CheckBox QuestionOneAnswerB = (CheckBox) findViewById(R.id.question_one_answer_b);
        CheckBox QuestionOneAnswerC = (CheckBox) findViewById(R.id.question_one_answer_c);
        CheckBox QuestionOneAnswerD = (CheckBox) findViewById(R.id.question_one_answer_d);

        if ((QuestionOneAnswerA.isChecked()) && (!QuestionOneAnswerB.isChecked()) && (QuestionOneAnswerC.isChecked()) && (!QuestionOneAnswerD.isChecked())) {
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
        RadioButton questionTwoAnswerB = (RadioButton) findViewById(R.id.question_two_answer_b);
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

        EditText answerEditText = (EditText) findViewById(R.id.question_three_answer);
        if (answerEditText.getText().toString().equals(getString(R.string.question_three_answer))) {
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
        RadioButton questionFourAnswerA = (RadioButton) findViewById(R.id.question_four_answer_a);
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
        RadioButton questionFiveAnswerB = (RadioButton) findViewById(R.id.question_five_answer_b);
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
        CheckBox QuestionSixAnswerA = (CheckBox) findViewById(R.id.question_six_answer_a);
        CheckBox QuestionSixAnswerB = (CheckBox) findViewById(R.id.question_six_answer_b);
        CheckBox QuestionSixAnswerC = (CheckBox) findViewById(R.id.question_six_answer_c);
        CheckBox QuestionSixAnswerD = (CheckBox) findViewById(R.id.question_six_answer_d);
        CheckBox QuestionSixAnswerE = (CheckBox) findViewById(R.id.question_six_answer_e);
        CheckBox QuestionSixAnswerF = (CheckBox) findViewById(R.id.question_six_answer_f);
        CheckBox QuestionSixAnswerG = (CheckBox) findViewById(R.id.question_six_answer_g);
        CheckBox QuestionSixAnswerH = (CheckBox) findViewById(R.id.question_six_answer_h);

        if ((QuestionSixAnswerA.isChecked()) && (!QuestionSixAnswerB.isChecked()) && (QuestionSixAnswerC.isChecked()) && (!QuestionSixAnswerD.isChecked())
                && (!QuestionSixAnswerE.isChecked()) && (QuestionSixAnswerF.isChecked()) && (QuestionSixAnswerG.isChecked()) && (!QuestionSixAnswerH.isChecked())) {
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

        EditText answerEditText = (EditText) findViewById(R.id.question_seven_answer);
        if (answerEditText.getText().toString().equals(getString(R.string.question_seven_answer))) {
            score += 10;
        }
        cardViewSeven.setVisibility(View.GONE);
        cardViewLast.setVisibility(View.VISIBLE);
        // final String to display final score //
        TextView finalScore = (TextView) findViewById(R.id.result);
        String summary = getString(R.string.entered_name, playerName) + ", " + getString(R.string.final_score_message) + " " + score + " " + getString(R.string.possible);
        finalScore.setText(summary);

    }


}