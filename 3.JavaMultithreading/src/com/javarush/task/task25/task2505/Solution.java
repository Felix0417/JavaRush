package com.javarush.task.task25.task2505;

/* 
Без дураков
*/

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public class MyThread extends Thread {


        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
//            setDaemon(true);
        }


        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }

        private class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

            public MyUncaughtExceptionHandler() {

            }

            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {
                String format = String.format("%s, %s, %s",  secretKey, thread.getName(), throwable.getMessage());

                try {
                    Thread.sleep(500);
                    System.out.println(format);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

