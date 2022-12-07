package com.example.testcratorspring.group_test;

import com.example.testcratorspring.test.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class GroupTestController {
    @Autowired
    private GroupTestService groupTestService;

    @RequestMapping(value = "/groupTests")
    public Iterable<GroupTest> getAllPost(){return groupTestService.getAllGroupTest();}

    @RequestMapping(value = "/groupTests/{Id}")
    public Optional<GroupTest> getGroupTest(@PathVariable String Id){
        return groupTestService.getGroupTest(Id);
    }

    @RequestMapping(value = "/groupTests", method = RequestMethod.POST)
    public void addGroupTest(@RequestBody GroupTest groupTest){
        groupTestService.addGroupTest(groupTest);
    }


    @RequestMapping(value = "/groupTests/{Id}" , method = RequestMethod.PUT)
    public void updateGroupTest(@PathVariable ("Id") String id,
                           @RequestBody GroupTest groupTest){
        groupTestService.addGroupTest(id, groupTest);
    }

    @RequestMapping(value = "/groupTests/{Id}", method = RequestMethod.DELETE)
    public void deleteGroupTest(@PathVariable ("Id") String id){
        groupTestService.deleteGroupTest(id);
    }


    @RequestMapping(value = "/groupTests/findGroupTestByTest", method = RequestMethod.POST)
    public boolean findGroupTestByTest(@RequestBody Test test){
        return groupTestService.findGroupTestByTest(test);
    }
}
