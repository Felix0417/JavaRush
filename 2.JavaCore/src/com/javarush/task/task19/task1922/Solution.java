package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        BufferedReader reader1 = new BufferedReader(fileReader);


        // /home/felix/Рабочий стол/test1.txt

        int count = 0;
        String[] line;

        while (reader1.ready()) {
            count = 0;
            line = reader1.readLine().split("\\b");
            for (String s : line){
                if (words.contains(s))
                    count++;
            }
            if (count == 2){
                for (String a : line){
                    System.out.print(a);
                }
                System.out.println("");
            }
        }
        reader.close();
        reader1.close();
        fileReader.close();
    }
}
