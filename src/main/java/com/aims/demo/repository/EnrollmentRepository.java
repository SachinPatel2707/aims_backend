package com.aims.demo.repository;

import com.aims.demo.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {

    @Query("Select e from Enrollment e where e.sId= :sId")
    List<Enrollment> findAllByStudent(@Param("sId") String sId);

    @Query("Select e from Enrollment e where e.sId= :sId And e.semester= :sem")
    List<Enrollment> findAllByStudentSemester(@Param("sId") String sId, @Param("sem") Integer sem);

    @Transactional
    @Modifying
    @Query("Update Enrollment e set e.grade= :grade Where (e.sId= :sId And e.courseCode= :code)")
    void updateGrade(@Param("sId") String sId, @Param("code") String code, @Param("grade") Float grade);

    @Query("Select e from Enrollment e where e.sId= :sId And e.courseCode= :code And e.grade is not null")
    List<Enrollment> findByUserAndCode(@Param("sId") String sId, @Param("code") String code);

    @Transactional
    @Modifying
    @Query("delete from Enrollment e where e.sId= :sId and e.courseCode= :code")
    void deleteByCode(@Param("sId") String sId, @Param("code") String code);

    @Query("select e.sId from Enrollment e where e.courseCode= :code")
    List<String> findByCode(@Param("code") String code);

    @Query("select e.sId from Enrollment e where e.courseCode= :code And e.grade is null")
    List<String> findCurrentEnrollmentByCode(@Param("code") String code);
}
