package com.example.android.celebritymiddlenamequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup answers1;
    RadioGroup answers2;
    RadioGroup answers3;
    CheckBox answer4a;
    CheckBox answer4b;
    CheckBox answer4c;
    EditText answer5;
    int score = 0;
    int wrong_answers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answers1 = findViewById(R.id.answers1);
        answers2 = findViewById(R.id.answers2);
        answers3 = findViewById(R.id.answers3);
        answer4a = findViewById(R.id.a4);
        answer4b = findViewById(R.id.b4);
        answer4c = findViewById(R.id.c4);
        answer5 = findViewById(R.id.a5);

    }

    /**
     * method used to submit answers
     */
    public void submitAnswers(View view) {
        String question1 = getRadioGroupAnswer(answers1.getCheckedRadioButtonId());
        String question2 = getRadioGroupAnswer(answers2.getCheckedRadioButtonId());
        String question3 = getRadioGroupAnswer(answers3.getCheckedRadioButtonId());

        if (question1.equals(getString(R.string.a1))) {
            score += 1;
        } else {
            wrong_answers += 1;
        }

        if (question2.equals(getString(R.string.b2))) {
            score += 1;
        } else {
            wrong_answers += 1;
        }

        if (question3.equals(getString(R.string.b3))) {
            score += 1;
        } else {
            wrong_answers += 1;
        }
        if (answer4a.isChecked() && !answer4b.isChecked() && !answer4c.isChecked()) {
            score += 1;
        } else {
            wrong_answers += 1;
        }
        String answerQuestion5 = answer5.getText().toString();
        if (answerQuestion5.toLowerCase().equals("carroll")) {
            score += 1;
        } else {
            wrong_answers += 1;
        }

        showToast();

    }
    private String getRadioGroupAnswer(int id) {
        // Handle the case where the user did not make a choice
        if (id != -1) {
            RadioButton getSelectedRadioButton = findViewById(id);
            String answer = getSelectedRadioButton.getText().toString();
            return answer;
        } else {
            // the user did not choose an answer, return an empty string
            return "";
        }

    }

    /**
     * method for showing a toast message to the user at the end of the quiz
     */
    private void showToast() {
       String toastMessage = getString(R.string.end_message, String.valueOf(score), String.valueOf(wrong_answers));
       Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show();

        resetScore();
    }

    /**
     * method used to reset the scoring of the quiz
     */
    private void resetScore() {
        score = 0;
        wrong_answers = 0;
    }
}