package com.yzy.test;

import com.yzy.util.ConcurrentHashMap;

public class ConcurrentHashMapDebug {


    public static void main(String[] args) {
        System.out.println(ConcurrentHashMap.HASH_BITS);
        ConcurrentHashMap<HashMapDebug.HashKey, Object> map = new ConcurrentHashMap<>();
        map.put(new HashMapDebug.HashKey("我是第一个","1","tag1"),new Object());
        map.put(new HashMapDebug.HashKey("我是第二个","1","tag2"),new Object());
        map.put(new HashMapDebug.HashKey("我是第三个","1","tag3"),new Object());
        map.put(new HashMapDebug.HashKey("我是第四个","1","tag4"),new Object());
        map.put(new HashMapDebug.HashKey("我是第五个","1","tag5"),new Object());
        map.put(new HashMapDebug.HashKey("我是第六个","1","tag6"),new Object());
        map.put(new HashMapDebug.HashKey("我是第七个","1","tag7"),new Object());
        map.put(new HashMapDebug.HashKey("我是第八个","1","tag8"),new Object());
        map.put(new HashMapDebug.HashKey("我是第九个","1","tag9"),new Object());
        map.put(new HashMapDebug.HashKey("我是第10个","1","tag10"),new Object());
        map.put(new HashMapDebug.HashKey("我是第11个","1","tag11"),new Object());
    }



}
