package com.biturd.knowledgebase.thread.pool;

/**
 * @Program: knowledge-base
 * @Description: Test
 * @Author: Biturd
 * @Date: 2020-08-03 20:46
 */
public class Test {
    public static void main(String[] args) {
        MyRunnableQueue runnableQueue = new MyRunnableQueue(5, new IDenyPolicy.DiscardDenyPolicy());
        MyThreadPool threadPool = new MyThreadPool(3, runnableQueue);
//        runnableQueue.offer(() -> {System.out.println(Thread.currentThread().getName()+ "\t0");
//            try {
//                Thread.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
        runnableQueue.offer(() -> System.out.println(Thread.currentThread().getName()+ "\t0"));
        runnableQueue.offer(() -> System.out.println(Thread.currentThread().getName()+ "\t1"));
        runnableQueue.offer(() -> System.out.println(Thread.currentThread().getName()+ "\t2"));
        threadPool.list.get(1).start();
        threadPool.list.get(0).start();
    }
}
