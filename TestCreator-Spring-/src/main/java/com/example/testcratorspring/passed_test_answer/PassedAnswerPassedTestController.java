package com.example.testcratorspring.passed_test_answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PassedAnswerPassedTestController {
    @Autowired
    private PassedAnswerPassedTestService passedAnswerPassedTestService;

    @RequestMapping(value = "/passedTestAnswers")
    public Iterable<PassedAnswerPassedTest> getAllPost(){return passedAnswerPassedTestService.getAllPassedTestAnswer();}

    @RequestMapping(value = "/passedTestAnswers/{Id}")
    public Optional<PassedAnswerPassedTest> getPassedTestAnswer(@PathVariable String Id){
        return passedAnswerPassedTestService.getPassedTestAnswer(Id);
    }

    @RequestMapping(value = "/passedTestAnswers", method = RequestMethod.POST)
    public void addPassedTestAnswer(@RequestBody PassedAnswerPassedTest passedAnswerPassedTest){
        passedAnswerPassedTestService.addPassedTestAnswer(passedAnswerPassedTest);
    }
    @RequestMapping(value = "/passedTestAnswers/{Id}" , method = RequestMethod.PUT)
    public void updatePassedTestAnswer(@PathVariable ("Id") String id,
                           @RequestBody PassedAnswerPassedTest passedAnswerPassedTest){
        passedAnswerPassedTestService.addPassedTestAnswer(id, passedAnswerPassedTest);
    }

    @RequestMapping(value = "/passedTestAnswers/{Id}", method = RequestMethod.DELETE)
    public void deletePassedTestAnswer(@PathVariable ("Id") String id){
        passedAnswerPassedTestService.deletePassedTestAnswer(id);
    }
}
