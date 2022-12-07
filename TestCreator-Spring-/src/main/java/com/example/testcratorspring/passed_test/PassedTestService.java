package com.example.testcratorspring.passed_test;

import com.example.testcratorspring.passedAnswer.PassedAnswer;
import com.example.testcratorspring.passed_test_answer.PassedAnswerPassedTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class PassedTestService {
    @Autowired
    private PassedTestRepository passedTestRepository;

    @Autowired
    private PassedAnswerPassedTestRepository passedAnswerPassedTestRepository;

    public Iterable<PassedTest> getAllPassedTest(){
        return passedTestRepository.findAll();
    }

    public Optional<PassedTest> getPassedTest(String id){
        try{
            return passedTestRepository.findById(Long.parseLong(id));
        }catch (Exception e){
            System.out.println("YA BL TIT 1");
        }
        return null;

    }
    public void addPassedTest(PassedTest passedTest){
        Set<PassedAnswer> answers = passedTest.getPassedAnswers();
        for(PassedAnswer a : answers){
            System.out.println(a.getTitle());
        }
        passedTestRepository.save(passedTest);
    }

    public void addPassedTest(String id, PassedTest passedTest){
        PassedTest passedTest1 = getPassedTest(id).get();
        passedTest1.setTest(passedTest.getTest());
        passedTest1.setResult(passedTest.getResult());
        passedTest1.setPassedAnswers(passedTest.getPassedAnswers());
        passedTestRepository.save(passedTest1);
    }

    public void deletePassedTest(String id){
        passedTestRepository.deleteById(Long.parseLong(id));
    }
}
