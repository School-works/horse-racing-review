package com.example;

public class Horse extends Thread {
    private Track track = new Track(100);
    public static int nextHorseId = 1; 
    public int horseId;
    private int position = 0;
    private boolean hasFinished = false;
    private int speed = (int) (Math.random() * 10) + 1;

    public Horse() {
        this.horseId = nextHorseId++;  
    }

    public void run() {
        race();
    }

    private void race() {
        while (!hasFinished) {
            System.out.println("Il cavallo " + horseId + " sta avanzando");
            position += speed;
            if (position >= track.length) {
                hasFinished = true;
                System.out.println("Il cavallo " + horseId + " ha finito la gara!");
            }
            try {
                Thread.sleep(500);
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
}
