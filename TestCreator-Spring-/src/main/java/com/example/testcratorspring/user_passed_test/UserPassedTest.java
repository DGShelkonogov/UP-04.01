package com.example.testcratorspring.user_passed_test;

import com.example.testcratorspring.passed_test.PassedTest;
import com.example.testcratorspring.user.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.*;

@Entity
@Table(name = "PassedTestUser")
public class UserPassedTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "UsersId")
    private User user;

    @OneToOne
    @JoinColumn(name = "PassedTestsId")
    private PassedTest passedTest;

    public UserPassedTest(User user, PassedTest passedTest) {
        this.user = user;
        this.passedTest = passedTest;
    }

    public UserPassedTest() {
    }

    public void setId_user_passed_test(Long id_user_passed_test) {
        this.id = id_user_passed_test;
    }


    public Long getId_user_passed_test() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PassedTest getPassedTest() {
        return passedTest;
    }

    public void setPassedTest(PassedTest passedTest) {
        this.passedTest = passedTest;
    }
}
