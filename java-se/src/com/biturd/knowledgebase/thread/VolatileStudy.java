package com.biturd.knowledgebase.thread;

import javax.sound.midi.Soundbank;
import java.util.concurrent.TimeUnit;

/**
 * @Program: knowledge-base
 * @Description: VolatileStudy
 * @Author: BitterGourd
 * @Date: 2020-06-21 22:53
 */
public class VolatileStudy {
    static boolean init_value = true;
//        static volatile int init_value = 0;
    static int MAX = 5;

    public static void main(String[] args) {
        my_test();
    }

    private static void my_test() {
        VolatileStudy volatileStudy = new VolatileStudy();
        new Thread(() -> {
            int x = 0;
            while (init_value){
                System.out.println(123);
            }
            System.out.println(x);

        }).start();
        new Thread(() -> {
            init_value=false;

        }).start();
    }


   /* private static void test() {
        new Thread(() -> {
            int localValue = init_value;
            while (localValue < MAX) {
                if (localValue != init_value) {
                    System.out.println("Reader:" + init_value);
                    localValue = init_value;
                }
            }
        }).start();
        new Thread(() -> {
            int localValue = init_value;
            while (localValue < MAX) {
                System.out.println("updater:" + (++localValue));
                init_value = localValue;
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }*/
}
