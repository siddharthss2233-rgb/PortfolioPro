package com.hcl.PortfolioPro.controller;

import com.hcl.PortfolioPro.model.User;
import com.hcl.PortfolioPro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository repository;


    @GetMapping
    public List<User> getUsers() {
        return repository.findAll();
    }


    @GetMapping("/fetch/{id}")
    public User getUser(@PathVariable int id) {
        return repository.findById((long) id).get();
    }


    @PostMapping
    public User saveUser(@RequestBody User user) {
        return repository.save(user);
    }
}

