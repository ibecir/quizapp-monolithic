package com.example.quizapplication.rest.dto;

import com.example.quizapplication.core.model.enums.Category;

public class QuizRequestDTO {
    private String title;
    private Category category;
    private int numOfQuestions;

    public QuizRequestDTO(String title, Category category, int numOfQuestions) {
        this.title = title;
        this.category = category;
        this.numOfQuestions = numOfQuestions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getNumOfQuestions() {
        return numOfQuestions;
    }

    public void setNumOfQuestions(int numOfQuestions) {
        this.numOfQuestions = numOfQuestions;
    }
}
