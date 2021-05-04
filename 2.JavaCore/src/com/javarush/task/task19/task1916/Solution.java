package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
ќтслеживаем изменени€
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
//        String fileName1 = "/home/felix/–абочий стол/test1.txt";
//        String fileName2 = "/home/felix/–абочий стол/test2.txt";

        FileReader fileReader1 = new FileReader(fileName1);
        FileReader fileReader2 = new FileReader(fileName2);

        BufferedReader reader1 = new BufferedReader(fileReader1);
        BufferedReader reader2 = new BufferedReader(fileReader2);

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        while (reader1.ready()){
            list1.add(reader1.readLine());
        }
        while (reader2.ready()){
            list2.add(reader2.readLine());
        }
        reader1.close();
        reader2.close();

        int i = 0;
        int j = 1;

        while (true){
            if (list1.isEmpty() && list2.isEmpty()) break;

            //если первый список пустой
            if (list1.isEmpty()) {
                lines.add(new LineItem(Type.ADDED, list2.get(i)));
                break;
            }
            //если второй список пустой
            if (list2.isEmpty()) {
                lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                break;
            }


            if (list2.contains(list1.get(i))){
                //если совпадают нулевые элементы list1 и list2
                if (list2.get(i).equals(list1.get(i))){
                    lines.add(new LineItem(Type.SAME, list1.get(i)));
                    list1.remove(i);
                    list2.remove(i);
                    //если совпадает первый элемент list1 и нулевой элемент list2
                }else if (list2.get(i).equals(list1.size()> 1 ? list1.get(j) : list1.get(i))){
                    lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                    lines.add(new LineItem(Type.SAME, list1.get(j)));
                    list1.remove(j);

                    list1.remove(i);
                    list2.remove(i);
                    //если совпадает нулевой элемент list1 и первый элемент list2
                }else if ((list2.size()> 1 ? list2.get(j) : list2.get(i)).equals(list1.get(i))){
                    lines.add(new LineItem(Type.ADDED, list2.get(i)));
                    lines.add(new LineItem(Type.SAME, list2.get(j)));
                    list2.remove(j);

                    list1.remove(i);
                    list2.remove(i);
                }
            }else {
                    lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                    list1.remove(i);
                }

        }
//        for (LineItem e : lines){
//            System.out.println(e.type + "---" + e.line);
//        }


        
    }


    public static enum Type {
        ADDED,        //добавлена нова€ строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
