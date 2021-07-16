package com.javarush.task.task20.task2017;

import java.io.*;

/* 
Десериализация
*/

public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) {
        try {
            return (objectStream.readObject().getClass() == A.class ? (A) objectStream.readObject() : null);
        }catch (Exception e){
            return null;
        }
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {
//        A a;
//        B b;
//        String filePath = "/home/felix/test1.txt";

//        try{
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
//            oos.writeObject(new A());
//            oos.writeObject(new B());
//            oos.flush();
//            oos.close();
//
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
//            a = getOriginalObject(ois);
//            b = (B) getOriginalObject(ois);
//
//
//            System.out.println(a);
//            System.out.println(b);
//        }catch (Exception e){
//
//        }
    }
}
