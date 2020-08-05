package com.biturd.knowledgebase.thread.pool;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program: knowledge-base
 * @Description: MyThreadPool
 * @Author: Biturd
 * @Date: 2020-08-05 08:42
 */
public class MyThreadPool {
    List<InnerThread> list=new ArrayList<>();

    public MyThreadPool(int size, MyRunnableQueue myRunnableQueue){
        // 创建几个工作的线程，处理哪个队列
        for (int i = 0; i < size; i++) {
            InnerThread thread = new InnerThread(myRunnableQueue);
            list.add(i, thread);
        }
    }
}
