package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        int length = a[0].length;
        byte[] line = new byte[a[0].length + 1];
        byte[] lineAfter = new byte[a[0].length + 1];
        Arrays.fill(line, (byte) 0);
        Arrays.fill(lineAfter, (byte) 0);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                line[j] = a[i][j];
                if (i == a.length - 1) {
                    Arrays.fill(lineAfter, (byte) 0);
                } else {
                    lineAfter[j] = a[i+1][j];
                }
            }
//            System.out.println(Arrays.toString(line));
//            System.out.println(Arrays.toString(lineAfter));
            for (int k = 0; k < length; k++) {
                if (line[k] == 1) {
                    if (lineAfter[k] == 0 && line[k+1] == 0){
                        count++;
                    }
                }
            }
        }









        return count;
    }
}
