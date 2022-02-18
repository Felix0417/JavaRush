package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString(){
        String readFromConsole;
        while (true){
            try{
                readFromConsole = reader.readLine();
                break;
            }catch (IOException e){
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
        return readFromConsole;

    }

    public static int readInt(){
        int readIntFromReadString;
        while (true){
            try {
                readIntFromReadString = Integer.parseInt(readString());
                break;
            }catch (NumberFormatException e){
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
        return readIntFromReadString;
    }

}
