package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* 
Живем своим умом
*/

public class Solution extends Thread implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        findAndPrintThrowables(e);
    }

    public void findAndPrintThrowables(Throwable e){
        List<Throwable> throwableList = new ArrayList<>();
        throwableList.add(e);
        Throwable cause = e.getCause();
        while (cause != null){
            throwableList.add(cause);
            cause = cause.getCause();
        }
        Collections.reverse(throwableList);
        for (Throwable msg: throwableList){
            System.out.println(msg);
        }
    }



    public static void main(String[] args) {
     Solution solution = new Solution();
     solution.uncaughtException(new Thread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
     solution.start();


    }
}
