package com.kushvasani.gradetracker;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private List<Student> students = new ArrayList<>();
    private int nextId = 1;

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) { return student;
            }
        }
        return null; // or throw an exception
    }

    public Student addStudent(String name){
        Student newStudent = new Student(nextId++, name);
        students.add(newStudent);
        return newStudent;
    }

    public boolean addGrade(int studentId, double grade) {
        Student s = getStudentById(studentId);
        if (s != null) {
            s.addGrade(grade);
            return true;
        }
        return false;
    }

}
