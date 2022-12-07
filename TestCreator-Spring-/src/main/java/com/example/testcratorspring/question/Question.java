package com.example.testcratorspring.question;

import com.example.testcratorspring.answer.Answer;
import com.example.testcratorspring.test.Test;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "Title")
    private String title;
    @Column(name = "Mark")
    private Integer mark;
    @Column(name = "NumTrueAnswer")
    private Integer numTrueAnswer;
    @Column(name = "IsCheckBox")
    private Boolean isCheckBox;

    @ManyToMany(cascade = {CascadeType.ALL, CascadeType.MERGE})
    @JoinTable(name = "AnswerQuestion", joinColumns = @JoinColumn(name = "QuestionsId"),
        inverseJoinColumns = @JoinColumn(name = "AnswersId"))
    private Set<Answer> answers = new HashSet<>();

    @ManyToMany(mappedBy = "questions")
    private Set<Test> tests = new HashSet<>();



    public Question() {
    }


    public Question(String title, Integer mark, Integer numTrueAnswer, Boolean id_check_box) {
        this.title = title;
        this.mark = mark;
        this.numTrueAnswer = numTrueAnswer;
        this.isCheckBox = id_check_box;
    }


    public Boolean getCheckBox() {
        return isCheckBox;
    }

    public void setCheckBox(Boolean checkBox) {
        isCheckBox = checkBox;
    }

/*
    public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }
*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setId_question(Long id_question) {
        this.id = id_question;
    }

    public Long getId_question() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Integer getNumTrueAnswer() {
        return numTrueAnswer;
    }

    public void setNumTrueAnswer(Integer num_true_mark) {
        this.numTrueAnswer = num_true_mark;
    }

    public Boolean getIsCheckBox() {
        return isCheckBox;
    }

    public void setIsCheckBox(Boolean id_check_box) {
        this.isCheckBox = id_check_box;
    }

    /* @Override
    public String toString() {
        return "Question{" +
                "id_question=" + id_question +
                ", title='" + title + '\'' +
                ", mark=" + mark +
                ", numTrueAnswer=" + numTrueAnswer +
                ", isCheckBox=" + isCheckBox +
                ", answers=" + answers +
                '}';
    }*/
    /*        public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }


    public void addAnswer(Answer answer){
        this.answers.add(answer);
        answer.getQuestions().add(this);
    }

    public void removeAnswer(Answer answer){
        this.answers.remove(answer);
        answer.getQuestions().add(this);

    }
    public void addQuestion(Test test){
        this.tests.add(test);
        test.getQuestions().add(this);
    }

    public void removeQuestion(Test test){
        this.tests.remove(test);
        test.getQuestions().remove(this);

    }*/

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }
}
