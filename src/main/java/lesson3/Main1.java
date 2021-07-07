package lesson3;

import java.util.Scanner;

public class Main1 {

    public static class PingPong {
        private final Object monitor = new Object();
        private volatile String current = null;
        private final String word1 = " ping ";
        private final String word2 = " pong ";
        private volatile int count = 10;

        public PingPong() {
            this.current = word1;
        }

        public void printPing() {
            synchronized (monitor) {
                try {
                    while (count > 1) {
                        while (!current.equals(word1)) {
                            monitor.wait();
                        }
                        System.out.print(word1);
                        current = word2;
                        count--;
                        monitor.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void printPong() {
            synchronized (monitor) {
                try {
                    while (count > 1) {
                        while (!current.equals(word2)) {
                            monitor.wait();
                        }
                        System.out.print(word2);
                        System.out.println();
                        current = word1;
                        count--;
                        monitor.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        PingPong pp = new PingPong();
        Thread t1 = new Thread(() -> {
            pp.printPing();
        });
        Thread t2 = new Thread(() -> {
            pp.printPong();
        });
        t1.start();
        t2.start();
    }
}

