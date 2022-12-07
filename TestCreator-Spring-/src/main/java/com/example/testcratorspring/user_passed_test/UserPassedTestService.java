package com.example.testcratorspring.user_passed_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserPassedTestService {

    @Autowired
    private UserPassedTestRepository userPassedTestRepository;

    public Iterable<UserPassedTest> getAllUserPassedTest(){
        return userPassedTestRepository.findAll();
    }

    public Optional<UserPassedTest> getUserPassedTest(String id){
        return userPassedTestRepository.findById(Long.parseLong(id));
    }
    public void addUserPassedTest(UserPassedTest userPassedTest){
        userPassedTestRepository.save(userPassedTest);
    }

    public void addUserPassedTest(String id, UserPassedTest userPassedTest){
        UserPassedTest userPassedTest1 = getUserPassedTest(id).get();
        userPassedTest1.setPassedTest(userPassedTest.getPassedTest());
        userPassedTest1.setUser(userPassedTest.getUser());
        userPassedTestRepository.save(userPassedTest1);
    }

    public void deleteUserPassedTest(String id){
        userPassedTestRepository.deleteById(Long.parseLong(id));
    }
}
