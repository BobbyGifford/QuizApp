package com.bobby.quizapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionDescription extends AppCompatActivity {
    private EditText userAnswer;
    private TextView questionText;
    private String correctAnswer = DefaultList.getQuestionList().get(DefaultList.getIndex())
            .getAnswer().toLowerCase().trim();
    private TextView answerText;
    private Button submit;
    private final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_description);

        this.questionText = (TextView) findViewById(R.id.questionText);
        this.answerText = (TextView) findViewById(R.id.answerText);
        this.userAnswer = (EditText) findViewById(R.id.userAnswer);
        this.submit = (Button) findViewById(R.id.submitAnswer);
        this.answerText.setVisibility(View.INVISIBLE);

        questionText.setText(DefaultList.getQuestionList().get(DefaultList.getIndex()).getQuestion());
        answerText.setText("Correct! \n\nAnswer: " + this.correctAnswer);
    }

    public void onSubmitAnswer(View view){
        String checkAnswer = userAnswer.getText().toString().toLowerCase().trim();

        if (this.correctAnswer.equals(checkAnswer)) {
            Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
            this.answerText.setVisibility(View.VISIBLE);
            this.questionText.setText("Correct! \n\nAnswer: " + this.correctAnswer);
            this.submit.setVisibility(View.GONE);
            this.userAnswer.setVisibility(View.GONE);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    DefaultList.questionAnswered();
                    DefaultList.progressCounterIncrement();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }, 1000);
        }

        else if (checkAnswer.equals("")){
            Toast.makeText(getApplicationContext(), "Please enter an answer", Toast.LENGTH_LONG).show();
        }

        else{
            Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_LONG).show();
        }
    }
}
