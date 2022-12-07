package com.example.testcratorspring.test_question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TestQuestionController {
    @Autowired
    private TestQuestionService testQuestionService;

    @RequestMapping(value = "/testQuestions")
    public Iterable<TestQuestion> getAllPost(){return testQuestionService.getAllTestQuestion();}

    @RequestMapping(value = "/testQuestions/{Id}")
    public Optional<TestQuestion> getTestQuestion(@PathVariable String Id){
        return testQuestionService.getTestQuestion(Id);
    }

    @RequestMapping(value = "/testQuestions", method = RequestMethod.POST)
    public void addTestQuestion(@RequestBody TestQuestion testQuestion){
        testQuestionService.addTestQuestion(testQuestion);
    }
    @RequestMapping(value = "/testQuestions/{Id}" , method = RequestMethod.PUT)
    public void updateTestQuestion(@PathVariable ("Id") String id,
                           @RequestBody TestQuestion testQuestion){
        testQuestionService.addTestQuestion(id, testQuestion);
    }

    @RequestMapping(value = "/testQuestions/{Id}", method = RequestMethod.DELETE)
    public void deleteTestQuestion(@PathVariable ("Id") String id){
        testQuestionService.deleteTestQuestion(id);
    }
}
