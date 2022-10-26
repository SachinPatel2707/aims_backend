package com.aims.demo.repository;

import com.aims.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("Select u from User u where u.userName = :userName")
    User findByUserName(@Param("userName") String userName);

    @Transactional
    @Modifying
    @Query("Update User u set u.firstName= :firstname, u.lastName= :lastname, u.password= :password, u.Department= :department, u.cgpa= :cgpa, u.totalCreditsEarned= :credits, u.yearOfEnrollment= :year Where u.userName= :user")
    void updateUser(@Param("firstname") String firstname, @Param("lastname") String lastname, @Param("password") String password, @Param("department") String department, @Param("cgpa") Float cgpa, @Param("credits") Integer credits, @Param("year") String year, @Param("user") String user);
}
