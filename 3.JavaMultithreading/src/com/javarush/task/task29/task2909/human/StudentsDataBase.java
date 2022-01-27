package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class StudentsDataBase {
    public static List<Student> students = new ArrayList<>();

    public static void addInfoAboutStudent(Student student) {
        students.add(student);
        printInfoAboutStudent(student);

    }

    public static void printInfoAboutStudent(Student student) {
        System.out.println("Имя: " + student.getName() + " Возраст: " + student.getAge());
    }

    public static void removeStudent(int index) {
        if (index >= 0 && index < students.size()) {
            if (students.contains(students.get(index))) {
                students.remove(index);
            }
        }
    }

    public static void findDimaOrSasha() {
        String name = "";
        for (Student student : students) {
            if (student.getName().equals("Dima")) {
                name = "Dima";
                break;
            }
            if (student.getName().equals("Sasha")) {
                name = "Sasha";
                break;
            }
        }
        if (!name.equals("")) {
            System.out.println("Студент " + name + " есть в базе.");
        }
    }
    }