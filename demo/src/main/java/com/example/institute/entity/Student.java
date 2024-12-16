package com.example.institute.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email address")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Phone number is required")
    private String phone;

    @PastOrPresent(message = "Enrollment date cannot be in the future")
    private LocalDate enrollmentDate;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false) // course_id cannot be null
    private Course course;

    // Constructors
    public Student() {
        // Default constructor
    }

    public Student(String name, String email, String phone, LocalDate enrollmentDate, Course course) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.enrollmentDate = enrollmentDate != null ? enrollmentDate : LocalDate.now(); // default to today if null
        this.course = course;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                ", course=" + course +
                '}';
    }
}
