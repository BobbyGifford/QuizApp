package com.bobby.quizapp;

/**
 * Created by bobby on 8/18/17.
 */

public class QuizBlock {
    private String question;
    private String answer;

    public QuizBlock(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return this.question;
    }
}
