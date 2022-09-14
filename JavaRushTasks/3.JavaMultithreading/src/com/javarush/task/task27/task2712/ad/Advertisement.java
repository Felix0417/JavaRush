package com.javarush.task.task27.task2712.ad;

public class Advertisement implements Comparable<Advertisement> {
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;
    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        try {
            this.amountPerOneDisplaying = initialAmount / hits;
        } catch (Exception ignored) {
        }
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public void revalidate() {
        if (this.hits < 1) {
            throw new UnsupportedOperationException();
        }
        this.hits--;
    }

    @Override
    public int compareTo(Advertisement o) {
        return (int) (this.amountPerOneDisplaying - o.amountPerOneDisplaying);
    }
}
