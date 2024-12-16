package com.example.institute.controller;

import com.example.institute.entity.Student;
import com.example.institute.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Display all students
    @GetMapping
    public String listStudents(@RequestParam(value = "name", required = false) String name, Model model) {
        if (name != null && !name.isEmpty()) {
            model.addAttribute("students", studentService.findStudentsByName(name));
        } else {
            model.addAttribute("students", studentService.getAllStudents());
        }
        return "students/list";
    }

    // Show form to add a new student
    @GetMapping("/add")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "students/add";
    }

    // Save a new student
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    // Show form to update a student
    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            model.addAttribute("student", student);
            return "students/edit";
        }
        return "redirect:/students";
    }

    // Update a student
    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute Student updatedStudent) {
        studentService.updateStudent(id, updatedStudent);
        return "redirect:/students";
    }

    // Delete a student
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    // View student details
    @GetMapping("/{id}")
    public String viewStudentDetails(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            model.addAttribute("student", student);
            return "students/view";
        }
        return "redirect:/students";
    }
}
