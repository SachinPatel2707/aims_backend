package com.aims.demo.repository;

import com.aims.demo.model.Enrollement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollementRepository extends JpaRepository<Enrollement, Integer> {
}
