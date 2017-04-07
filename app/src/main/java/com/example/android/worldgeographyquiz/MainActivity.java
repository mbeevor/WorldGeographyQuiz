package com.example.android.worldgeographyquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    private String playerName;
    CardView cardViewOne;
    CardView cardViewTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // restores player's name from StartActivity //
        playerName = getIntent().getExtras().getString("playerName");
        // Identifies all cards when app created //
        cardViewOne = (CardView) findViewById(R.id.card_view_one);
        cardViewTwo = (CardView) findViewById(R.id.card_view_two);
        // Hides all cards, except question one //
        cardViewOne.setVisibility(View.VISIBLE);
        cardViewTwo.setVisibility(View.GONE);

        // creates new String welcome message that recalls player's name //
        TextView textView = (TextView) findViewById(R.id.start);
        String openingString = getString(R.string.hello) + ", " + getString(R.string.entered_name, playerName) + " " + getString(R.string.begin);
        textView.setText(openingString);
    }

    /**
     * This method is called when the player clicks 'submit' on question 1.
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
        int currentScore = calculateScore(isQuestionOneAnswerA, isQuestionOneAnswerB, isQuestionOneAnswerC, isQuestionOneAnswerD);
        cardViewOne.setVisibility(View.GONE);
        cardViewTwo.setVisibility(View.VISIBLE);
    }

    /**
     * Updates the player's score after question one
     *
     * @param QuestionOneAnswerA is if the player selected this option
     * @param QuestionOneAnswerB is if the player selected this option
     * @param QuestionOneAnswerC is if the player selected this option
     * @param QuestionOneAnswerD is if the player selected this option
     */
    private int calculateScore(boolean QuestionOneAnswerA, boolean QuestionOneAnswerB, boolean QuestionOneAnswerC, boolean QuestionOneAnswerD) {
        int QuestionOne = 0;

        // correct answer is A and B only//
        if ((QuestionOneAnswerA) && (QuestionOneAnswerB) && (!QuestionOneAnswerC) && (!QuestionOneAnswerD)) {
            QuestionOne = QuestionOne + 10;
            Toast.makeText(this, "Question 1 of 10 answered",Toast.LENGTH_SHORT).show();
        }
        return score + QuestionOne;
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