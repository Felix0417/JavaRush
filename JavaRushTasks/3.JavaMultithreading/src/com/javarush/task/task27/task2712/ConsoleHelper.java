package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.javarush.task.task27.task2712.kitchen.Dish.allDishesToString;

public class ConsoleHelper {
    static BufferedReader reader = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));;

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString(){
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> orderList = new ArrayList<>();
        allDishesToString();
        String stroke;
        while (true) {
            stroke = readString();
            if (stroke.equals("exit")) {
                break;
            } else {
                String finalStroke = stroke;
                if (Arrays.stream(Dish.values()).anyMatch(x -> x.name().equals(finalStroke))) {
                    orderList.add(Dish.valueOf(stroke));
                } else {
                    System.out.println("Такого блюда нет, повторите ввод или введите exit для выхода");
                }
            }
        }
        return orderList;
    }
}
