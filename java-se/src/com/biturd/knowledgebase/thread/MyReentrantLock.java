package com.biturd.knowledgebase.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Program: knowledge-base
 * @Description: a
 * @Author: BitterGourd
 * @Date: 2020-06-24 01:08
 */
public class MyReentrantLock {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        new Thread(()->{
            reentrantLock.lock();

            try {
                System.out.println(123);
                TimeUnit.SECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantLock.unlock();


        }).start();

        new Thread(()->{
            reentrantLock.lock();

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            reentrantLock.unlock();
        }).start();

    }
}
