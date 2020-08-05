package com.biturd.knowledgebase.thread.pool;

/**
 * @Program: knowledge-base
 * @Description: IDenyPolicy
 * @Author: Biturd
 * @Date: 2020-08-03 19:49
 */
public interface IDenyPolicy {
    void reject(Runnable runnable, IRunnableQueue threadPool);

    // 直接丢弃线程
    class DiscardDenyPolicy implements IDenyPolicy {
        @Override
        public void reject(Runnable runnable, IRunnableQueue threadPool) {

        }
    }

    // 抛出异常
    class AbortDenyPolicy implements IDenyPolicy{
        @Override
        public void reject(Runnable runnable, IRunnableQueue threadPool) {
            throw new RuntimeException("名字为"+ runnable +"这个线程被丢弃了");
        }
    }

    class RunnerDenyPolicy implements IDenyPolicy{
        @Override
        public void reject(Runnable runnable, IRunnableQueue threadPool) {
            runnable.run();
        }
    }

}
