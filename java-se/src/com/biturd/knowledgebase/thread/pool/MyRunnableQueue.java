package com.biturd.knowledgebase.thread.pool;

import java.util.LinkedList;

/**
 * @Program: knowledge-base
 * @Description: MyThreadPool
 * @Author: Biturd
 * @Date: 2020-08-03 20:29
 */
public class MyRunnableQueue implements IRunnableQueue {

    private final LinkedList<Runnable> myThreadQueue = new LinkedList<>();

    private final int maxValue;

    private final IDenyPolicy iDenyPolicy;

    public MyRunnableQueue(int maxValue,IDenyPolicy iDenyPolicy){
        this.maxValue = maxValue;
        this.iDenyPolicy = iDenyPolicy;
    }

    @Override
    public void offer(Runnable runnable) {  // 添加，如果小于最大值 就 添加
        synchronized (myThreadQueue) {
            if (myThreadQueue.size() > maxValue) {
                iDenyPolicy.reject(runnable, this);
            }else {
                myThreadQueue.addLast(runnable);
                runnable.notifyAll();
            }
        }
    }

    @Override
    public Runnable take() {
        synchronized (myThreadQueue) {
            while (myThreadQueue.isEmpty()) {
                try {
                    myThreadQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return myThreadQueue.removeFirst();
        }
    }

    @Override
    public int size() {
        synchronized (myThreadQueue) {
            return myThreadQueue.size();
        }
    }
}
