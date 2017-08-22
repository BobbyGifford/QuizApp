package com.bobby.quizapp;

import java.util.ArrayList;

/**
 * Created by bobby on 8/18/17.
 */

public abstract class DefaultList {
    private static int index;
    private static int progressCounter = 0;
    private static QuizBlock q1 = new QuizBlock("Question 1", "aa");
    private static QuizBlock q2 = new QuizBlock("Question 2", "aa");
    private static QuizBlock q3 = new QuizBlock("Question 3", "aa");
    private static QuizBlock q4 = new QuizBlock("Question 4", "aa");
    private static QuizBlock q5 = new QuizBlock("Question 5", "aa");
    private static QuizBlock q6 = new QuizBlock("Question 6", "aa");
    private static QuizBlock q7 = new QuizBlock("Question 7", "aa");
    private static QuizBlock q8 = new QuizBlock("Question 8", "aa");
    private static QuizBlock q9 = new QuizBlock("Question 9", "aa");
    private static QuizBlock q10 = new QuizBlock("Question 10", "aa");



    private static ArrayList<QuizBlock> questionList = new ArrayList(){{
        add(q1);
        add(q2);
        add(q3);
        add(q4);
        add(q5);
        add(q6);
        add(q7);
        add(q8);
        add(q9);
        add(q10);
    }};

    private static int quizProgress = questionList.size();

    public static ArrayList<QuizBlock> getQuestionList() {
        return questionList;
    }

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        DefaultList.index = index;
    }

    public static void questionAnswered(){
        questionList.remove(index);
    }

    public static int getQuizProgress() {
        return quizProgress;
    }

    public static void setQuizProgress(int quizProgress) {
        DefaultList.quizProgress = quizProgress;
    }

    public static int getProgressCounter() {
        return progressCounter;
    }

    public static void setProgressCounter(int progressCounter) {
        DefaultList.progressCounter = progressCounter;
    }

    public static void progressCounterIncrement(){
        progressCounter++;
    }
}
