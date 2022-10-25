package com.aims.demo.repository;

import com.aims.demo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CatalogRepository extends JpaRepository<Course, String> {
    @Query("Select c from Course c where c.code = :code")
    List<Course> findByCode(@Param("code") String code);
}
