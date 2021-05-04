package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter(new Scanner(new File("//home//felix//Рабочий стол//Test1")));
        System.out.println(personScannerAdapter.read());
        System.out.println(personScannerAdapter.read());
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() {
            String line = fileScanner.nextLine();
            String[] arr = line.split(" ");
            String lastName = arr[0];
            String firstName = arr[1];
            String middleName = arr[2];

            DateFormat df = new SimpleDateFormat("dddd MM yyyy", Locale.ENGLISH);
            String birthday = arr[3] + " " + arr[4] + " " + arr[5];
            Date date = new Date();
            try {
                date = df.parse(birthday);
            }catch (ParseException e){
                e.printStackTrace();
            }
            return new Person(firstName,middleName, lastName, date);
        }

        @Override
        public void close() {
            fileScanner.close();
        }
    }
}
