package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public Hippodrome(List<Horse> list){
        this.horses = list;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    void move(){
        for (Horse horse : horses){
            horse.move();
        }
    }

    void print(){
        for (Horse horse : horses){
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner(){
        Horse winner = null;
        int trackDistance = 0;
        for (Horse horse : horses){
            if (horse.getDistance() > trackDistance){
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<>());

        game.horses.add(new Horse("A", 3, 0));
        game.horses.add(new Horse("B", 3, 0));
        game.horses.add(new Horse("C", 3, 0));

        //запускаем нить
        game.run();
        game.printWinner();

    }
}
