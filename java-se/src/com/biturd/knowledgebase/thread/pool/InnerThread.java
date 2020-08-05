package com.biturd.knowledgebase.thread.pool;

/**
 * @Program: knowledge-base
 * @Description: InnerThread
 * @Author: Biturd
 * @Date: 2020-08-05 09:30
 */
public class InnerThread extends Thread {
    private MyRunnableQueue runnables;

    public InnerThread(MyRunnableQueue runnables) {
        this.runnables = runnables;
    }

    @Override
    public void run() {
        while (true) {   // 这个是个 死循环，一旦 执行 完 上一个 任务，就开始取下一个任务，取不出来就阻塞
            try {
                Runnable take = runnables.take();
                take.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
