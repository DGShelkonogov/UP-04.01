package com.example.testcratorspring.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public Iterable<Question> getAllQuestion(){
        return questionRepository.findAll();
    }

    public Optional<Question> getQuestion(String id){
      try{
          return questionRepository.findById(Long.parseLong(id));
      }catch (NumberFormatException e){

      }
       return null;
    }
    public Question addQuestion(Question question){
        return questionRepository.save(question);
    }

    public void addQuestion(String id, Question question){
        Question question1 = getQuestion(id).get();
        question1.setTitle(question.getTitle());
        question1.setMark(question.getMark());
        question1.setNumTrueAnswer(question.getNumTrueAnswer());
        question1.setIsCheckBox(question.getIsCheckBox());
        question1.setAnswers(question.getAnswers());
        questionRepository.save(question1);
    }

    public void deleteQuestion(String id){
        questionRepository.deleteById(Long.parseLong(id));
    }
}
