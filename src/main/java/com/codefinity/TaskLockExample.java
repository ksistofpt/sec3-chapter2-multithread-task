package com.codefinity;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaskLockExample {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private int counter = 1;

    public void method1() {
        //TODO...
    }

    public void method2() throws InterruptedException {
        //TODO...
    }

    public void method3() throws InterruptedException {
        //TODO...
    }
}