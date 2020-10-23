package com.jinping.datastruct.map;

import java.util.HashMap;

/**
 * @Classname MyHashMap
 * @Description
 * @Date 2020/10/23 12:06 上午
 * @Created by jinping
 */
public class MyHashMap<K, V> {

    private Entry[] table;

    private static Integer CAPACITY = 8;

    private int size = 0;

    public MyHashMap() {
        this.table = new Entry[CAPACITY];
    }

    public int size() {
        return size;
    }

    public Object get(K key) {
        int hash = key.hashCode();
        int i = hash % CAPACITY;

        for (Entry<K,V> entry = table[i]; entry != null; entry = entry.next) {
            if (entry.getK().equals(key)){
                return entry.v;
            }
        }

        return null;
    }

    public Object put(K key, V value) {

        int hash = key.hashCode();
        int i = hash % 8;

        addEntry(key, value, i);

        for (Entry<K,V> entry = table[i]; entry != null; entry = entry.next) {
            if (entry.getK().equals(key)){
                V oldValue = entry.v;
                entry.v = value;
                return oldValue;
            }
        }
        return null;
    }

    private void addEntry(K key, V value, int i) {
        //增加节点
        Entry entry = new Entry(key, value, table[i]);
        //将这个节点设置为头节点
        table[i] = entry;
        size ++;
    }

    class Entry<K, V> {
        private K k;
        private V v;
        private Entry<K, V> next;

        public Entry(K k, V v, Entry<K, V> next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }

        public K getK() {
            return k;
        }


        public V getV() {
            return v;
        }


        public Entry<K, V> getNext() {
            return next;
        }
    }

    public static void main(String[] args) {
        MyHashMap<String,String> myHashMap = new MyHashMap<>();
        for (int i = 0;i < 10 ;i ++){
            myHashMap.put("xiao找" + i, "tinner");
        }

        String jinping = (String) myHashMap.get("xiao找9");
        System.out.println(jinping);
    }

}
