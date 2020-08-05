package com.biturd.knowledgebase.jvm.test;

/**
 * @Program: knowledge-base
 * @Description: b
 * @Author: bittergourd
 * @Date: 2020-01-25 03:52
 */
public class b {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aclass = Class.forName("com.bittergourd.knowlegebase" +
                ".b");
        System.out.println(aclass.getClassLoader());
    }
}
