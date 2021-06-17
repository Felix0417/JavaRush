package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Externalizable Person
*/

public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(firstName);
            out.writeObject(mother);
            out.writeObject(lastName);
            out.writeObject(father);
            out.writeObject(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = (String) in.readObject();
            mother = (Person) in.readObject();
            lastName = (String) in.readObject();
            father = (Person) in.readObject();
            age = (int) in.readObject();
            children = (List<Person>) in.readObject();
        }

        public Person() {
        }
    }

    public static void main(String[] args) {
//    Person person = new Person();
////        Person person = new Person("Maxim", "Maximov", 27);
////
////        Person father = new Person("FatherFirstName", "FatherLastName", 50);
////        Person mother = new Person("MotherFirstName", "MotherLastName", 47);
////        person.setFather(father);
////        person.setMother(mother);
////
////        Person daughter = new Person("DaughterFirstName", "DaughterLastName", 10);
////        Person son = new Person("SonFirstName", "SonLastName", 7);
////
////        List<Person> childrenArray = new ArrayList<>();
////        childrenArray.add(daughter);
////        childrenArray.add(son);
////        person.setChildren(childrenArray);
//
//        String pathOfFile = "/home/felix/test1.txt";
//
//
//        try{
////            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathOfFile));
////            person.writeExternal(oos);
////            System.out.println("Запмсь прошла успешно!");
////            oos.close();
//
//
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathOfFile));
//            person.readExternal(ois);
//            ois.close();
//
//            System.out.println(person.firstName + "---" + person.lastName + "---" + person.mother.toString()
//                    + "---" + person.father.toString() + "---" + person.age + "---" + person.children.toString());
//
//        }catch (Exception e){}

    }
}
