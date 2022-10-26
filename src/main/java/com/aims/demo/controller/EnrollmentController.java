package com.aims.demo.controller;

import com.aims.demo.repository.EnrollementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnrollmentController {
    @Autowired
    private EnrollementRepository enroll;


}
