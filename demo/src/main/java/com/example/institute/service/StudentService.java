package com.example.institute.service;

import com.example.institute.entity.Student;
import com.example.institute.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Save a new student
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    // Update an existing student
    public void updateStudent(Long id, Student updatedStudent) {
        Student existingStudent = studentRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Student with ID " + id + " not found."));

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setPhone(updatedStudent.getPhone());
        existingStudent.setEnrollmentDate(updatedStudent.getEnrollmentDate());
        existingStudent.setCourse(updatedStudent.getCourse());

        studentRepository.save(existingStudent);
    }

    // Get a student by ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Student with ID " + id + " not found."));
    }

    // Delete a student
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("Student with ID " + id + " does not exist.");
        }
        studentRepository.deleteById(id);
    }

    // Search students by name
    public List<Student> findStudentsByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }


    // Get students by course name
    public List<Student> getStudentsByCourseName(String courseName) {
        return studentRepository.findByCourseName(courseName);
    }
}
