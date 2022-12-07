package com.example.testcratorspring.test_question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestQuestionService {
    @Autowired
    private TestQuestionRepository testQuestionRepository;

    public Iterable<TestQuestion> getAllTestQuestion(){
        return testQuestionRepository.findAll();
    }

    public Optional<TestQuestion> getTestQuestion(String id){
        return testQuestionRepository.findById(Long.parseLong(id));
    }
    public void addTestQuestion(TestQuestion testQuestion){
        testQuestionRepository.save(testQuestion);
    }

    public void addTestQuestion(String id, TestQuestion testQuestion){
        TestQuestion testQuestion1 = getTestQuestion(id).get();
        testQuestion1.setQuestion(testQuestion.getQuestion());
        testQuestion1.setTest(testQuestion.getTest());
        testQuestionRepository.save(testQuestion1);
    }

    public void deleteTestQuestion(String id){
        testQuestionRepository.deleteById(Long.parseLong(id));
    }
}
