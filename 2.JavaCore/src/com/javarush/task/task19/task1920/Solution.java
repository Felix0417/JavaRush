package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Double> map = new TreeMap<>();
        LinkedHashMap<String, Double> linkedHashMap = new LinkedHashMap<>();


        FileReader fileReader = new FileReader(args[0]);
        BufferedReader reader = new BufferedReader(fileReader);
        String[] line = new String[2];
        line[0] = " ";
        double d = 0;
        double d1 = 0;
        while (reader.ready()) {
            line = reader.readLine().split(" ");
            if (line[0].equals("")) break;
            if (map.containsKey(line[0])) {
                d1 = map.get(line[0]) + Double.parseDouble(line[1]);
                map.put(line[0], d1);
            } else map.put(line[0], Double.parseDouble(line[1]));
        }

        reader.close();
        fileReader.close();

        DecimalFormat decimalFormat = new DecimalFormat("#,#");

        d = Collections.max(map.values());

        for (Map.Entry<String, Double> pair : map.entrySet()){
            d1 = pair.getValue();
            if (d == d1){
                System.out.print(pair.getKey() + " ");
            }
        }
    }
}
