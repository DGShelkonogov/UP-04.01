package com.example.testcratorspring.user_passed_test;

import com.example.testcratorspring.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPassedTestRepository extends CrudRepository<UserPassedTest, Long> {
}
