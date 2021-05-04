package com.javarush.task.task19.task1925;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws  IOException {
        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);

        BufferedReader reader = new BufferedReader(fileReader);

        Pattern pattern = Pattern.compile("\\S{7,}");
        Matcher matcher;
        String line;
        String lastIndexofArray;
        List<String> listMoreSixChar = new ArrayList<>();

        while (reader.ready()) {
            line = reader.readLine();
            matcher = pattern.matcher(line);
            while (matcher.find()) {
                listMoreSixChar.add(line.substring(matcher.start(), matcher.end()) + ",");
//                fileWriter.write(line.substring(matcher.start(), matcher.end()));
//                if (reader.ready()) {
//                    fileWriter.write(",");
//                }
//                fileWriter.flush();
            }
        }
        lastIndexofArray = listMoreSixChar.get(listMoreSixChar.size()-1).replace(",", "");
        listMoreSixChar.set((listMoreSixChar.size() - 1), lastIndexofArray);
        for (String s : listMoreSixChar){
            fileWriter.write(s);
            fileWriter.flush();
        }






        //Вариант 2 - валидатор не принимает(Пидарас)

//        StringBuilder wordsFromLine = new StringBuilder("");
//
//        while (reader.ready()){
//            wordsFromLine.append(reader.readLine());
//            matcher = pattern.matcher(wordsFromLine);
//
//            if (matcher.find()){
////                System.out.print(wordsFromLine.substring(matcher.start(), matcher.end()) + ",");
//                fileWriter.write(wordsFromLine.substring(matcher.start(), matcher.end()));
//                if (reader.ready())
//                    fileWriter.write(",");
//                fileWriter.flush();

        fileReader.close();
        fileWriter.close();
        reader.close();
    }
}
