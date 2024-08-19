package com.codefinity;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaskLockExample {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private int counter = 1;

    public void redLight() {
        // TODO: Implement the logic to ensure that the red light is activated.
        // This method should be called first in the sequence.
        // Ensure that other lights do not activate until `redLight()` is completed.
    }

    public void yellowLight() throws InterruptedException {
        // TODO: Implement the logic to ensure that the yellow light is activated after redLight().
        // This method should only proceed if `redLight()` has completed.
        // Handle any synchronization needed to ensure that `yellowLight()` runs in the correct order.
    }

    public void greenLight() throws InterruptedException {
        // TODO: Implement the logic to ensure that the green light is activated after `yellowLight()`.
        // This method should only proceed if `yellowLight()` has completed.
        // Ensure that `greenLight()` activates only after the proper sequence of lights.
    }
}