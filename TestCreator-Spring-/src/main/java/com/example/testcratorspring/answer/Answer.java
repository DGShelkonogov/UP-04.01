package com.example.testcratorspring.answer;

import com.example.testcratorspring.question.Question;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "Title")
    private String title;
    @Column(name = "GroupName")
    private String groupName;
    @Column(name = "IsTrue")
    private Boolean isTrue;

    @ManyToMany(mappedBy = "answers")
    private Set<Question> questions = new HashSet<>();

    public Answer() {
    }

    public Answer(String title, String groupName, Boolean isTrue) {
        this.title = title;
        this.groupName = groupName;
        this.isTrue = isTrue;
    }

    public void setId_answer(Long id_answer) {
        this.id = id_answer;
    }

    public Long getId_answer() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String group_name) {
        this.groupName = group_name;
    }

    public Boolean getIsTrue() {
        return isTrue;
    }

    public void setIsTrue(Boolean is_true) {
        this.isTrue = is_true;
    }

   /*   @Override
    public String toString() {
        return "Answer{" +
                "id_answer=" + id_answer +
                ", title='" + title + '\'' +
                ", groupName='" + groupName + '\'' +
                ", isTrue=" + isTrue +
                '}';
    }*/
   /* public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public void addQuestion(Question question){
        this.questions.add(question);
        question.getAnswers().add(this);
    }

    public void removeQuestion(Question question){
        this.questions.remove(question);
        question.getAnswers().add(this);
    }*/

}
