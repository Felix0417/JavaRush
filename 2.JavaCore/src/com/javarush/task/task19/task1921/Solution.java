package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader reader = new BufferedReader(fileReader);

        String[] strings;
        StringBuilder stringBuilder = new StringBuilder();
        List<String> integerList = new ArrayList<>();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d M yyyy", Locale.ENGLISH);
        Date date = null;

        while (reader.ready()) {
            strings = reader.readLine().split("\\s");
            for (int i = 0; i < strings.length; i++) {
                if (isDigit(strings[i])) {
                    integerList.add(strings[i]);
                } else {
                    stringBuilder.append(" " + strings[i]);
                }
            }
            try {
                date = simpleDateFormat.parse(integerList.get(0) + " " + integerList.get(1) + " " + integerList.get(2));
            } catch (Exception e) {
                System.out.println("неправильно парсится дата");
            }

            PEOPLE.add(new Person(stringBuilder.toString().trim(), date));

//            System.out.println(stringList);

            stringBuilder.delete(0, stringBuilder.length());
            integerList.clear();

            System.out.println(PEOPLE.get(0).getName());

        }
        fileReader.close();
        reader.close();
    }
        public static boolean isDigit(String a){
        try {
            Integer.parseInt(a);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
        }
    }
