package com.example.testcratorspring.user_group;


import com.example.testcratorspring.group.Group;
import com.example.testcratorspring.user.User;
import com.example.testcratorspring.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserGroupService {
    @Autowired
    private UserGroupRepository userGroupRepository;
    @Autowired
    private UserRepository userRepository;

    public Iterable<UserGroup> getAllUserGroup(){
        return userGroupRepository.findAll();
    }

    public Optional<UserGroup> getUserGroup(String id){
        return userGroupRepository.findById(Long.parseLong(id));

    }

    public String addUserGroup(UserGroup userGroup){
        User user = userRepository.findByLogin(userGroup.getUser().getLogin());
        userGroup.setUser(user);
        UserGroup u = userGroupRepository.findByGroupAndUser(userGroup.getGroup(),
                userGroup.getUser());
        if(u == null){
            userGroupRepository.save(userGroup);
            return "true";
        }
        return "false";

    }

    public Long getIdByUserAndGroup(UserGroup userGroup){
        UserGroup u = userGroupRepository.findByGroupAndUser(userGroup.getGroup(),
                userGroup.getUser());
        return u.getId_user_group();
    }

    public void updateUserGroup(String id, UserGroup userGroup){
        UserGroup userGroup1 = getUserGroup(id).get();
        userGroup1.setUser(userGroup.getUser());
        userGroup1.setGroup(userGroup.getGroup());
        userGroup1.setIs_admin(userGroup.getIs_admin());
        userGroupRepository.save(userGroup1);
    }

    public void deleteUserGroup(String id){
        userGroupRepository.deleteById(Long.parseLong(id));
    }
}
