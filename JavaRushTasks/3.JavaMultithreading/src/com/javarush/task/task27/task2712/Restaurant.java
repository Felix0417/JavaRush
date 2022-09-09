package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;

import java.io.IOException;

public class Restaurant {
    public static void main(String[] args) throws IOException {
        Tablet tablet = new Tablet(0);
        tablet.createOrder();
        tablet.createOrder();
        tablet.createOrder();
        tablet.createOrder();

        Cook cook = new Cook("Amigo");
        tablet.addObserver(cook);
    }
}
