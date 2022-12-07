package com.example.testcratorspring.test;

import com.example.testcratorspring.question.Question;
import com.example.testcratorspring.user.User;
import com.example.testcratorspring.group.Group;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Tests")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "Title")
    private String title;

    @ManyToMany(cascade = {CascadeType.ALL, CascadeType.MERGE})
    @JoinTable(name = "QuestionTest", joinColumns = @JoinColumn(name = "TestsId"),
            inverseJoinColumns = @JoinColumn(name = "QuestionsId"))
    private Set<Question> questions = new HashSet<>();

    @ManyToMany(mappedBy = "tests")
    private Set<User> users = new HashSet<>();

    @ManyToMany(mappedBy = "tests")
    private Set<Group> group = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   /* public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Group> getGroup() {
        return group;
    }

    public void setGroup(Set<Group> group) {
        this.group = group;
    }
*/
    public Test(String title) {
        this.title = title;
    }

    public Test() {
    }

    public void setIdTest(Long id_test) {
        this.id = id_test;
    }


    public Long getIdTest() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /* @Override
    public String toString() {
        return "Test{" +
                "id_test=" + id_test +
                ", title='" + title + '\'' +
                ", questions=" + questions +
                '}';
    }
*/
    /*

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }


    public void addQuestion(Question question){
        this.questions.add(question);
        question.getTests().add(this);
    }

    public void removeQuestion(Question question){
        this.questions.remove(question);
        question.getTests().remove(this);
    }
    public void addUser(User user){
        this.getUsers().add(user);
        user.getTests().add(this);
    }

    public void removeUser(User user){
        this.questions.remove(user);
        user.getTests().add(this);
    }
*/

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }


}
