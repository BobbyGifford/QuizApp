package com.bobby.quizapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionDescription extends AppCompatActivity {
    EditText userAnswer;
    private String correctAnswer = DefaultList.getQuestionList().get(DefaultList.getIndex())
            .getAnswer().toLowerCase().trim();
    private TextView answerText;
    private final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_description);

        TextView questionText = (TextView) findViewById(R.id.questionText);
        this.answerText = (TextView) findViewById(R.id.answerText);
        this.userAnswer = (EditText) findViewById(R.id.userAnswer);
        this.answerText.setVisibility(View.INVISIBLE);

        questionText.setText(DefaultList.getQuestionList().get(DefaultList.getIndex()).getQuestion());
        answerText.setText("Correct! \n\nAnswer: " + this.correctAnswer);
    }

    public void onSubmitAnswer(View view){
        String checkAnswer = userAnswer.getText().toString().toLowerCase().trim();

        if (this.correctAnswer.equals(checkAnswer)) {
            Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_LONG).show();
            this.answerText.setVisibility(View.VISIBLE);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    DefaultList.questionAnswered();
                    DefaultList.progressCounterIncrement();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }, 5000);
        }

        else if (checkAnswer.equals("")){
            Toast.makeText(getApplicationContext(), "Please enter an answer", Toast.LENGTH_LONG).show();
        }

        else{
            Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_LONG).show();
        }
    }
}
