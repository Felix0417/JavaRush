package com.javarush.task.task21.task2106;

import java.util.Date;
import java.util.Objects;

/* 
Ошибка в equals/hashCode
*/

public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
//        System.out.println("Equals");
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;

        Solution solution1 = (Solution) o;

        boolean aints,strings, adoubles,dates,solutions;
        aints = Objects.equals(solution1.anInt, anInt);
        strings = Objects.equals(solution1.string, string);
        adoubles = Objects.equals(solution1.aDouble, aDouble);
        dates = Objects.equals(solution1.aDouble, aDouble);
        solutions = Objects.equals(solution1.solution, solution);
        return aints && strings && adoubles && dates && solutions;
    }

    @Override
    public int hashCode() {
//        System.out.println("Hash");
        int result;
        long temp;
        result = anInt;
        temp = aDouble != +0.0d ? Double.doubleToLongBits(aDouble) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (solution != null ? solution.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(1,"A", 2.0, new Date(), null);
        System.out.println(solution.equals(new Solution(1,"A", 2.0, new Date(), null)));
    }
}
