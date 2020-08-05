package com.biturd.knowledgebase.thread.pool;

/**
 * @Program: knowledge-base
 * @Description: IThreadPool
 * @Author: Biturd
 * @Date: 2020-08-03 19:48
 */
public interface IThreadPool {  // 池子就是一个队列
    void offer(Runnable runnable);

    Runnable take();

    int size();
}
