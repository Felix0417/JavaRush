package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/

import java.math.BigDecimal;

public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        //напишите тут ваш код
        int x;
        String string = s.substring(0, 2);
        if (s.startsWith("0")) {
            switch (string) {
                case "0x":
                    x = Integer.parseInt(s.substring(2), 16);
                    break;
                case "0b":
                    x = Integer.parseInt(s.substring(2), 2);
                    break;
                default:
                    x = Integer.parseInt(s, 8);
            }
        } else {
            x = Integer.parseInt(s, 10);
        }

        return Integer.toString(x, 10);
    }
}
