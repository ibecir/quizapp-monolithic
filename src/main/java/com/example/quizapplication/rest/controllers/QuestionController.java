package com.example.quizapplication.rest.controllers;

import com.example.quizapplication.core.model.Question;
import com.example.quizapplication.core.model.enums.Category;
import com.example.quizapplication.core.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return ResponseEntity.ok(questionService.getAllQuestions());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/filter/{categoryFilter}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable Category categoryFilter) {
        return ResponseEntity.ok(questionService.getQuestionsByCategory(categoryFilter));
    }

    @RequestMapping(method = RequestMethod.POST, path = "")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        return  new ResponseEntity(questionService.addQuestion(question), HttpStatus.CREATED);
    }
}
