package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(filename1);
        FileWriter fileWriter = new FileWriter(filename2);


        ArrayList<Integer> integerArrayList = new ArrayList<>();
        try {
            while (fileReader.ready())
                integerArrayList.add(fileReader.read());
            for (int i = 1; i <= integerArrayList.size() - 1; i += 2) {
                fileWriter.write(integerArrayList.get(i));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        fileWriter.flush();

        fileReader.close();
        fileWriter.close();
    }
}
