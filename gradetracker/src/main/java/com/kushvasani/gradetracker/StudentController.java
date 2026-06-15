package com.kushvasani.gradetracker;

import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {
    
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student addStudent(@RequestParam String name) {
        return studentService.addStudent(name);
    }

    @PostMapping("/{id}/grades")
    public String addGrade(@PathVariable int id, @RequestParam double grade) {
        Student s = studentService.getStudentById(id);
        if (s != null) {
            studentService.addGrade(id, grade);
            return "Grade added successfully.";
        } else {
            return "Student not found.";
        }
    }

    @GetMapping("/{id}/average")
    public String getAverageGrade(@PathVariable int id) {
        Student s = studentService.getStudentById(id);
        if (s != null) {
            double average = s.getAverageGrade();
            return "Average grade for " + s.getName() + ": " + average;
        } else {
            return "Student not found.";
        }
    }
}
