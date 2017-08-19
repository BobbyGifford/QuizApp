package com.bobby.quizapp;

import java.util.ArrayList;

/**
 * Created by bobby on 8/18/17.
 */

public abstract class DefaultList {
    private static int index;
    private static QuizBlock q1 = new QuizBlock("What is my name", "Bobby");
    private static QuizBlock q2 = new QuizBlock("Type 2", "2");

    private static ArrayList<QuizBlock> questionList = new ArrayList(){{
        add(q1);
        add(q2);
    }};

    public static QuizBlock getQ1() {
        return q1;
    }

    public static QuizBlock getQ2() {
        return q2;
    }

    public static ArrayList<QuizBlock> getQuestionList() {
        return questionList;
    }

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        DefaultList.index = index;
    }
}
