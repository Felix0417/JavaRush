package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University extends UniversityPerson {
    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }



    public University(String name, int age) {
        super(name, age);
    }

    public Student getStudentWithAverageGrade(double d) {
        //TODO:
        Student student = students.get(0);
        for(Student s : students){
            if (s.getAverageGrade() == d){
                student = s;
                break;
            }
        }
        return student;
    }


    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        //возможно что студентов не будет вовсе
        Student student = students.get(0);
        for(Student s : students){
            if (s.getAverageGrade() > student.getAverageGrade()){
                student = s;
            }
        }
        return student;
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        Student student = students.get(0);
        for(Student s : students){
            if (s.getAverageGrade() < student.getAverageGrade()){
                student = s;
            }
        }
        return student;
    }

    public void expel(Student student){
        students.remove(student);
    }




}