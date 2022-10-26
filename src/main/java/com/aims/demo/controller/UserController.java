package com.aims.demo.controller;

import com.aims.demo.model.User;
import com.aims.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/getAllUsers")
    List<User> getAllUsers()
    {
        return userRepo.findAll();
    }

    @PostMapping("/getUser")
    User getUser(@RequestBody User user)
    {
        return userRepo.findByUserName(user.getUserName());
    }

    @PostMapping("/updateUser")
    void updateUser(@RequestBody User user)
    {
        userRepo.updateUser(user.getFirstName(), user.getLastName(), user.getPassword(), user.getDepartment(), user.getCgpa(), user.getTotalCreditsEarned(), user.getYearOfEnrollment(), user.getUserName());
    }
}
