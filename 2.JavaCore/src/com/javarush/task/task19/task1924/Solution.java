package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(12, "двенадцать");
        map.put(11, "одиннадцать");
        map.put(10, "десять");
        map.put(9, "девять");
        map.put(8, "восемь");
        map.put(7, "семь");
        map.put(6, "шесть");
        map.put(5, "пять");
        map.put(4, "четыре");
        map.put(3, "три");
        map.put(2, "два");
        map.put(1, "один");
        map.put(0, "ноль");
    }

    public static void main(String[] args) throws IOException {
        String fileName = null;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (IOException ignore) {
            /* NOP */
        }

        String fileLine;

        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            while ((fileLine = in.readLine()) != null) {
                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    fileLine = fileLine.replaceAll("\\b" + entry.getKey() + "\\b", entry.getValue());
                }
                System.out.println(fileLine);
            }
        } catch (IOException ignore) {
            /* NOP */
        }
    }
}

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        FileReader fileReader = new FileReader(reader.readLine());
//        reader.close();
//        BufferedReader reader1 = new BufferedReader(fileReader);
//
//        // /home/felix/������� ����/test1.txt
//
//        String s;
//        StringBuilder stringBuilder = new StringBuilder();
//
//        while (reader1.ready()) {
//            s = reader1.readLine();
//            for (Map.Entry<Integer, String> pair : map.entrySet()) {
//                s = s.replaceAll("\\b" + pair.getKey() + "\\b", pair.getValue());
//            }
//            System.out.println(s);
//            s = "";
//        }
//        reader.close();
//        fileReader.close();
//        reader1.close();
//    }
//}

//
//
////            strings = reader1.readLine().split("\\b");
////            for (int i = 0; i < strings.length; i++) {
////                try {
////                    if (isInteger(strings[i])) {
////                        num = Integer.parseInt(strings[i]);
////                        strings[i] = map.get(num);
////                    }
////
////                } catch (NumberFormatException e) {
////                }
////                stringBuilder.append(strings[i]);
////            }
////            System.out.println(stringBuilder.toString().trim());
////            stringBuilder.delete(0, stringBuilder.length());
//            System.out.println(s);
//        }
//        fileReader.close();
//        reader1.close();
//    }
////    public static boolean isInteger(String a){
////        int i;
////        try{
////            i = Integer.parseInt(a);
////            if (i >= 0 && i < 13)
////                return true;
////        }catch (NumberFormatException e){
////            return false;
////        }
////        return false;
////    }
//}
