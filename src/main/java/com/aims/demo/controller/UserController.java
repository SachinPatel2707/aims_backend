package com.aims.demo.controller;

import com.aims.demo.model.User;
import com.aims.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/registerUser")
    User registerUser (@RequestBody User newUser)
    {
        return userRepo.save(newUser);
    }

    @PostMapping("/checkUser")
    User checkUser (@RequestBody User checkUser)
    {
        return userRepo.findByUserName(checkUser.getUserName());
    }
}
