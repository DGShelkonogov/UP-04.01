package com.example.testcratorspring.user;

import com.example.testcratorspring.passed_test.PassedTest;
import com.example.testcratorspring.test.Test;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "First_name")
    private String first_name;
    @Column(name = "Surname")
    private String surname;
    @Column(name = "Last_name")
    private String last_name;
    @Column(name = "Login")
    private String login;
    @Column(name = "Password")
    private String password;
    @Column(name = "Email")
    private String email;
    @Column(name = "ActivationCode")
    private String activationCode;
    @Column(name = "Active")
    private boolean active;



    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "TestUser", joinColumns = @JoinColumn(name = "UsersId"),
            inverseJoinColumns = @JoinColumn(name = "TestsId"))
    private Set<Test> tests = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "PassedTestUser", joinColumns = @JoinColumn(name = "UsersId"),
            inverseJoinColumns = @JoinColumn(name = "PassedTestsId"))
    private Set<PassedTest> passedTests = new HashSet<>();


    public User() {
    }


    public User(String first_name, String surname,
                String last_name, String login,
                String password, String email, String
            activationCode, boolean active) {
        this.first_name = first_name;
        this.surname = surname;
        this.last_name = last_name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.activationCode = activationCode;
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setId_user(Long id_user) {
        this.id = id_user;
    }

    public Long getId_user() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String firstName) {
        this.first_name = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String lastName) {
        this.last_name = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String user_email) {
        this.email = user_email;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }




    public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }

    public Set<PassedTest> getPassedTests() {
        return passedTests;
    }

    public void setPassedTests(Set<PassedTest> passedTests) {
        this.passedTests = passedTests;
    }

    /* public void addTest(Test test){
        this.tests.add(test);
        test.getUsers().add(this);
    }

    public void removeTest(Test test){
        this.tests.remove(test);
        test.getUsers().remove(this);
    }*/
}
