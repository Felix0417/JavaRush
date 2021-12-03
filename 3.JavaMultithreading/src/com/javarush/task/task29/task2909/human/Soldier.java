package com.javarush.task.task29.task2909.human;

public class Soldier extends Human{
    String name;
    int age;
    boolean isSoldier;

    public Soldier(String name, int age) {
        super(name, age);
        this.name = super.name;
        this.age = super.age;
    }
    public boolean isSoldier(){
        return isSoldier;
    }


    public void live() {
        fight();
    }

    public void fight() {
    }




}
