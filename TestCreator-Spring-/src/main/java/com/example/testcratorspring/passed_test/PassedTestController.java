package com.example.testcratorspring.passed_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class PassedTestController {
    @Autowired
    private PassedTestService passedTestService;

    @RequestMapping(value = "/passedTests")
    public Iterable<PassedTest> getAllPost(){return passedTestService.getAllPassedTest();}

    @RequestMapping(value = "/passedTests/{Id}")
    public Optional<PassedTest> getPassedTest(@PathVariable String Id){
        return passedTestService.getPassedTest(Id);
    }

    @RequestMapping(value = "/passedTests", method = RequestMethod.POST)
    public void addPassedTest(@RequestBody PassedTest passedTest){
        passedTestService.addPassedTest(passedTest);
    }
    @RequestMapping(value = "/passedTests/{Id}" , method = RequestMethod.PUT)
    public void updatePassedTest(@PathVariable ("Id") String id,
                           @RequestBody PassedTest passedTest){
        passedTestService.addPassedTest(id, passedTest);
    }

    @RequestMapping(value = "/passedTests/{Id}", method = RequestMethod.DELETE)
    public void deletePassedTest(@PathVariable ("Id") String id){
        passedTestService.deletePassedTest(id);
    }
}
