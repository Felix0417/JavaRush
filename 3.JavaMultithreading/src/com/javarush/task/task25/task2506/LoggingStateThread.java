package com.javarush.task.task25.task2506;


public class LoggingStateThread extends Thread {
    Thread thread;

    public LoggingStateThread(Thread state) {
        this.thread = state;
    }

    @Override
    public void run() {

        State state = thread.getState();
        System.out.println(state);

        while (true){
            if (state != thread.getState()){
                state = thread.getState();
                System.out.println(state);
                if (state == State.TERMINATED){
                    return;
                }

            }

        }
    }
}
