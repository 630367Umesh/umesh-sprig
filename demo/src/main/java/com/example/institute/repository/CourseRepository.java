package com.example.institute.repository;

import com.example.institute.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    // Find courses by instructor's name
    @Query("SELECT c FROM Course c WHERE c.instructor.name = :instructorName")
    List<Course> findByInstructorName(@Param("instructorName") String instructorName);

    // Find courses by duration
    List<Course> findByDuration(String duration);
}
