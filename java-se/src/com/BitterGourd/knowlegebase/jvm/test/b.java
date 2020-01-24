package com.BitterGourd.knowlegebase;

/**
 * @Program: knowledge-base
 * @Description: b
 * @Author: BitterGourd
 * @Date: 2020-01-25 03:52
 */
public class b {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aclass = Class.forName("com.BitterGourd.knowlegebase" +
                ".b");
        System.out.println(aclass.getClassLoader());
    }
}
