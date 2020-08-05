package com.bittergourd.knowledgebase.jvm.test;

import java.util.List;

/**
 * @Program: knowledge-base
 * @Description: app
 * @Author: bittergourd
 * @Date: 2020-01-23 22:10
 */
public class a {
    public List<Integer> Abc ;
    public static int i = 0;

    {
        b = 5;
        i = 6;
    }
    int b;
    public a(){
        int x = 5;
    }
    public a(int a){
        int x=10;
    }
    public static final void fun(final int a){
        System.out.println(a);
    }
    public static void fun2(int a){
        System.out.println(a);
    }
    public static final void fun3(){

    }
    public static void main(String[] args) {
//        int i = 0;
//        int x = 5;
//        while (i < 10){
//            x = x++;
//            System.out.println(x);
//            i++;
//        }
//        i = x++;
//        app b=new app();
//        System.out.println(b.i);
//    }
        a b=new a();
        b.fun(15);
        fun2(15);
        fun3();
//        try {
//            // https://blog.csdn.net/JustBeauty/article/details/81116144
//            // 根据局部变量获得泛型
//            ParameterizedType pType = (ParameterizedType) b.getClass().getField("Abc").getGenericType();
//
//            System.out.println(pType.getActualTypeArguments()[0].getTypeName());
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
    }
}
