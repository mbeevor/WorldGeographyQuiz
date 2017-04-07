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
        // Hides all cards, except question one //
        cardViewOne.setVisibility(View.VISIBLE);
        cardViewTwo.setVisibility(View.GONE);
        cardViewThree.setVisibility(View.GONE);

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
        boolean isQuestionOneAnswerA = QuestionOneAnswerA.isChecked();
        CheckBox QuestionOneAnswerB = (CheckBox) findViewById(R.id.question_one_answer_b);
        boolean isQuestionOneAnswerB = QuestionOneAnswerB.isChecked();
        CheckBox QuestionOneAnswerC = (CheckBox) findViewById(R.id.question_one_answer_c);
        boolean isQuestionOneAnswerC = QuestionOneAnswerC.isChecked();
        CheckBox QuestionOneAnswerD = (CheckBox) findViewById(R.id.question_one_answer_d);
        boolean isQuestionOneAnswerD = QuestionOneAnswerD.isChecked();
        int questionOneScore = calculateQuestionOneScore(isQuestionOneAnswerA, isQuestionOneAnswerB, isQuestionOneAnswerC, isQuestionOneAnswerD);
        cardViewOne.setVisibility(View.GONE);
        cardViewTwo.setVisibility(View.VISIBLE);
        score = score + questionOneScore;
        Toast.makeText(this, getString(R.string.score_message) + " " + score, Toast.LENGTH_SHORT).show();
    }

    /**
     * Updates the player's score from answer to question one
     *
     * @param QuestionOneAnswerA is if the player selected this option
     * @param QuestionOneAnswerB is if the player selected this option
     * @param QuestionOneAnswerC is if the player selected this option
     * @param QuestionOneAnswerD is if the player selected this option
     */
    private int calculateQuestionOneScore(boolean QuestionOneAnswerA, boolean QuestionOneAnswerB, boolean QuestionOneAnswerC, boolean QuestionOneAnswerD) {

        int questionOneScore = 0;

        // correct answer is A and B only//
        if ((QuestionOneAnswerA) && (QuestionOneAnswerB) && (!QuestionOneAnswerC) && (!QuestionOneAnswerD)) {
            questionOneScore += 10;
        }
        return questionOneScore;
    }

    /**
     * This method is called when the player clicks 'submit' on question Two.
     */
    public void questionTwoSubmit(View view) {
        RadioButton questionTwoAnswerC = (RadioButton) findViewById(R.id.question_two_answer_c);
        boolean isQuestionTwoAnswerC = questionTwoAnswerC.isChecked();
        int questionTwoScore = calculateQuestionTwoScore(isQuestionTwoAnswerC);
        cardViewTwo.setVisibility(View.GONE);
        cardViewThree.setVisibility(View.VISIBLE);
        score = score + questionTwoScore;
        Toast.makeText(this, getString(R.string.score_message) + " " + score, Toast.LENGTH_SHORT).show();
    }

    /**
     * Updates the player's score from answer to question two
     *
     * @param QuestionTwoAnswerC is the correct answer
     */
    private int calculateQuestionTwoScore(boolean QuestionTwoAnswerC) {

        int questionTwoScore = 0;

        if (QuestionTwoAnswerC) {
            questionTwoScore += 10;
        }
        return questionTwoScore;
    }

    /**
     * This method is called when the player clicks 'submit' on question Three.
     */
    public void questionThreeSubmit(View view) {

        EditText answerEditText = (EditText) findViewById(R.id.question_three_answer);

    }

    /**
     * Updates the player's score from answer to question three
     *
     */
    private int calculateQuestionThreeScore(){

        int questionThreeScore = 0;


        if (.equals(getString(R.string.question_three_answer))) {
            questionThreeScore += 10;
        }


    }

    //USE below for final card to display final score //
//
//    private String scoreSummary(int score) {
//        String summary = "your score is " + score;
//        return summary;
//    }
//
//    private void displayMessage(String message) {
//        TextView scoreTextView = (TextView) findViewById(R.id.current_score);
//        scoreTextView.setText(message);
//    }
//
//

}