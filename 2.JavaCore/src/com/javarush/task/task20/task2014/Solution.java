package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Serializable {
    public static void main(String[] args) throws IOException {
        System.out.println(new Solution(4));

        Solution savedObject = new Solution(10);
        Solution loadedObject = new Solution(5);
        String filePath = "/home/felix/test1.txt";
        ObjectOutputStream oos;
        ObjectInputStream ois;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(filePath));
            oos.writeObject(savedObject);
            oos.flush();
            oos.close();

            ois = new ObjectInputStream(new FileInputStream(filePath));
            loadedObject = (Solution) ois.readObject();

            System.out.println(savedObject.string.equals(loadedObject.string));
        }catch (Exception e){}
    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
