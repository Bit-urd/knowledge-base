package com.bittergourd.knowledgebase.collection;


import com.bittergourd.knowledgebase.collection.hashMap.HashMap;

/**
 * @Program: knowledge-base
 * @Description: app
 * @Author: BitterGourd
 * @Date: 2020-06-14 22:36
 */
public class app {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("123", "456");
        map.put("456", "789");
        map.put("789", "123");

        String s = map.get("789");
        System.out.println(s);
    }
}
