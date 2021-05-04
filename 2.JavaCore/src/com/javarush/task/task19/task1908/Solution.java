package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();


        BufferedReader reader1 = new BufferedReader(fileReader);
        String line;
        String[] array;
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        while ((line = reader1.readLine()) != null){
            array = line.replaceAll("\\p{Punct} ", " ").split(" ");
            for (String a : array){
                if (a.matches("^\\d+$")){
                    integerArrayList.add(Integer.parseInt(a));
                }
            }
        }
        reader1.close();
        for(int x : integerArrayList){
            writer.write(x + " ");
        }
        writer.flush();

        fileReader.close();
        writer.close();

    }
}
