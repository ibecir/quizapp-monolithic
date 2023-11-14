package com.example.quizapplication.core.service;

import com.example.quizapplication.core.model.Question;
import com.example.quizapplication.core.model.enums.Category;
import com.example.quizapplication.core.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public List<Question> getQuestionsByCategory(Category category){
        return questionRepository.findByCategory(category);
    }

    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }
}
