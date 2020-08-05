package com.bittergourd.knowledgebase.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program: knowledge-base
 * @Description: HeapDemo
 * @Author: bittergourd
 * @Date: 2020-01-21 00:24
 */
public class HeapDemo {
    public static void main(String[] args) {
        int i = 0;
        try{
            List<String> list = new ArrayList<>();
            String a = "hello";
            while (true){
                list.add(a);
                a += a;
                i++;
            }
        }catch (Throwable e){
            e.printStackTrace();
            System.out.println(i);
        }
    }
}
