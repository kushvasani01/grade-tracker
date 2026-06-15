package com.kushvasani.gradetracker;

import java.util.List;
import java.util.ArrayList;

public class Student {
    private int id;
    private String name;
    private List<Double> grades;

    public Student(int id, String name) {
        this.name = name;
        this.id = id;
        grades = new ArrayList<>();
    }

    public int getId() { 
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void addGrade(double grade) {
        grades.add(grades.size(), grade);
    }

    public double getAverageGrade() {
        if(grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
}
