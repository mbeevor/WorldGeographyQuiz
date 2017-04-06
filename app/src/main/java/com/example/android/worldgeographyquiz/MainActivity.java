package com.example.android.worldgeographyquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    private String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerName = getIntent().getExtras().getString("playerName");
        TextView textView = (TextView) findViewById(R.id.start);
        String openingString = getString(R.string.hello) + ", " + getString(R.string.entered_name, playerName) + " " + getString(R.string.begin);
        textView.setText(openingString);
    }

    /**
     * This method is called when the player clicks 'submit' on question 1.
     */
    public void submit(View view) {
        CheckBox QuestionOneAnswerA = (CheckBox) findViewById(R.id.question_one_answer_a);
        boolean isQuestionOneAnswerA = QuestionOneAnswerA.isChecked();
        CheckBox QuestionOneAnswerB = (CheckBox) findViewById(R.id.question_one_answer_b);
        boolean isQuestionOneAnswerB = QuestionOneAnswerA.isChecked();
        CheckBox QuestionOneAnswerC = (CheckBox) findViewById(R.id.question_one_answer_c);
        boolean isQuestionOneAnswerC = QuestionOneAnswerA.isChecked();
        CheckBox QuestionOneAnswerD = (CheckBox) findViewById(R.id.question_one_answer_d);
        boolean isQuestionOneAnswerD = QuestionOneAnswerA.isChecked();
        int currentScore = calculateScore(isQuestionOneAnswerA, isQuestionOneAnswerB, isQuestionOneAnswerC, isQuestionOneAnswerD);
        String scoreMessage = scoreSummary(currentScore);

    }

    /**
     * Updates the player's score.
     *
     * @param QuestionOneAnswerA is if the player selected this option
     * @param QuestionOneAnswerB is if the player selected this option
     * @param QuestionOneAnswerC is if the player selected this option
     * @param QuestionOneAnswerD is if the player selected this option
     * @return total price
     */
    private int calculateScore(boolean QuestionOneAnswerA, boolean QuestionOneAnswerB, boolean QuestionOneAnswerC, boolean QuestionOneAnswerD) {

        if (QuestionOneAnswerA) {
            score = score + 10;
        }

        if (QuestionOneAnswerB) {
            score = score + 20;
        }

        if (QuestionOneAnswerC) {
            score = score + 30;
        }

        if (QuestionOneAnswerD) {
            score = score + 40;
        }
        return score;

    }

    private String scoreSummary(int score) {
        String summary = "your score is " + score;
        return summary;
    }

//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:"));
//        intent.putExtra(Intent.EXTRA_SUBJECT, R.string.summary);
//        intent.putExtra(Intent.EXTRA_TEXT, priceMessage );
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);

}