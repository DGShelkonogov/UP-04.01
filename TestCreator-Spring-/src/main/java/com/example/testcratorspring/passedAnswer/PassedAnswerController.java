package com.example.testcratorspring.passedAnswer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class PassedAnswerController {
    @Autowired
    private PassedAnswerService passedAnswerService;

    @RequestMapping(value = "/passedAnswers")
    public Iterable<PassedAnswer> getAllPost(){return passedAnswerService.getAllPassedAnswer();}

    @RequestMapping(value = "/passedAnswers/{Id}")
    public Optional<PassedAnswer> getPassedAnswer(@PathVariable String Id){
        return passedAnswerService.getPassedAnswer(Id);
    }

    @RequestMapping(value = "/passedAnswers", method = RequestMethod.POST)
    public PassedAnswer addPassedAnswer(@RequestBody PassedAnswer passedAnswer){
        return passedAnswerService.addPassedAnswer(passedAnswer);
    }
    @RequestMapping(value = "/passedAnswers/{Id}" , method = RequestMethod.PUT)
    public void updatePassedAnswer(@PathVariable ("Id") String id,
                               @RequestBody PassedAnswer passedAnswer){
        passedAnswerService.addPassedAnswer(id, passedAnswer);
    }

    @RequestMapping(value = "/passedAnswers/{Id}", method = RequestMethod.DELETE)
    public void deletePassedAnswer(@PathVariable ("Id") String id){
        passedAnswerService.deletePassedAnswer(id);
    }
}
