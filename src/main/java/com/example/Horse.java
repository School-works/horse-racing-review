package com.example;

import java.util.concurrent.atomic.AtomicInteger;

public class Horse extends Thread {
    private Track track = new Track(100);
    public static AtomicInteger nextHorseId = new AtomicInteger(1);
    public static AtomicInteger rankings = new AtomicInteger(0);
    public int finalHorseRank;
    public int horseId;
    private int position = 0;
    private boolean hasFinished = false;
    private int speed = (int) (Math.random() * 10) + 1;

    public Horse() {
        this.horseId = nextHorseId.getAndIncrement(); 
        this.finalHorseRank = 0;

    }

    public void run() {
        race();
    }

    private void race() {
        while (!hasFinished) {
            position += speed;
            if (position >= track.length) {
                hasFinished = true;
                System.out.println("Il cavallo " + horseId + " ha finito la gara!");
                finalHorseRank = rankings.incrementAndGet();
            }
            else {
                System.out.println("Il cavallo " + horseId + " sta avanzando");
            }
            try {
                Thread.sleep(1); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getPosition() {
        return position;
    }

    public boolean isHasFinished() {
        return hasFinished;
    }

    public int getSpeed() {
        return speed;
    }

    public int getHorseId() {
        return horseId;
    }

    public int getRanking() {
        return finalHorseRank;
    }
}
