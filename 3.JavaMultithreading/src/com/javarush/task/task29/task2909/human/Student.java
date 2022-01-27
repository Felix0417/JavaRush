package com.javarush.task.task29.task2909.human;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends UniversityPerson {
    private double averageGrade;
    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.averageGrade = averageGrade;
    }


    @Override
    public String getPosition() {
        return "Студент";
    }


    public void live() {
        learn();
    }

    public void learn() {
    }
    public int getCourse() {
        return course;
    }


    public void incAverageGrade(double delta){
        setAverageGrade(getAverageGrade() + delta);
    }

    public void setCourse(int value){
        this.course = value;
    }

    public void setAverageGrade(double value){
        this.averageGrade = value;
    }


    public void setBeginningOfSession(Date date) {
        beginningOfSession = date;
    }

    public void setEndOfSession(Date date) {
        endOfSession = date;
    }

    public double getAverageGrade() {
        return averageGrade;
    }
}