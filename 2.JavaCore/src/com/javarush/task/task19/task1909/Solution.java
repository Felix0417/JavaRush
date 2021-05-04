package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();

        BufferedReader reader1 = new BufferedReader(fileReader);
        String line;
        ArrayList<String> stringArrayList = new ArrayList<>();

        while ((line = reader1.readLine()) != null){
            stringArrayList.add(line.replaceAll("\\.", "!"));
        }
        for (String s : stringArrayList){
            bufferedWriter.write(s);
        }
        bufferedWriter.flush();

        reader1.close();
        fileReader.close();
        bufferedWriter.close();

    }
}
