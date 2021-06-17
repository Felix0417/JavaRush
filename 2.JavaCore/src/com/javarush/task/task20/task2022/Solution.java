package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }
    public Solution(){}

    public FileOutputStream getStream(){
        return this.stream;
    }

    public void setStream(FileOutputStream stream) {
        this.stream = stream;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException {
        Solution solution;
        String filePath = "/home/felix/test1.txt";
        ObjectInputStream ois;
        try {
            solution = new Solution(filePath);
            solution.writeObject("Вышел");
            solution.writeObject("Месяц");
            solution.writeObject("Из");
            solution.writeObject("Тумана");
            solution.writeObject("Вынул");
            solution.writeObject("Ножик");
            solution.writeObject("Из");
            solution.writeObject("Кармана");

//            ois = new ObjectInputStream(new FileInputStream(filePath));
//            solution = (Solution) ois.readObject();
//            solution.writeObject((String) ois.readObject());
//            solution.writeObject((String) ois.readObject());
//            solution.writeObject((String) ois.readObject());
//            solution.writeObject((String) ois.readObject());
//            solution.writeObject((String) ois.readObject());
//            solution.writeObject((String) ois.readObject());
//            solution.writeObject((String) ois.readObject());
//            solution.writeObject((String) ois.readObject());
//            solution.writeObject((String) ois.readObject());
//            solution.writeObject((String) ois.readObject());
            System.out.println(solution.stream);



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
