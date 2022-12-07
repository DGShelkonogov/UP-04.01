package com.example.testcratorspring.question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/questions")
    public Iterable<Question> getAllPost(){return questionService.getAllQuestion();}

    @RequestMapping(value = "/questions/{Id}")
    public Optional<Question> getQuestion(@PathVariable String Id){
        return questionService.getQuestion(Id);
    }

    @RequestMapping(value = "/questions", method = RequestMethod.POST)
    public Question addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
    @RequestMapping(value = "/questions/{Id}" , method = RequestMethod.PUT)
    public void updateQuestion(@PathVariable ("Id") String id,
                           @RequestBody Question question){
        questionService.addQuestion(id, question);
    }

    @RequestMapping(value = "/questions/{Id}", method = RequestMethod.DELETE)
    public void deleteQuestion(@PathVariable ("Id") String id){
        questionService.deleteQuestion(id);
    }
}
