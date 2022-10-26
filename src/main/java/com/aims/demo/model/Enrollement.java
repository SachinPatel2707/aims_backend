package com.aims.demo.model;

import org.springframework.stereotype.Repository;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Repository
public class Enrollement {
    @Id
    @GeneratedValue
    Integer id;
    String sId;
    String courseCode;
    Integer semester;
    String grade;
    Integer percentage;

    public Enrollement() {}

    public Enrollement(Integer id, String sId, String courseCode, Integer semester, String grade, Integer percentage) {
        this.id = id;
        this.sId = sId;
        this.courseCode = courseCode;
        this.semester = semester;
        this.grade = grade;
        this.percentage = percentage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }
}
