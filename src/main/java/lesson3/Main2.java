package lesson3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main2 {
    static class  Counter {
        private volatile int count;
        Lock lock = new ReentrantLock();

        public void increment (){
            boolean isLock = false;
            while (!isLock) {
                isLock = lock.tryLock();
            }
            count++;
            System.out.println(getTreadName() + " " + count);
            lock.unlock();
        }
        public void decrement (){
            boolean isLock = false;
            while (!isLock) {
                isLock = lock.tryLock();
            }
            count--;
            System.out.println(getTreadName() + " " + count);
            lock.unlock();
        }
        private String getTreadName (){
            return Thread.currentThread().getName();
        }
    }
    public static void main(String[] args) {
        Counter counter = new Counter();
        System.out.println(counter.count);
        int count = 10;
        Thread t1 = new Thread(()-> {
            for (int i = 0; i < count; i++) {
                counter.decrement();
            }
        });
        Thread t2 = new Thread(()-> {
            for (int i = 0; i < count; i++) {
                counter.increment();
            }
        });
        Thread t3 = new Thread(()-> {
            for (int i = 0; i < count; i++) {
                counter.decrement();
            }
        });
        Thread t4 = new Thread(()-> {
            for (int i = 0; i < count; i++) {
                counter.increment();
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
