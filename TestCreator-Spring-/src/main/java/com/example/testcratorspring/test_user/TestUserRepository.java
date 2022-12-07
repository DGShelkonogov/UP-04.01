package com.example.testcratorspring.test_user;

import com.example.testcratorspring.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestUserRepository extends CrudRepository<TestUser, Long> {
    List<TestUser> findByUser(User user);
}
