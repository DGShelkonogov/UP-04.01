package com.example.testcratorspring.answer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    public Iterable<Answer> getAllAnswer(){
        return answerRepository.findAll();
    }

    public Optional<Answer> getAnswer(String id){
        return answerRepository.findById(Long.parseLong(id));
    }
    public void addAnswer(Answer answer){
        answerRepository.save(answer);
    }

    public void addAnswer(String id, Answer answer){
        Answer answer1 = getAnswer(id).get();
        answer1.setGroupName(answer.getGroupName());
        answer1.setTitle(answer.getTitle());
        answer1.setIsTrue(answer.getIsTrue());
        answerRepository.save(answer1);
    }

    public void deleteAnswer(String id){
        answerRepository.deleteById(Long.parseLong(id));
    }
}
