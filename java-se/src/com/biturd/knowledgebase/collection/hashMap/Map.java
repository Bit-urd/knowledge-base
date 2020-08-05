package com.bittergourd.knowledgebase.collection.hashMap;

/**
 * @Program: knowledge-base
 * @Description: Map
 * @Author: BitterGourd
 * @Date: 2020-06-14 22:56
 */
interface Map<K, V> {
    V put(K k,V v);
    V get(K k);
    int size();

    interface Entry<K, V> {
        V getValue();
        K getKey();
    }
}
