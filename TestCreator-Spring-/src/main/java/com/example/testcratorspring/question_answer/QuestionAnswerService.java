package com.example.testcratorspring.question_answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionAnswerService {

    @Autowired
    private QuestionAnswerRepository questionAnswerRepository;

    public Iterable<QuestionAnswer> getAllQuestionAnswer(){
        return questionAnswerRepository.findAll();
    }

    public Optional<QuestionAnswer> getQuestionAnswer(String id){
        return questionAnswerRepository.findById(Long.parseLong(id));
    }
    public void addQuestionAnswer(QuestionAnswer questionAnswer){
        questionAnswerRepository.save(questionAnswer);
    }

    public void addQuestionAnswer(String id, QuestionAnswer questionAnswer){
        QuestionAnswer questionAnswer1 = getQuestionAnswer(id).get();
        questionAnswer1.setAnswer(questionAnswer.getAnswer());
        questionAnswer1.setQuestion(questionAnswer.getQuestion());
        questionAnswerRepository.save(questionAnswer1);
    }

    public void deleteQuestionAnswer(String id){
        questionAnswerRepository.deleteById(Long.parseLong(id));
    }
}
