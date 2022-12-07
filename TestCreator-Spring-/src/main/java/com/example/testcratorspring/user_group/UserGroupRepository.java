package com.example.testcratorspring.user_group;


import com.example.testcratorspring.group.Group;
import com.example.testcratorspring.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserGroupRepository extends CrudRepository<UserGroup, Long> {
    UserGroup findByGroupAndUser(Group group, User user);

    List<UserGroup> findByUser (User user);

    List<UserGroup> findByGroup (Group group);

   void deleteByGroupAndUser(User user, Group group);

}
