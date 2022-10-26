package com.aims.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Prerequisite {
    @Id
    @GeneratedValue
    Integer id;
    String courseCode;
    String prerequisiteCode;
    Float minCgpa;

    public Float getMinCgpa() {
        return minCgpa;
    }

    public void setMinCgpa(Float minCgpa) {
        this.minCgpa = minCgpa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getPrerequisiteCode() {
        return prerequisiteCode;
    }

    public void setPrerequisiteCode(String prerequisiteCode) {
        this.prerequisiteCode = prerequisiteCode;
    }
}
