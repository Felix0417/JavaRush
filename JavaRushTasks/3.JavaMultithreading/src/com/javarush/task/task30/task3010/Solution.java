package com.javarush.task.task30.task3010;

import java.math.BigInteger;

/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {

    public static void main(String[] args) {
        //напишите тут ваш код
        try {
            String s = args[0];
            int minRadix = 0;
            for (int i = 2; i < 37; i++) {
                try {
                    new BigInteger(s, i);
                    minRadix = i;
                    break;
                } catch (Exception ignored) {
                }
            }
            if (minRadix != 0) {
                System.out.println(minRadix);
            } else {
                System.out.println("incorrect");
            }
        } catch (Exception exception) {
        }
    }
}