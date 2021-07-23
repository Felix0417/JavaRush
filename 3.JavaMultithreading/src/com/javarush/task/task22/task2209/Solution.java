package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.*;

/* 
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        // /home/felix/test1.txt
        // C:\Projects\test1.txt
        // Исходные слова  - Мартышка Ацтек Арбуз Заяц Занзибар Рио Окрошка Армия Кролик Краска Цепелин Норма Ятаган Нияз Зам
        // Результат - Мартышка Ацтек Кролик Краска Арбуз Заяц Цепелин Норма Армия Ятаган Нияз Занзибар Рио Окрошка
        // всего 15 слов
        // переобуваем наш BufferedReader на чтение данных из файла
        reader = new BufferedReader(fileReader);
        try {

            String[] words = reader.readLine().split(" ");

            StringBuilder result = getLine(words);
            System.out.println(result.toString());
        }catch (Exception e){}

        fileReader.close();
        reader.close();
    }

    public static StringBuilder getLine(String... words) {
        if (words.length == 0){
            return new StringBuilder();
        }
        StringBuilder sb = new StringBuilder("");;
        List<String> list = new ArrayList<>(Arrays.asList(words));

        // отправляем на обработку в функцию
        chainOfSb(list, sb);

        return sb;
    }


    public static void chainOfSb(List<String> list, StringBuilder sb){
        int count = 0;

        List<String> tempList = new ArrayList<>();

        boolean flag = true;
        while (flag){
            tempList.addAll(list);
            sb.append(tempList.get(0));
            tempList.remove(0);
            count++;

            String lastChar;
            String newWordChar;

            for (int i = tempList.size() - 1; i >= 0; i--) {
                lastChar = sb.substring(sb.length() - 1);
                for (String w : tempList) {
                    newWordChar = w.substring(0, 1);
                    if (lastChar.equalsIgnoreCase(newWordChar)) {
                        sb.append(" ").append(w);
                        tempList.remove(w);
                        count++;
                        break;
                    }
                }
            }
            if (count == list.size()){
                flag = false;
            }else {
                sb.delete(0,sb.length());
                count = 0;
                Collections.shuffle(list);
            }
        }

    }
}
