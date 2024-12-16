package com.example.institute.repository;

import com.example.institute.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
    // Find students whose name contains a specific string (case-insensitive)
    List<Student> findByNameContainingIgnoreCase(String name);


    // Find students by the name of the course they are enrolled in
    @Query("SELECT s FROM Student s WHERE s.course.name = :courseName")
    List<Student> findByCourseName(@Param("courseName") String courseName);
}
