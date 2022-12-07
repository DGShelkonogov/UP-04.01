package com.example.testcratorspring.passedAnswer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PassedAnswerService {
    @Autowired
    private PassedAnswerRepository passedAnswerRepository;

    public Iterable<PassedAnswer> getAllPassedAnswer(){
        return passedAnswerRepository.findAll();
    }

    public Optional<PassedAnswer> getPassedAnswer(String id){
        try{
            return passedAnswerRepository.findById(Long.parseLong(id));
        }catch (NumberFormatException e){

        }
        return null;
    }
    public PassedAnswer addPassedAnswer(PassedAnswer passedAnswer){
        return passedAnswerRepository.save(passedAnswer);
    }

    public void addPassedAnswer(String id, PassedAnswer passedAnswer){
        PassedAnswer passedAnswer1 = getPassedAnswer(id).get();
        passedAnswer1.setTitle(passedAnswer.getTitle());
        passedAnswer1.setQuestion(passedAnswer.getQuestion());
        passedAnswerRepository.save(passedAnswer1);
    }

    public void deletePassedAnswer(String id){
        passedAnswerRepository.deleteById(Long.parseLong(id));
    }
}
