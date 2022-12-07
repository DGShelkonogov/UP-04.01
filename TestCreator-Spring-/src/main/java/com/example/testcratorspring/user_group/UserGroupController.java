package com.example.testcratorspring.user_group;


import com.example.testcratorspring.group.Group;
import com.example.testcratorspring.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserGroupController {
    @Autowired
    private UserGroupService userGroupService;

    @RequestMapping(value = "/userGroups")
    public Iterable<UserGroup> getAllUserGroup(){return userGroupService.getAllUserGroup();}

    @RequestMapping(value = "/userGroups/{Id}")
    public Optional<UserGroup> getUserGroup(@PathVariable String Id){
        return userGroupService.getUserGroup(Id);
    }

    @RequestMapping(value = "/userGroups", method = RequestMethod.POST)
    public String addUserGroup(@RequestBody UserGroup userGroupGroup){
        return userGroupService.addUserGroup(userGroupGroup);
    }


    @RequestMapping(value = "/userGroups/getIdByUserAndGroup", method = RequestMethod.POST)
    public Long getIdByUserAndGroup(@RequestBody UserGroup userGroupGroup){
        return userGroupService.getIdByUserAndGroup(userGroupGroup);
    }


    @RequestMapping(value = "/userGroups/{Id}" , method = RequestMethod.PUT)
    public void updateUserGroup(@PathVariable ("Id") String id,
                           @RequestBody UserGroup userGroupGroup){
        userGroupService.updateUserGroup(id, userGroupGroup);
    }




    @RequestMapping(value = "/userGroups/{Id}", method = RequestMethod.DELETE)
    public void deleteUserGroup(@PathVariable ("Id") String id){
        userGroupService.deleteUserGroup(id);
    }
}
