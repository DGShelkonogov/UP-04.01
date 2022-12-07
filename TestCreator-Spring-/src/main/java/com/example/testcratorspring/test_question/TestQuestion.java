package com.example.testcratorspring.test_question;

import com.example.testcratorspring.question.Question;
import com.example.testcratorspring.test.Test;

import javax.persistence.*;

@Entity
@Table(name = "QuestionTest")
public class TestQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;


    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TestsId")
    private Test test;


    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "QuestionsId")
    private Question question;



    public TestQuestion() {
    }

    public TestQuestion(Test test, Question question) {
        this.test = test;
        this.question = question;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setId_test_question(Long id_test_question) {
        this.id = id_test_question;
    }


    public Long getId_test_question() {
        return id;
    }

    public void setId_question_test(Long id_question_test) {
        this.id = id_question_test;
    }


    public Long getId_question_test() {
        return id;
    }


    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}

