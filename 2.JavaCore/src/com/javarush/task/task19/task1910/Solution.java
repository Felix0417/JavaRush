package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
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
            stringArrayList.add(line.replaceAll("\\p{Punct}", "").replaceAll("\\n", ""));
        }
        for (String x : stringArrayList){
            bufferedWriter.write(x);
        }
        bufferedWriter.flush();

        reader1.close();
        fileReader.close();
        bufferedWriter.close();
    }
}
