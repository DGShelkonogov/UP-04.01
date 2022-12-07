package com.example.testcratorspring.test;
import com.example.testcratorspring.answer.Answer;
import com.example.testcratorspring.question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;

    public Iterable<Test> getAllTest(){
        return testRepository.findAll();
    }

    public Optional<Test> getTest(String id){
        return testRepository.findById(Long.parseLong(id));
    }


    public Test addTest(Test test){
        return testRepository.save(test);
    }

    public void updateTest(String id, Test test){
        Test test1 = getTest(id).get();
        test1.setTitle(test.getTitle());
        test1.setQuestions(test.getQuestions());
        testRepository.save(test1);
    }

    public void deleteTest(String id){
        testRepository.deleteById(Long.parseLong(id));
    }
}
