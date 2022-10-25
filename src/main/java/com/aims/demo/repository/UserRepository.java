package com.aims.demo.repository;

import com.aims.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("Select u from User u where u.userName = :userName")
    User findByUserName(@Param("userName") String userName);
}
