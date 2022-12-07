package com.example.testcratorspring.user;

import com.example.testcratorspring.group.Group;
import com.example.testcratorspring.test.Test;
import com.example.testcratorspring.user_group.UserGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users")
    public Iterable<User> getAllPost(){
        return userService.getAllUser();
    }

    @RequestMapping(value = "/users/id/{Id}")
    public Optional<User> getUserbyId(@PathVariable String Id){
        return userService.getUserbyId(Id);
    }

    @RequestMapping(value = "/users/login/{Login}")
    public User getUserByLogin(@PathVariable String Login){
        return userService.getUserbyLogin(Login);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public boolean addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @RequestMapping(value = "/users/findAllGroups", method = RequestMethod.POST)
    public List<Group> getAllGroups(@RequestBody User user){
        return userService.getAllGroupForUser(user);
    }

    @RequestMapping(value = "/users/findAllUserByGroup", method = RequestMethod.POST)
    public List<User> getAllUserByGroup(@RequestBody Group group){
        return userService.getAllUserByGroup(group);
    }

    @RequestMapping(value = "/users/findAllUserGroups", method = RequestMethod.POST)
    public List<UserGroup> getAllUserGroups(@RequestBody User user){
        return userService.getAllUserGroupForUser(user);
    }

    @RequestMapping(value = "/users/{Id}" , method = RequestMethod.PUT)
    public User updateUser(@PathVariable ("Id") String id,
                              @RequestBody User user){
        return userService.addUser(id, user);
    }

    @RequestMapping(value = "/users/id/{Id}", method = RequestMethod.DELETE)
    public void deleteUserbyId(@PathVariable ("Id") String id){
        userService.deleteUserbyId(id);
    }

    @RequestMapping(value = "/users/login/{Login}", method = RequestMethod.DELETE)
    public void deleteUserbyLogin(@PathVariable ("Login") String login){
        userService.deleteUserbyLogin(login);
    }

    @RequestMapping(value = "/users/loginIsBusy/{Login}", method = RequestMethod.GET)
    public boolean loginIsBusy(@PathVariable ("Login") String login){
       return userService.loginIsBusy(login);
    }

    @RequestMapping(value = "/users/activation/{code}", method = RequestMethod.GET)
    public boolean activate(@PathVariable String code){
       return userService.activateUser(code);
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getIndex(){
        return "Это бэкенд, сайта тут нет." +
                " С разработчиком можно связаться по <a href='https://t.me/OreX_x'>телеграму</a>";
    }

    @RequestMapping(value = "/uninstallPage", method = RequestMethod.GET)
    public String getUninstallPage(){
        return "Спасибо что были с нами." +
                " С разработчиком можно связаться по <a href='https://t.me/OreX_x'>телеграму</a>";
    }
}
