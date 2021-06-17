package com.javarush.task.task20.task2004;

import java.io.*;

/* 
Читаем и пишем в файл статики
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File yourFile = new File("C:\\Тестовые файлы для учебы\\test1.txt");
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            ClassWithStatic classWithStatic = new ClassWithStatic();
            classWithStatic.i = 3;
            classWithStatic.j = 4;
            classWithStatic.save(outputStream);
            outputStream.flush();

            ClassWithStatic loadedObject = new ClassWithStatic();
            loadedObject.staticString = "something";
            loadedObject.i = 6;
            loadedObject.j = 7;

            loadedObject.load(inputStream);
//here check that the classWithStatic object is equal to the loadedObject object - проверьте тут, что classWithStatic и loadedObject равны
            System.out.println(classWithStatic.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class ClassWithStatic {
        public static String staticString = "This is a static test string";
        public int i;
        public int j;

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write(staticString + " ");
            printWriter.write(this.i + " ");
            printWriter.write(this.j + "\n");

            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            String[] dataOfTheObject;
            StringBuilder sb = new StringBuilder("");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            dataOfTheObject = reader.readLine().split(" ");
            this.j = Integer.parseInt(dataOfTheObject[dataOfTheObject.length - 1]);
            this.i = Integer.parseInt(dataOfTheObject[dataOfTheObject.length - 2]);
            for (int k = 0; k < dataOfTheObject.length -2 ; k++) {
                sb.append(dataOfTheObject[k]).append(" ");
            }
            staticString = sb.toString().trim();

            reader.close();

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ClassWithStatic that = (ClassWithStatic) o;

            if (i != that.i) return false;
            return j == that.j;

        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }
    }
}
