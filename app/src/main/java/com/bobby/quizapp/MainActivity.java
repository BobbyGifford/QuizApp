package com.bobby.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.questionList);
        TextView quizProgress = (TextView) findViewById(R.id.quizProgress);
        quizProgress.setText("Progress: " + DefaultList.getProgressCounter() +
                "/" + Integer.toString(DefaultList.getQuizProgress()));

        ArrayAdapter<QuizBlock> arrayAdapter = new ArrayAdapter<QuizBlock>(this, android.R.layout.simple_list_item_1,
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
    }
}
