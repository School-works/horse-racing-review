package com.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Horse> horses = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Horse horse = new Horse();
            horses.add(horse);
            horse.start();
        }

        for (Horse horse : horses) {
            try {
                horse.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("-------------------------\nRisultati della gara:");
        for (Horse horse : horses) {
            System.out.println("Cavallo " + horse.getHorseId()  +" - Velocità: " + horse.getSpeed());
        }
    }
}
