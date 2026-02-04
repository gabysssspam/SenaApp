package com.example.sena;

import java.util.List;

public class Question {

    private String prompt;
    private List<String> options;
    private int correctIndex;
    private String imageLabel;

    public Question(String prompt, List<String> options, int correctIndex, String imageLabel) {
        this.prompt = prompt;
        this.options = options;
        this.correctIndex = correctIndex;
        this.imageLabel = imageLabel;
    }

    public String getPrompt() {
        return prompt;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectIndex() {
        return correctIndex;
    }

    public String getImageLabel() {
        return imageLabel;
    }
}
