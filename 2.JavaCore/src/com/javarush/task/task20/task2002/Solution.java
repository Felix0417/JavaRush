package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = new File("/home/felix/test1.txt");
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
//           String firstName;
//           String lastName;
//           Date birthDate;
//           boolean isMale;
//           User.Country country
//
            Date birthDate = new Date();

            javaRush.initiate("Maxim", "Maximov", birthDate, true, User.Country.RUSSIA);
            birthDate = new Date();
            javaRush.initiate("Ivan", "Ivanov", birthDate, true, User.Country.RUSSIA);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream, true);
            for(User user : users) {
                printWriter.write(user.getFirstName() + " ");
                printWriter.write(user.getLastName() + " ");
                printWriter.write(user.getBirthDate().getTime() + " ");
                printWriter.write(user.isMale() + " ");
                printWriter.write(user.getCountry() + "\n");
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            String[] argumentsOfUser;
            Date birth = new Date();
            while ((line = reader.readLine()) != null) {

                argumentsOfUser = line.split(" ");
                if (argumentsOfUser[4].equals("null"))
                    argumentsOfUser[4] = User.Country.OTHER.getDisplayName().toUpperCase(Locale.ROOT);

                try {
                    this.initiate(argumentsOfUser[0],
                            argumentsOfUser[1],
                            new SimpleDateFormat("S").parse(argumentsOfUser[2]),
                            Boolean.parseBoolean(argumentsOfUser[3]),
                            User.Country.valueOf(argumentsOfUser[4]));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }

        public void initiate(String firstName, String lastName, Date birthDate, boolean isMale, User.Country country) {
            int num = users.isEmpty() ? 0 : users.size();
            this.users.add(new User());
            this.users.get(num).setFirstName(firstName);
            this.users.get(num).setFirstName(firstName);
            this.users.get(num).setLastName(lastName);
            this.users.get(num).setBirthDate(birthDate);;
            this.users.get(num).setMale(isMale);
            this.users.get(num).setCountry(country);


        }
    }
}
