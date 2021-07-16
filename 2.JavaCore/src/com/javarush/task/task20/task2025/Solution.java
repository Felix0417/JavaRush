package com.javarush.task.task20.task2025;

import java.util.*;

/* 
Алгоритмы-числа
*/

public class Solution {


    //Пока не решил...


    List<Long> armstrongNums = new ArrayList<>();

    static {
        long[][] numsOfPow = new long[10][19];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 19; j++) {
                numsOfPow[i][j] = (long) Math.pow(i, j + 1);
            }
        }
        setArmstrongNums(numsOfPow);
    }

    public static void setArmstrongNums(long[][] longs){
        int sum;
        int sumPlus;
        int sumMinus;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 19; j++) {

            }
        }
        }






























































































//        long half = Long.MAX_VALUE / 2;
//        long quarter = Long.MAX_VALUE / 4;
////        Map<Long, Long> firstQuarterOfN = new TreeMap<>();
////        Map<Long, Long> secondQuarterOfN = new TreeMap<>();
//        System.out.println(half);
//        System.out.println(quarter);
//
//        Set<Long> firstQuarterSet = new HashSet<>();
//        Set<Long> secondQuarterSet = new HashSet<>();
//        Set<Long> thirdQuarterSet = new HashSet<>();
//        Set<Long> fourthQuarterSet = new HashSet<>();
//        for (long i = 0; i < quarter; i++) {
//            firstQuarterSet.add(i);
//            secondQuarterSet.add(quarter + i);
//            thirdQuarterSet.add(half + i);
//            fourthQuarterSet.add(half + quarter + i);
//        }
//        System.out.println(fourthQuarterSet.size());

    public static long[] getNumbers(long n) {
        long l = 9_223_372_036_854_775_807L;



        return null;
    }
//        List<Long> armstrongNums = new ArrayList<>(88);
//        List<Long> tempLong = new ArrayList<>();
//        String[] fragmentsOfI;
//        for (long i = 1; i < n; i++) {
//            fragmentsOfI = i > 9 ? String.valueOf(i).split("\\B") : new String[] { String.valueOf(i)};
//            for (String s : fragmentsOfI){
//                tempLong.add(Long.parseLong(s));
//            }
//            // проверяем, соответствует ли число условию
//            // отправляем на проверку массив цифр с числа i, длину текущего числа и само число
//            if (isArmstrongNumber(tempLong, i)){
//                armstrongNums.add(i);
//            }
//            tempLong.clear();
//        }
//        long[] result = new long[armstrongNums.size()];
//        for (int i = 0; i < armstrongNums.size(); i++) {
//            result[i] = armstrongNums.get(i);
//        }
//        return result;
//    }
//
//    public static boolean isArmstrongNumber(List<Long> tempLong, long i){
//        long resultNum = 0;
//        long tempNum = 1;
//        for (long aLong : tempLong) {
//            for (int j = 0; j < tempLong.size(); j++) {
//                tempNum = tempNum * aLong;
//            }
//            resultNum += tempNum;
//            tempNum = 1;
//        }
//        return resultNum == i;
//    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
        System.out.println((Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())/1048576);
        System.out.println("----");

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
        System.out.println((Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())/1048576);

//        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
    }
}
