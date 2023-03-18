package com.myapp.spring_boot_test.model;

public class Student {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Student student = (Student) obj;
        return student.getName().equals(this.name);
    }
}
