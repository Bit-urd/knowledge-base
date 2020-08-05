package com.biturd.knowledgebase.thread;

import java.util.concurrent.Semaphore;

/**
 * @Program: knowledge-base
 * @Description: ProviderConsumer
 * @Author: BitterGourd
 * @Date: 2020-06-23 20:55
 */
public class ProviderConsumer {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1,true);
        // 公平就是  后来的 就不会跟先来的一块竞争
        new Thread(()->{
            try {
                Thread.sleep(2000);
                System.out.println("T1 running");
                semaphore.acquire();

                System.out.println("T1 Stopped");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        }).start();

        new Thread(()->{
            try {
                semaphore.acquire();

                System.out.println("T2 running");
                Thread.sleep(1000);
                System.out.println("T2 Stopped");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        }).start();
    }
}
