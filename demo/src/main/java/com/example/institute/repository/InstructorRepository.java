package com.example.institute.repository;

import com.example.institute.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    // Find instructors by their name (case-insensitive and partial match)
    List<Instructor> findByNameContainingIgnoreCase(String name);

    // Find instructors by specialization
    List<Instructor> findBySpecialization(String specialization);

    // Count the number of instructors by specialization
    long countBySpecialization(String specialization);
}
