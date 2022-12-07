package com.example.testcratorspring.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByLogin(String login);
    User findByActivationCode(String name);
    void deleteByLogin(String login);
}
