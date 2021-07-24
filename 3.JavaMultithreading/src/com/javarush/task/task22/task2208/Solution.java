package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", "null");

        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder("");
        String tempString;
        boolean isFirst = true;
        for (Map.Entry<String, String> pair : params.entrySet()){
            if (pair.getValue() == null || pair.getValue().equals("null")){
                continue;
            }
            tempString = pair.getKey() + " = " + "'" + pair.getValue() + "'";

            if (!isFirst){
                sb.append(" and ").append(tempString);
            }else {
                sb.append(tempString);
                isFirst = false;
                }
        }
        return sb.toString();
    }
}
