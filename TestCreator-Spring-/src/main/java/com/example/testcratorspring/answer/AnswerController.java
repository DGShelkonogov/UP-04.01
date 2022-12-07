package com.example.testcratorspring.answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @RequestMapping(value = "/answers")
    public Iterable<Answer> getAllPost(){return answerService.getAllAnswer();}

    @RequestMapping(value = "/answers/{Id}")
    public Optional<Answer> getAnswer(@PathVariable String Id){
        return answerService.getAnswer(Id);
    }

    @RequestMapping(value = "/answers", method = RequestMethod.POST)
    public void addAnswer(@RequestBody Answer answer){
        answerService.addAnswer(answer);
    }

    @RequestMapping(value = "/answers/{Id}" , method = RequestMethod.PUT)
    public void updateAnswer(@PathVariable ("Id") String id,
                           @RequestBody Answer answer){
        answerService.addAnswer(id, answer);
    }

    @RequestMapping(value = "/answers/{Id}", method = RequestMethod.DELETE)
    public void deleteAnswer(@PathVariable ("Id") String id){
        answerService.deleteAnswer(id);
    }
}
