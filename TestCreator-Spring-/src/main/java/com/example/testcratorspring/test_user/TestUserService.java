package com.example.testcratorspring.test_user;

import com.example.testcratorspring.test.Test;
import com.example.testcratorspring.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TestUserService {
    @Autowired
    private TestUserRepository authorRepository;

    public Iterable<TestUser> getAllAuthor(){
        return authorRepository.findAll();
    }

    public Optional<TestUser> getAuthor(String id){
        return authorRepository.findById(Long.parseLong(id));
    }
    public void addAuthor(TestUser author){
        authorRepository.save(author);
    }

    public void addAuthor(String id, TestUser author){
        TestUser author1 = getAuthor(id).get();
        author1.setTest(author.getTest());
        author1.setUser(author.getUser());
        authorRepository.save(author1);
    }

    public List<Test> getAllAuthorByUser(User user){
        List<TestUser> authors = authorRepository.findByUser(user);
        List<Test> tests = new ArrayList<>();
        for(TestUser author : authors){
            tests.add(author.getTest());
        }
        return tests;
    }

    public void deleteAuthor(String id){
        authorRepository.deleteById(Long.parseLong(id));
    }
}
