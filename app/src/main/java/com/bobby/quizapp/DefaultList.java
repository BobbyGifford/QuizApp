package com.bobby.quizapp;

import java.util.ArrayList;

/**
 * Created by bobby on 8/18/17.
 */

abstract class DefaultList {
    private static int index;
    private static int progressCounter = 0;
    private static int progressMax;
    private static String difficulty;
    private static boolean norBool = false;
    private static boolean hardBool = false;
    private static boolean finished =false;

    private static ArrayList<QuizBlock> questionList = new ArrayList<QuizBlock>(){{
    }};

    static ArrayList<QuizBlock> getQuestionList() {
        return questionList;
    }

    public static void setQuestionList(ArrayList<QuizBlock> questionList) {
        DefaultList.questionList = questionList;
    }

    static int getIndex() {
        return index;
    }

    static void setIndex(int index) {
        DefaultList.index = index;
    }

    static void questionAnswered(){
        questionList.remove(index);
    }

    static int getProgressCounter() {
        return progressCounter;
    }

    public static void setProgressCounter(int progressCounter) {
        DefaultList.progressCounter = progressCounter;
    }

    static void progressCounterIncrement(){
        progressCounter++;
    }

    public static int getProgressMax() {
        return progressMax;
    }

    public static void setProgressMax(int progressMax) {
        DefaultList.progressMax = progressMax;
    }

    public static String getDifficulty() {
        return difficulty;
    }

    public static void setDifficulty(String difficulty) {
        DefaultList.difficulty = difficulty;
    }

    public static boolean isNorBool() {
        return norBool;
    }

    public static void setNorBool(boolean norBool) {
        DefaultList.norBool = norBool;
    }

    public static boolean isHardBool() {
        return hardBool;
    }

    public static void setHardBool(boolean hardBool) {
        DefaultList.hardBool = hardBool;
    }

    public static boolean isFinished() {
        return finished;
    }

    public static void setFinished(boolean finished) {
        DefaultList.finished = finished;
    }
}
