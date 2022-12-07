package com.example.testcratorspring.question_answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class QuestionAnswerController {

    @Autowired
    private QuestionAnswerService questionAnswerService;

    @RequestMapping(value = "/questionAnswers")
    public Iterable<QuestionAnswer> getAllPost(){return questionAnswerService.getAllQuestionAnswer();}

    @RequestMapping(value = "/questionAnswers/{Id}")
    public Optional<QuestionAnswer> getQuestionAnswer(@PathVariable String Id){
        return questionAnswerService.getQuestionAnswer(Id);
    }

    @RequestMapping(value = "/questionAnswers", method = RequestMethod.POST)
    public void addQuestionAnswer(@RequestBody QuestionAnswer questionAnswer){
        questionAnswerService.addQuestionAnswer(questionAnswer);
    }
    @RequestMapping(value = "/questionAnswers/{Id}" , method = RequestMethod.PUT)
    public void updateQuestionAnswer(@PathVariable ("Id") String id,
                           @RequestBody QuestionAnswer questionAnswer){
        questionAnswerService.addQuestionAnswer(id, questionAnswer);
    }

    @RequestMapping(value = "/questionAnswers/{Id}", method = RequestMethod.DELETE)
    public void deleteQuestionAnswer(@PathVariable ("Id") String id){
        questionAnswerService.deleteQuestionAnswer(id);
    }
}
