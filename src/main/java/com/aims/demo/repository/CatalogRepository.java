package com.aims.demo.repository;

import com.aims.demo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CatalogRepository extends JpaRepository<Course, String> {
    @Query("Select c from Course c where c.code = :code")
    List<Course> findByCode(@Param("code") String code);

    @Transactional
    @Modifying
    @Query("Update Course c Set c.offeredBy = :user Where c.code = :code")
    void setOfferedBy(@Param("code") String code, @Param("user") String user);

    @Query("Select c from Course c where c.offeredBy is not null")
    List<Course> findCurSemCourses();
}
