package com.codefinity;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaskLockExample {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private int counter = 1;

    public void redLight() {
        // Implement the logic to ensure that the red light is activated.
        lock.lock(); // Захоплює блокування
        try {
            while (counter != 1) {
                condition.await(); // Очікує, поки counter не стане 1
            }
            System.out.println("red light");
            counter ++;
            condition.signalAll(); // // Сповіщає інші потоки, що метод redLight завершився
        } catch  (InterruptedException e) {
            Thread.currentThread().interrupt(); // Відновлює статус переривання потоку
        } finally {
            lock.unlock(); // Звільняє блокування
        }


        // This method should be called first in the sequence.
        // Ensure that other lights do not activate until `redLight()` is completed.
    }

    public void yellowLight() throws InterruptedException {
        // Implement the logic to ensure that the yellow light is activated after redLight().
        lock.lock();
        try {
            while (counter != 2) {
                condition.await();
            }
            System.out.println("yellow light");
            counter ++;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
        // This method should only proceed if `redLight()` has completed.
        // Handle any synchronization needed to ensure that `yellowLight()` runs in the correct order.
    }

    public void greenLight() throws InterruptedException {
        // Implement the logic to ensure that the green light is activated after `yellowLight()`.
        lock.lock();
        try {
            while (counter != 3) {
                condition.await();
            }
            System.out.println("green light");
            // Немає потреби збільшувати лічильник або сповіщати інші потоки."
        } finally {
            lock.unlock();
        }
        // This method should only proceed if `yellowLight()` has completed.
        // Ensure that `greenLight()` activates only after the proper sequence of lights.
    }
}