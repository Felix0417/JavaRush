package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) return false;

        Pattern pattern = Pattern.compile("^(\\+)?(\\d{2})?((\\()?\\d{3}(\\)?)(\\-?\\d){6,9})\\d$");
        Matcher matcher = pattern.matcher(telNumber);

        return matcher.find();
    }

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("+380501234567");
//        list.add("+38(050)1234567");
//        list.add("+38050123-45-67");
//        list.add("050123-4567");
//        list.add("+38)050(1234567");
//        list.add("+38(050)1-23-45-6-7");
//        list.add("050ххх4567");
//        list.add("050123456");
//        list.add("(0)501234567");
//
//        for (String num : list){
//            System.out.println(num + " - " +checkTelNumber(num));
//        }
    }
}
