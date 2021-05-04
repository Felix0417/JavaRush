package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        System.setOut(printStream);

        testString.printSomething();
        String result = outputStream.toString();

        System.setOut(consoleStream);

        String x = result.replaceAll("[^(\\+\\-\\*]", "");

        int[] num = new int[2];
        String[] s;
        String a = result.trim().replaceAll("[^(\\d)]", " ");
        a = a.trim();
        try{
            s = a.trim().split(" +");
            for (int i = 0; i < 2; i++) {
                num[i] = Integer.parseInt(s[i]);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        int res = 0;

        switch (x){
            case "+":
                res = num[0] + num[1];
                break;
            case "-":
                res = num[0] - num[1];
                break;
            case "*":
                res = num[0] * num[1];
                break;
        }

        System.out.print(result.replaceAll("\\n", "") + res);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

