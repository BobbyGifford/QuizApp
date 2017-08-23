package com.bobby.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private TextView quizProgress;
    private ProgressBar progressBar;
    private TextView prizeMessage;
    private Button toPrize;
    private TextView introMessage;
    private ArrayAdapter<QuizBlock> arrayAdapter;
    private int progressBarLength = DefaultList.getQuizProgress();
    private int currentProgress = DefaultList.getProgressCounter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listView = (ListView)findViewById(R.id.questionList);
        this.quizProgress = (TextView) findViewById(R.id.quizProgress);
        this.prizeMessage = (TextView) findViewById(R.id.prizeMessage);
        this.toPrize = (Button) findViewById(R.id.toPrize);
        this.introMessage = (TextView) findViewById(R.id.intro);

        this.progressBar = (ProgressBar) findViewById(R.id.progressBar);
        this.progressBar.setMax(this.progressBarLength);
        this.progressBar.setProgress(this.currentProgress);

        quizProgress.setText(DefaultList.getProgressCounter() +
                "/" + Integer.toString(DefaultList.getQuizProgress()));

        this.arrayAdapter = new ArrayAdapter<QuizBlock>(this, android.R.layout.simple_list_item_1,
                DefaultList.getQuestionList());

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                DefaultList.setIndex(i);
                Intent intent = new Intent(getApplicationContext(), QuestionDescription.class);
                startActivity(intent);
            }
        });

        if (this.currentProgress == this.progressBarLength){
            this.prizeMessage.setVisibility(View.VISIBLE);
            this.toPrize.setVisibility(View.VISIBLE);
            this.introMessage.setVisibility(View.GONE);
        }
    }
}
