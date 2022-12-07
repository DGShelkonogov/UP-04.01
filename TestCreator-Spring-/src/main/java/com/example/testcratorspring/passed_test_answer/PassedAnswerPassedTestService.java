package com.example.testcratorspring.passed_test_answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PassedAnswerPassedTestService {

    @Autowired
    private PassedAnswerPassedTestRepository passedAnswerPassedTestRepository;

    public Iterable<PassedAnswerPassedTest> getAllPassedTestAnswer(){
        return passedAnswerPassedTestRepository.findAll();
    }

    public Optional<PassedAnswerPassedTest> getPassedTestAnswer(String id){
        return passedAnswerPassedTestRepository.findById(Long.parseLong(id));
    }
    public void addPassedTestAnswer(PassedAnswerPassedTest passedAnswerPassedTest){
        passedAnswerPassedTestRepository.save(passedAnswerPassedTest);
    }

    public void addPassedTestAnswer(String id, PassedAnswerPassedTest passedAnswerPassedTest){
        PassedAnswerPassedTest passedAnswerPassedTest1 = getPassedTestAnswer(id).get();
        passedAnswerPassedTest1.setPassedAnswersId(passedAnswerPassedTest.getPassedAnswersId());
        passedAnswerPassedTest1.setPassedTest(passedAnswerPassedTest.getPassedTest());
        passedAnswerPassedTestRepository.save(passedAnswerPassedTest1);
    }

    public void deletePassedTestAnswer(String id){
        passedAnswerPassedTestRepository.deleteById(Long.parseLong(id));
    }
}
