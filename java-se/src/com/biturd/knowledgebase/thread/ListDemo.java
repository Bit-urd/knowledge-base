package com.biturd.knowledgebase.thread;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 故障现象
 * ConcurrentModificationException
 * // 并发修改异常
 * 导致原因
 *
 * 了解方案
 *
 * 优化建议
 * （不能回答加锁）
 * 1.vector
 * 2.Collections.synchronizedList           Collections.synchronizedSet()  // list set map
 * // 既要性能又要数据一致性
 * 3.new CopyOnWriteArrayList<>() juc包里面的
 * */

public class ListDemo {

    public static void main(String[] args) {
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
//        List<String> list = new Vector<>();
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 1; i <= 30; i++) {  // ConcurrentModificationException
            new Thread(()->{
                // 两个生成随机数常用的类 uuid、System.currenttime
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);  // 一边写一边读
                },String.valueOf(i)).start();
        }

    }
}
