package com.bobby.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SelectScreen extends AppCompatActivity {

    private Button normalButton;
    private Button hardButton;
    private TextView finishedMessage;

    private QuizBlock q1 = new QuizBlock("Who won Super Bowl 50?", "Denver Broncos");
    private QuizBlock q2 = new QuizBlock("Who won the last Super Bowl?", "New England Patriots");
    private QuizBlock q3 = new QuizBlock("How many teams are in the NFL?", "32");
    private QuizBlock q4 = new QuizBlock("How many players are on an NFL roster?", "53");
    private QuizBlock q5 = new QuizBlock("Who was the #1 overall pick in the 2017 NFL Draft?",
            "Myles Garrett");

    private ArrayList<QuizBlock> hardList = new ArrayList<QuizBlock>(){{
        add(q1);
        add(q2);
    }};

    private ArrayList<QuizBlock> normalList = new ArrayList<QuizBlock>(){{
        add(q3);
        add(q4);
        add(q5);

    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_screen);

        this.normalButton = (Button) findViewById(R.id.normal);
        this.hardButton = (Button) findViewById(R.id.hard);
        this.finishedMessage = (TextView) findViewById(R.id.finishedMessage);

        if (DefaultList.isHardBool()){
            this.hardButton.setVisibility(View.GONE);
        }

        if (DefaultList.isNorBool()){
            this.normalButton.setVisibility(View.GONE);
        }

        if (DefaultList.isFinished()){
            this.finishedMessage.setVisibility(View.VISIBLE);
        }
    }

    public void selectHard(View view){
        DefaultList.setQuestionList(this.hardList);
        DefaultList.setProgressMax(this.hardList.size());
        DefaultList.setDifficulty("hard");
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void selectNormal(View view){
        DefaultList.setQuestionList(this.normalList);
        DefaultList.setProgressMax(this.normalList.size());
        DefaultList.setDifficulty("normal");
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
