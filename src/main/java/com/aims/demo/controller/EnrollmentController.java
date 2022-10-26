package com.aims.demo.controller;

import com.aims.demo.model.Course;
import com.aims.demo.model.Enrollment;
import com.aims.demo.model.User;
import com.aims.demo.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnrollmentController {
    @Autowired
    private EnrollmentRepository enroll;

    @PostMapping("/enroll")
    void enroll (@RequestBody Enrollment en)
    {
        enroll.save(en);
    }

    @PostMapping("/unEnroll")
    void unEnroll(@RequestBody Enrollment en)
    {
        enroll.deleteByCode(en.getsId(), en.getCourseCode());
    }

    @PostMapping("/getAllEnrollmentByStudent")
    List<Enrollment> getAllEnrollmentByStudent(@RequestBody Enrollment en)
    {
        return enroll.findAllByStudent(en.getsId());
    }

    @PostMapping("/getEnrollment")
    List<Enrollment> getEnrollment(@RequestBody Enrollment en)
    {
        return enroll.findByUserAndCode(en.getsId(), en.getCourseCode());
    }

    @PostMapping("/getEnrollmentByStudentSemester")
    List<Enrollment> getEnrollmentByStudentSemester(@RequestBody Enrollment en)
    {
        return enroll.findAllByStudentSemester(en.getsId(), en.getSemester());
    }

    @PostMapping("/updateGrade")
    void updateGrade(@RequestBody List<Enrollment> arr)
    {
        for (Enrollment en : arr)
        {
            enroll.updateGrade(en.getsId(), en.getCourseCode(), en.getGrade());
        }
    }

    @PostMapping("/getEnrollmentByCourse")
    List<String> getEnrollmentByCourse(@RequestBody Course course)
    {
        return enroll.findByCode(course.getCode());
    }

    @PostMapping("/getCurrentEnrollmentByCourse")
    List<String> getCurrentEnrollmentByCourse(@RequestBody Course course)
    {
        return enroll.findCurrentEnrollmentByCode(course.getCode());
    }
}
