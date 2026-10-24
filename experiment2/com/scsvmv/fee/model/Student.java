package com.scsvmv.fee.model;

public class Student {
    private final String name;
    private final String course;

    public Student(String name, String course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }
}