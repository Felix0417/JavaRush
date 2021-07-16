package com.javarush.task.task21.task2113;

public class Horse {
    String name;
    double speed;
    double distance;

    public Horse(String name, double speed, double distance){
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDistance() {
        return distance;
    }

    void move(){
        this.setDistance(getDistance() + (getSpeed() * Math.random()));
    }

    void print(){
        StringBuilder dotDistance = new StringBuilder("");
        for (int i = 0; i < Math.floor(getDistance()); i++) {
            dotDistance.append(".");
        }
        System.out.println(dotDistance + getName());
    }
}
