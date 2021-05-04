package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();


        FileReader fileReader = new FileReader(filename);
        reader = new BufferedReader(fileReader);
        String line;
        int count = 0;
        String[] arr;

        try{
            while ((line = reader.readLine()) != null) {
                arr = line.replaceAll("\\p{Punct}\n", "").split("\\W+");
                //arr = line.split(" ");
                for (String s : arr) {
                    if (s.matches("\\bworld\\b")) {
                        count++;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(count);
        reader.close();
        fileReader.close();

    }
}
