package com.example.testcratorspring.question_answer;


import com.example.testcratorspring.answer.Answer;
import com.example.testcratorspring.question.Question;

import javax.persistence.*;

@Entity
@Table(name = "AnswerQuestion")
public class QuestionAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "QuestionsId")
    private Question question;

    @OneToOne
    @JoinColumn(name = "AnswersId")
    private Answer answer;


    public QuestionAnswer(Question question, Answer answer) {
        this.question = question;
        this.answer = answer;
    }

    public QuestionAnswer() {
    }

    public void setId_question_answer(Long id_question_answer) {
        this.id = id_question_answer;
    }


    public Long getId_question_answer() {
        return id ;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }


}
