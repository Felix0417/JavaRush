package com.javarush.task.task24.task2401;

/* 
Создание своего интерфейса-маркера
*/

public class Solution {
    public static void main(String[] args) throws UnsupportedInterfaceMarkerException {
        SelfInterfaceMarkerImpl obj = new SelfInterfaceMarkerImpl() {
            @Override
            public void oneOne() {

            }

            @Override
            public void oneTwo() {

            }
        };
        Util.testClass(obj);
//        Util.testClass(null);
    }

}
