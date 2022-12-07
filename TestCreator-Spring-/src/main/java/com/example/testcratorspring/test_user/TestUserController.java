package com.example.testcratorspring.test_user;

import com.example.testcratorspring.test.Test;
import com.example.testcratorspring.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TestUserController {
    @Autowired
    private TestUserService authorService;

    @RequestMapping(value = "/authors")
    public Iterable<TestUser> getAllPost(){return authorService.getAllAuthor();}

    @RequestMapping(value = "/authors/{Id}")
    public Optional<TestUser> getAuthor(@PathVariable String Id){
        return authorService.getAuthor(Id);
    }

    @RequestMapping(value = "/authors", method = RequestMethod.POST)
    public void addAuthor(@RequestBody TestUser author){
        authorService.addAuthor(author);
    }

    @RequestMapping(value = "/authors/getTests", method = RequestMethod.POST)
    public List<Test> getTestByUser(@RequestBody User user){
        return authorService.getAllAuthorByUser(user);
    }


    @RequestMapping(value = "/authors/{Id}" , method = RequestMethod.PUT)
    public void updateAuthor(@PathVariable ("Id") String id,
                            @RequestBody TestUser author){
        authorService.addAuthor(id, author);
    }

    @RequestMapping(value = "/authors/{Id}", method = RequestMethod.DELETE)
    public void deleteAuthor(@PathVariable ("Id") String id){
        authorService.deleteAuthor(id);
    }
}
