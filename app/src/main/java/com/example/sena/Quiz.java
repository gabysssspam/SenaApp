package com.example.sena;

import java.util.List;

public class Quiz {

    private String id;
    private String title;
    private String level;
    private List<Question> questions;

    public Quiz(String id, String title, String level, List<Question> questions) {
        this.id = id;
        this.title = title;
        this.level = level;
        this.questions = questions;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLevel() {
        return level;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
