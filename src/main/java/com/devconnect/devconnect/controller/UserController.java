package com.devconnect.devconnect.controller;

import com.devconnect.devconnect.model.User;
import com.devconnect.devconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Add a new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
