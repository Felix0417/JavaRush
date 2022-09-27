package com.javarush.task.task30.task3009;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number) {
        Set<Integer> result = new HashSet<>();
        try {
            String[] nums;
            for (int i = 2; i < 37; i++) {
                nums = Integer.toString(Integer.parseInt(number), i).split("");
                if (isPalindrome(nums)) {
                    result.add(i);
                }
            }
        } catch (NumberFormatException e) {
            return new HashSet<>();
        }
        return result;
    }

    public static boolean isPalindrome(String[] numbers) {
        for (int i = 0; i < numbers.length / 2; i++) {
            if (!(Objects.equals(numbers[i], numbers[numbers.length - 1 - i]))) {
                return false;
            }
        }
        return true;
    }
}