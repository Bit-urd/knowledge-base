package com.bittergourd.knowledgebase.collection.hashMap;

/**
 * @Program: knowledge-base
 * @Description: HashMap
 * @Author: BitterGourd
 * @Date: 2020-06-14 23:01
 */
public class HashMap<K, V> implements Map<K, V> {

    private Entry<K, V>[] table = null;
    int size = 0;

    public HashMap() {
        table = new Entry[16];
    }

    @Override
    public V put(K k, V v) {
        int index = hash(k);
        Entry<K, V> kvEntry = table[index]; // 先拿到Entry对象，看有没有值呢
        if (kvEntry == null) {
            table[index] = new Entry<>(k, v, index, null);
            size++;
        } else {
            table[index] = new Entry<>(k, v, index, kvEntry);
            // 链表 头插法，直接把当前当成值，next改为原来的链表，把链表接起来。
        }
        return table[index].getValue();
    }

    private int hash(K k) {
        int i = k.hashCode() % 16;
//        return i>=0?i:-i;
        return Math.abs(i);
    }

    @Override
    public V get(K k) {
        if (size == 0) {
            return null;
        }
        int index = hash(k); // hash 得到的 是下标
        if (null == table[index]) {
            return null;
        }
        Entry<K, V> entry = findValue(k, table[index]);
        return entry == null ? null : entry.getValue();

    }

    private Entry<K, V> findValue(K k, Entry<K, V> entry) {
        if (entry.getKey().equals(k) || entry.getKey() == k) {
            return entry;
        } else {
            if (entry.next != null) {
                findValue(k, entry.next);
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    class Entry<K, V> implements Map.Entry<K, V> {
        K k;
        V v;
        int hash;
        Entry<K, V> next;

        public Entry(K k, V v, int hash, Entry<K, V> next) {
            this.k = k;
            this.v = v;
            this.hash = hash;
            this.next = next;
        }

        @Override
        public V getValue() {
            return v;
        }

        @Override
        public K getKey() {
            return k;
        }
    }
}
