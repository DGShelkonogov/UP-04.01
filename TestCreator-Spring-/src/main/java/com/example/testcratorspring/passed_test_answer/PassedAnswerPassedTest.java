package com.example.testcratorspring.passed_test_answer;

import com.example.testcratorspring.passedAnswer.PassedAnswer;
import com.example.testcratorspring.passed_test.PassedTest;

import javax.persistence.*;

@Entity
@Table(name = "PassedAnswerPassedTest")
public class PassedAnswerPassedTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @OneToOne
    PassedAnswer passedAnswersId;

    @OneToOne
    @JoinColumn(name = "PassedTestId")
    PassedTest passedTest;


    public PassedAnswerPassedTest(PassedAnswer passedAnswersId, PassedTest passedTest) {
        this.passedAnswersId = passedAnswersId;
        this.passedTest = passedTest;
    }

    public PassedAnswerPassedTest() {
    }

    public void setId_passed_test_answer(Long id_passed_test_answer) {
        this.id = id_passed_test_answer;
    }

    public Long getId_passed_test_answer() {
        return id;
    }

    public PassedAnswer getPassedAnswersId() {
        return passedAnswersId;
    }

    public void setPassedAnswersId(PassedAnswer passedAnswer) {
        this.passedAnswersId = passedAnswer;
    }

    public PassedTest getPassedTest() {
        return passedTest;
    }

    public void setPassedTest(PassedTest passedTest) {
        this.passedTest = passedTest;
    }
}
