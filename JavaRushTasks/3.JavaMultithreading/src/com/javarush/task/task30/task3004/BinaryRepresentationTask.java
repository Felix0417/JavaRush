package com.javarush.task.task30.task3004;

import java.util.concurrent.RecursiveTask;

public class BinaryRepresentationTask extends RecursiveTask<String> {
    int x;

    public BinaryRepresentationTask(int x) {
        this.x = x;
    }

    @Override
    protected String compute() {
        if (x > 1) {
            BinaryRepresentationTask task = new BinaryRepresentationTask(x / 2);
            task.fork();
            return task.join() + x % 2;
        }
        return String.valueOf(x % 2);
    }
}
