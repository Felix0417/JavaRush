package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/

public class Solution {

    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B implements Cloneable {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        public String getName() {
            return super.getName();
        }

        @Override
        public int getI() {
            return super.getI();
        }

        @Override
        public int getJ() {
            return super.getJ();
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return new C(getI(),getJ(),getName());
        }
    }

    public static void main(String[] args) {
        A a = new A(10, 10);
        B b = new B(100, 100, "One");
        C c = new C(5, 5 ,"Five");
        B cloneB;
        C cloneC;
        try{
            cloneC = (C) c.clone();
            System.out.println(cloneC.getI() + " - " + cloneC.getJ() + " - " + cloneC.getName());
            cloneB = (B) b.clone(); //здесь возникает исключение
            System.out.println(cloneB.toString());
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
    }
}
