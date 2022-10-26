package com.aims.demo.repository;

import com.aims.demo.model.Prerequisite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PrerequisiteRepository extends JpaRepository<Prerequisite, Integer> {
    @Query("Select p from Prerequisite p where p.courseCode = :code")
    List<Prerequisite> findByCourse(@Param("code") String code);

    @Transactional
    @Modifying
    @Query("Update Prerequisite p set p.minCgpa= :minCgpa where p.id= :id")
    void setMinCgpa(@Param("id") Integer id, @Param("minCgpa") Float minCgpa );
}
