package com.example.quizapplication.core.repository;


import com.example.quizapplication.core.model.Question;
import com.example.quizapplication.core.model.enums.Category;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends MongoRepository<Question, String> {
    public List<Question> findByCategory(Category category);

    @Aggregation(pipeline = {
            "{ $match: { category: { $eq: '?0' } } }",
            "{ $sample: { size: ?1 } }"
    })
    public List<Question> findTopByCategory(Category category, int limit);
}
