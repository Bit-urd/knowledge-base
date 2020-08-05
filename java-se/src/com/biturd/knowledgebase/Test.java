package com.biturd.knowledgebase;

import java.util.Scanner;

/**
 * @Program: knowledge-base
 * @Description: MyExam
 * @Author: BitterGourd
 * @Date: 2020-06-24 19:24
 */
public class Test {

    public static void main(String[] args) {
        StringT();

    }

    private static void StringT() {
        String x = "string";
        String y = "string";
        String z = new String("string");
        Integer a = new Integer(122);
        Integer b = new Integer(122);

        System.out.println(x==y);
        System.out.println(x==z);
        System.out.println(x.equals(y));
        System.out.println(x.equals(z));
        StringTest(a, b);
    }

    private static void StringTest(Integer a, Integer b) {
        System.out.println(a == b);
    }

    private static void fun() {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int month=sc.nextInt();
        if (month == 3 || month == 4 || month == 5) {
            System.out.println(month + "月是春季");
        } else if (month == 6 || month == 7 || month == 8) {
            System.out.println(month + "月是夏季");
        } else if (month == 9 || month == 10 || month == 11) {
            System.out.println(month + "月是秋季");
        } else if (month == 12 || month == 1 || month == 2) {
            System.out.println(month + "月是冬季");
        } else {
            System.out.println("没有这个月份");
        }
    }

}