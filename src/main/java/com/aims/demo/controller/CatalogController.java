package com.aims.demo.controller;

import com.aims.demo.model.Course;
import com.aims.demo.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CatalogController {
    @Autowired
    private CatalogRepository catalog;

    @PostMapping("/addCourse")
    Course addCourse (@RequestBody Course course)
    {
        return catalog.save(course);
    }

    @PostMapping("/getCourse")
    List<Course> getCourse(@RequestBody Course course)
    {
        return catalog.findByCode(course.getCode());
    }
}
