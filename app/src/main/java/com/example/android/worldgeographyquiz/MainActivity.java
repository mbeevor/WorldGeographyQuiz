package com.example.android.worldgeographyquiz;

import android.content.Intent;
import android.net.Uri;
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

    int score = 0;
    int currentQuestion = 0;

    private String playerName;
    public static final String SAVED_SCORE = "savedScore";
    public static final String SAVED_PROGRESS = "currentQuestion";

    // Identifies all cards when app created //
    CardView cardViewOne;
    CardView cardViewTwo;
    CardView cardViewThree;
    CardView cardViewFour;
    CardView cardViewFive;
    CardView cardViewSix;
    CardView cardViewSeven;
    CardView cardViewLast;
    CardView cards[];

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

        if (savedInstanceState !=null) {
            score = savedInstanceState.getInt(SAVED_SCORE, score);
            currentQuestion = savedInstanceState.getInt(SAVED_PROGRESS, currentQuestion);
        }

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

        //create Array of all cards; cardViewOne = 0 and so on. All cards hidden apart from currentQuestion card //
        cards = new CardView[] {cardViewOne, cardViewTwo, cardViewThree, cardViewFour, cardViewFive, cardViewSix, cardViewSeven, cardViewLast};
        for (int i = 0; i < 8; i++) {
            if (currentQuestion != i) {
                cards[i].setVisibility(View.GONE);
            }
        } ;

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

        // creates new String welcome message that recalls player's name //
        String openingString = getString(R.string.hello) + ", " + getString(R.string.entered_name, playerName) + getString(R.string.begin);
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
        //update currentQuestion by 1 to hide current card and reveal next card
        currentQuestion += 1;
    }

    /**
     * This method is called when the player clicks 'submit' on question Two.
     */
    public void questionTwoSubmit(View view) {
        if (questionTwoAnswerB.isChecked()) {
            score += 10;
        }
        Toast.makeText(this, getString(R.string.score_message) + " " + score, Toast.LENGTH_SHORT).show();
        //update currentQuestion by 1 to hide current card and reveal next card
        currentQuestion += 1;
    }

    /**
     * This method is called when the player clicks 'submit' on question Three.
     */
    public void questionThreeSubmit(View view) {

        if (questionThreeAnswerEditText.getText().toString().equals(getString(R.string.question_three_answer))) {
            score += 10;
        }
        Toast.makeText(this, getString(R.string.score_message) + " " + score, Toast.LENGTH_SHORT).show();
        //update currentQuestion by 1 to hide current card and reveal next card
        currentQuestion += 1;
    }

    /**
     * This method is called when the player clicks 'submit' on question Four.
     */
    public void questionFourSubmit(View view) {
        if (questionFourAnswerA.isChecked()) {
            score += 10;
        }
        Toast.makeText(this, getString(R.string.score_message) + " " + score, Toast.LENGTH_SHORT).show();
        //update currentQuestion by 1 to hide current card and reveal next card
        currentQuestion += 1;
    }

    /**
     * This method is called when the player clicks 'submit' on question Five.
     */
    public void questionFiveSubmit(View view) {
        if (questionFiveAnswerB.isChecked()) {
            score += 10;
        }
        Toast.makeText(this, getString(R.string.score_message) + " " + score, Toast.LENGTH_SHORT).show();
        //update currentQuestion by 1 to hide current card and reveal next card
        currentQuestion += 1;
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
        //update currentQuestion by 1 to hide current card and reveal next card
        currentQuestion += 1;
    }

    /**
     * This method is called when the player clicks 'submit' on question Seven.
     */
    public void questionSevenSubmit(View view) {

        if (questionSevenAnswerEditText.getText().toString().equals(getString(R.string.question_seven_answer))) {
            score += 10;
        }
        //update currentQuestion by 1 to hide current card and reveal next card
        currentQuestion += 1;

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

    public void share(View view) {

        String shareResultMessage = getString(R.string.share_message) + " " + score + ". \n" + getString(R.string.thanks);

        Intent shareResult = new Intent(Intent.ACTION_SENDTO);
        shareResult.setData(Uri.parse("mailto:"));
        shareResult.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share_subject));
        shareResult.putExtra(Intent.EXTRA_TEXT, shareResultMessage);
        if (shareResult.resolveActivity(getPackageManager()) != null) {
            startActivity(shareResult);
        }
    }

    /**
     * This method is called when the player clicks 'view answers'
     *
     */

    public void viewResult(View view) {

        Intent viewAnswers = new Intent(this, ResultActivity.class);
        startActivity(viewAnswers);
    }

    /**
     * This method is called when the player clicks 'play again'.
     * @param view
     */

    public void restart(View view) {
        score = 0;
        Intent startAgain = new Intent(this, StartActivity.class);
        startActivity(startAgain);
    }


    /**
     * This method ensures the player's progress is saved if the device is rotated.
     */

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(SAVED_SCORE, score);
        savedInstanceState.putInt(SAVED_PROGRESS, currentQuestion);
        super.onSaveInstanceState(savedInstanceState);
    }

    /**
     * This method ensures the player's progress is restored from savedInstanceState if the device is rotated.
     */

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        savedInstanceState.getInt(SAVED_SCORE);
        savedInstanceState.getInt(SAVED_PROGRESS);
        super.onRestoreInstanceState(savedInstanceState);

    }

}
