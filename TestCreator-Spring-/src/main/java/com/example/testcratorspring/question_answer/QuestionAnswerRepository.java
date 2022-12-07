package com.example.testcratorspring.question_answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionAnswerRepository extends CrudRepository<QuestionAnswer, Long> {

}
