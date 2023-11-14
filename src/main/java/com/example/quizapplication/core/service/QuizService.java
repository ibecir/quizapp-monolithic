package com.example.quizapplication.core.service;

import com.example.quizapplication.core.model.Question;
import com.example.quizapplication.core.model.Quiz;
import com.example.quizapplication.core.repository.QuestionRepository;
import com.example.quizapplication.core.repository.QuizRepository;
import com.example.quizapplication.rest.dto.QuestionResponse;
import com.example.quizapplication.rest.dto.QuizRequestDTO;
import com.example.quizapplication.rest.dto.QuizResult;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;

    public QuizService(QuizRepository quizRepository, QuestionRepository questionRepository) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
    }

    public Quiz createQuiz(QuizRequestDTO quizRequest) {
        List<Question> questionList = questionRepository.findTopByCategory(quizRequest.getCategory(), quizRequest.getNumOfQuestions());
        Quiz quiz = new Quiz();
        quiz.setTitle(quizRequest.getTitle());
        quiz.setQuestions(questionList);

        return quizRepository.save(quiz);
    }

    public Quiz getQuiz(String id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        if (quiz.isPresent())
            return quiz.get();
        return null;
    }

    public QuizResult submitQuizResults(String quizId, List<QuestionResponse> responses){
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        String message = "Some answers sent.";
        int score = 0;
        if(quiz.isPresent()){
            for (Question question : quiz.get().getQuestions()){
                for (QuestionResponse response : responses){
                    if(question.getId().equals(response.getQuestionId())){
                        if(question.getRightAnswer().equals(response.getResponse()))
                            score += 10;
                    }
                }
            }
            return new QuizResult(message, score);
        }
        return new QuizResult("You failed miserably", 0);
    }
}
