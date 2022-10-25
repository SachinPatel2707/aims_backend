package com.aims.demo.controller;

import com.aims.demo.model.Prerequisite;
import com.aims.demo.repository.PrerequisiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrerequisiteController {
    @Autowired
    private PrerequisiteRepository preReq;

    @PostMapping("/addPrerequisite")
    Prerequisite addPrerequisite(@RequestBody Prerequisite prereq)
    {
        return preReq.save(prereq);
    }
}
