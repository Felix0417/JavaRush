package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader readerFromFile = new BufferedReader(new FileReader(reader.readLine()));
        // /home/felix/Рабочий стол/test1.txt
        reader.close();
        String[] words;
        while (readerFromFile.ready()){
            words = readerFromFile.readLine().split("");
            for (int i = words.length - 1; i >= 0 ; i--) {
                System.out.print(words[i]);
                if (i == 0 && readerFromFile.ready()) System.out.println("");
            }
        }
        readerFromFile.close();

    }
}
