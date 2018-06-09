package com.javachallenges.ljc;

import java.time.Instant;

public class ThreadChallenge {
    private static final String START_TIME = Instant.now().toString();
    private static int wolverineAdrenaline = 10;
    private static String runNumber;

    public static void main(String... doYourBest) throws InterruptedException {
        runNumber = doYourBest[0];

        new Motorcycle("first").start();
        new Motorcycle("second").start();
        new Motorcycle("third").start();

        Motorcycle fastBike = new Motorcycle("last");
        fastBike.setPriority(Thread.MAX_PRIORITY);
        fastBike.setDaemon(true);
        fastBike.start();
    }

    static class Motorcycle extends Thread {
        public Motorcycle(String bikeName) {
            super(runNumber + ":" + bikeName);
        }

        @Override
        public void run() {
            wolverineAdrenaline++;
            if (wolverineAdrenaline == 14) {
                String startTimeSeconds = getStartTimeSeconds();
                System.out.println(String.format(" > Last Bike   [%s] @ %s", this.getName(), startTimeSeconds));
            }
        }

        private String getStartTimeSeconds() {
            int beginIndex = START_TIME.length() - 10;
            int endIndex = START_TIME.length() - 1;
            return START_TIME.substring(beginIndex, endIndex);
        }
    }
}
