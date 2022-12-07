package com.example.testcratorspring.passedAnswer;

import com.example.testcratorspring.question.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassedAnswerRepository extends CrudRepository<PassedAnswer, Long> {
}
