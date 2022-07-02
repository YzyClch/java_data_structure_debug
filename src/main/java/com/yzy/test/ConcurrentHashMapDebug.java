package com.yzy.test;

import com.yzy.util.ConcurrentHashMap;

public class ConcurrentHashMapDebug {


    public static void main(String[] args) {
        System.out.println(ConcurrentHashMap.HASH_BITS);
        ConcurrentHashMap<String, Object> hashMap = new ConcurrentHashMap<>();
        hashMap.put("xx","yy");
        hashMap.put("11","yy");
        hashMap.put("22","yy");
    }



}
