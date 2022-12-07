package com.example.testcratorspring.test_user;

import com.example.testcratorspring.test.Test;
import com.example.testcratorspring.user.User;

import javax.persistence.*;

@Entity
@Table(name = "TestUser")
public class TestUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "TestsId")
    private Test test;

    @OneToOne
    @JoinColumn(name = "UsersId")
    private User user;


    public TestUser() {
    }

    public TestUser(Test test, User user) {
        this.test = test;
        this.user = user;
    }

    public void setId_author(Long id_author) {
        this.id = id_author;
    }


    public Long getId_author() {
        return id;
    }



    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
