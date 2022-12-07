package com.example.testcratorspring;

import com.example.testcratorspring.answer.Answer;
import com.example.testcratorspring.question.Question;
import com.example.testcratorspring.question.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

@SpringBootTest
@DataJpaTest
@Commit
class TestCratorSpringApplicationTests {

    @Autowired
    QuestionRepository questionRepository;

    @Test
    @BeforeEach
    void contextLoads() {
        Answer answer = new Answer("title1", "answer1", true);
        Answer answer1 = new Answer("title2", "answer1", true);
        Answer answer2 = new Answer("title3", "answer1", true);
        Question question = new Question("tite1", 1,1,true);
        //question.addAnswer(answer);
        //question.addAnswer(answer1);
        //question.addAnswer(answer2);
        questionRepository.save(question);


    }

}
