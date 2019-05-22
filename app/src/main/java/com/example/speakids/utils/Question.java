package com.example.speakids.utils;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private String question;
    private List<String> answers = new ArrayList<>();
    private int correctAnswers;

    public Question(String question, int correctAnswers, String... answers){
        this.question = question;
        this.answers.add(answers[0]);
        this.answers.add(answers[1]);
        this.answers.add(answers[2]);
        this.answers.add(answers[3]);
        this.correctAnswers = correctAnswers;
    }

    public String getQuestion(){ return this.question; }
    public List<String> getAnswers(){ return this.answers; }
    public int getCorrectAnswers(){ return this.correctAnswers; }

}
