package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;

/* 
Знакомство с properties
*/

// Долбанутая задача, она почему-то хочет свое решение( с использованием класса Properties),
// а не то, которое я предложил в закомментированном коде

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

//    static {
//        runtimeStorage.put("Ключ", "Значение");
//        runtimeStorage.put("Ключ1   ", "Значение");
//        runtimeStorage.put("Ключ2   ", "Значение");
//        runtimeStorage.put("Ключ3   ", "Значение");
//        runtimeStorage.put("Ключ4   ", "Значение");
//        runtimeStorage.put("Ключ5   ", "Значение");
//        runtimeStorage.put("Ключ6", "Значение");
//        runtimeStorage.put("Key1", "Value");
//        runtimeStorage.put("Key2", "Value");
//        runtimeStorage.put("Key3", "Value");
//        runtimeStorage.put("Key4", "Value");
//        runtimeStorage.put("Key5", "Value");
//        runtimeStorage.put("Key6", "Value");
//    }

    public static void save(OutputStream outputStream) throws Exception {
        //напишите тут ваш код
        Properties propertiesForSave = new Properties();
        for (Map.Entry<String, String> pair : runtimeStorage.entrySet()) {
            propertiesForSave.setProperty(pair.getKey(), pair.getValue());
        }
        propertiesForSave.store(outputStream, "");

//        PrintWriter printWriter =  new PrintWriter(outputStream);
//        for (Map.Entry<String, String> pair : runtimeStorage.entrySet()){
//            printWriter.write(pair.getKey() + " = " + pair.getValue() + "\n");
//        }
//        printWriter.flush();
//        printWriter.close();
    }

    public static void load(InputStream inputStream) throws IOException {
        //напишите тут ваш код
        Properties propertiesForLoad = new Properties();
        propertiesForLoad.load(inputStream);
        for (Object s : propertiesForLoad.keySet()){
            runtimeStorage.put((String) s, (String) propertiesForLoad.get(s));
        }


//        BufferedReader readFromFile = new BufferedReader(new InputStreamReader(inputStream));
//        String line;
//        String[] keysAndValues;
//        while ((line = readFromFile.readLine()) != null){
//            keysAndValues = line.split("\\s*[=:]\\s*");
//            runtimeStorage.put(keysAndValues[0], keysAndValues[1]);
//        }
//        readFromFile.close();
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fis = new FileInputStream(reader.readLine())) {
//            /home/felix/test1.properties
            load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(runtimeStorage);


//
//        for (Map.Entry<String, String> pair : runtimeStorage.entrySet()){
//            System.out.println(pair.getKey() + " " + pair.getValue());
//        }
//
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//             FileOutputStream fos = new FileOutputStream(reader.readLine())) {
////            /home/felix/test1.properties
//            save(fos);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }




    }
}
