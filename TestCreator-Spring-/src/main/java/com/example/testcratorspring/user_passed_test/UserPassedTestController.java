package com.example.testcratorspring.user_passed_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserPassedTestController {
    @Autowired
    private UserPassedTestService userPassedTestService;

    @RequestMapping(value = "/userPassedTests")
    public Iterable<UserPassedTest> getAllPost(){return userPassedTestService.getAllUserPassedTest();}

    @RequestMapping(value = "/userPassedTests/{Id}")
    public Optional<UserPassedTest> getUserPassedTest(@PathVariable String Id){
        return userPassedTestService.getUserPassedTest(Id);
    }

    @RequestMapping(value = "/userPassedTests", method = RequestMethod.POST)
    public void addUserPassedTest(@RequestBody UserPassedTest userPassedTest){
        userPassedTestService.addUserPassedTest(userPassedTest);
    }
    @RequestMapping(value = "/userPassedTests/{Id}" , method = RequestMethod.PUT)
    public void updateUserPassedTest(@PathVariable ("Id") String id,
                                     @RequestBody UserPassedTest userPassedTest){
        userPassedTestService.addUserPassedTest(id, userPassedTest);
    }

    @RequestMapping(value = "/userPassedTests/{Id}", method = RequestMethod.DELETE)
    public void deleteUserPassedTest(@PathVariable ("Id") String id){
        userPassedTestService.deleteUserPassedTest(id);
    }
}
