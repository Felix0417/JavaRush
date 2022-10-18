package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(1234);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        List<String> bitsOfNumber = new ArrayList<>();

        int tempNum = number;
        while (tempNum != 0) {
            switch (tempNum % 3) {
                case 0:
                    bitsOfNumber.add("0");
                    break;
                case 1:
                    bitsOfNumber.add("+");
                    break;
                case 2:
                    bitsOfNumber.add("-");
                    tempNum++;
                    break;
            }
            tempNum /= 3;
        }

        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < bitsOfNumber.size(); i++) {
            switch (bitsOfNumber.get(i)) {
                case "+":
                    stringBuilder.append(" + ").append((int) Math.pow(3, i));
                    break;
                case "-":
                    stringBuilder.append(" - ").append((int) Math.pow(3, i));
            }
        }
//        System.out.println(bitsOfNumber);
        System.out.printf("%d =%s", number, stringBuilder);

    }
}