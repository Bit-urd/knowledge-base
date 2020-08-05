package com.biturd.knowledgebase.collection;


import com.biturd.knowledgebase.collection.hashMap.HashMap;

/**
 * @Program: knowledge-base
 * @Description: app
 * @Author: BitterGourd
 * @Date: 2020-06-14 22:36
 */
public class app {

    public static void main(String[] args) {
    }



    // 验证手写的HashMap
    private static void myHashMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("123", "456");
        map.put("456", "789");
        map.put("789", "123");

        String s = map.get("789");
        System.out.println(s);
    }


    /**
     * https://www.cnblogs.com/skywang12345/p/3324958.html
     * 证明Hashcode、==、equals
     * == : 它的作用是判断两个对象的地址是不是相等。即，判断两个对象是不试同一个对象。
     *
     * equals() : 它的作用也是判断两个对象是否相等。但它一般有两种使用情况(前面第1部分已详细介绍过)：
     *                  情况1，类没有覆盖equals()方法。则通过equals()比较该类的两个对象时，等价于通过“==”比较这两个对象。
     *                  情况2，类覆盖了equals()方法。一般，我们都覆盖equals()方法来两个对象的内容相等；若它们的内容相等，则返回true(即，认为这两个对象相等)。
     *
     * hashCode() 的作用是获取哈希码，也称为散列码；它实际上是返回一个int整数。这个哈希码的作用是确定该对象在哈希表中的索引位置。
     */
    private static void HashCodeAndEquals() {
        String a = "Aa";
        String b = "BB";
        System.out.println(a.hashCode() + "\t" + b.hashCode());
        System.out.println(a == b);
    }

}
