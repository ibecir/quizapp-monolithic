package com.example.quizapplication.core.repository;

import com.example.quizapplication.core.model.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends MongoRepository<Quiz, String> {

}
