package com.javarush.task.task19.task1923;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);

        BufferedReader reader = new BufferedReader(fileReader);
        Pattern pattern = Pattern.compile("\\S*\\d\\S*");
        Matcher matcher;
        String words;

        while (reader.ready()){
            words = reader.readLine();
            matcher = pattern.matcher(words);
            while (matcher.find()){
//                System.out.print(words.substring(matcher.start(), matcher.end()) + " ");
                fileWriter.write(words.substring(matcher.start(), matcher.end()) + " ");
                fileWriter.flush();
            }
        }
        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}
