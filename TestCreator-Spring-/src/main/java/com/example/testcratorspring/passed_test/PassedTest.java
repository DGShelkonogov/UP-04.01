package com.example.testcratorspring.passed_test;

import com.example.testcratorspring.passedAnswer.PassedAnswer;
import com.example.testcratorspring.passed_test_answer.PassedAnswerPassedTest;
import com.example.testcratorspring.test.Test;
import com.example.testcratorspring.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PassedTests")
public class PassedTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "TestId")
    private Test test;

    @Column(name = "Result")
    private Double result;

    @ManyToMany(cascade = {CascadeType.ALL, CascadeType.MERGE})
    @JoinTable(name = "PassedAnswerPassedTest", joinColumns = @JoinColumn(name = "passed_tests_id"),
            inverseJoinColumns = @JoinColumn(name = "passed_answers_id"))
    private Set<PassedAnswer> passedAnswers = new HashSet<>();



    @ManyToMany(mappedBy = "passedTests")
    private Set<User> users = new HashSet<>();

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
    }*/

    public PassedTest() {
    }

    public PassedTest(Test test, Double result, Set<PassedAnswerPassedTest> passedAnswerPassedTests) {
        this.test = test;
        this.result = result;
    }

    public void setId_passed_test(Long id_passed_test) {
        this.id = id_passed_test;
    }


    public Long getId_passed_test() {
        return id;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public Set<PassedAnswer> getPassedAnswers() {
        return passedAnswers;
    }

    public void setPassedAnswers(Set<PassedAnswer> passedAnswers) {
        this.passedAnswers = passedAnswers;
    }
}
