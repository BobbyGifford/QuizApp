package com.bobby.quizapp;

import android.content.Intent;
import android.os.Handler;
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
    private TextView introMessage;
    private ArrayAdapter<QuizBlock> arrayAdapter;
    private int progressBarLength = DefaultList.getProgressMax();
    private int currentProgress = DefaultList.getProgressCounter();
    private final Handler handler = new Handler();


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listView = (ListView)findViewById(R.id.questionList);
        this.quizProgress = (TextView) findViewById(R.id.quizProgress);
        this.introMessage = (TextView) findViewById(R.id.intro);

        this.progressBar = (ProgressBar) findViewById(R.id.progressBar);
        this.progressBar.setMax(this.progressBarLength);
        this.progressBar.setProgress(this.currentProgress);

        quizProgress.setText(DefaultList.getProgressCounter() +
                "/" + Integer.toString(this.progressBarLength));

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
            DefaultList.setProgressCounter(0);
            this.introMessage.setText("Completed " + DefaultList.getDifficulty() + " difficulty!");

            if (DefaultList.getDifficulty().equals("normal")){
                DefaultList.setNorBool(true);
            }

            if (DefaultList.getDifficulty().equals("hard")){
                DefaultList.setHardBool(true);
            }

            if (DefaultList.isNorBool() && DefaultList.isHardBool()){
                DefaultList.setFinished(true);
            }

            this.handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(getApplicationContext(), SelectScreen.class);
                    startActivity(intent);
                }
            }, 3000);
        }
    }
}
