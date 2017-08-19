package com.bobby.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class QuestionDescription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_description);

        TextView questionText = (TextView) findViewById(R.id.questionText);
        TextView answerText = (TextView) findViewById(R.id.answerText);

        questionText.setText(DefaultList.getQuestionList().get(DefaultList.getIndex()).getQuestion());
        answerText.setText(DefaultList.getQuestionList().get(DefaultList.getIndex()).getAnswer());
    }
}
