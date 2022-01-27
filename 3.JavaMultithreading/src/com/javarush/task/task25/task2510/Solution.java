package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
*/

public class Solution extends Thread {

    public Solution() {
        this.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                if (e instanceof Error){
                    System.out.println("Нельзя дальше работать");
                }else if (e instanceof Exception){
                    System.out.println("Надо обработать");
                }else if (e instanceof Throwable){
                    System.out.println("Поживем - увидим");
                }
            }
        });

        }

    @Override
    public void run() {
        super.run();
        try {
            throw new Exception();
        } catch (Exception e) {
            getUncaughtExceptionHandler().uncaughtException(this, e);
        }
    }


    public static void main(String[] args) {
        Thread thread = new Solution();

        thread.start();
    }
}
