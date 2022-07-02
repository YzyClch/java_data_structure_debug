package com.yzy.test;


import com.yzy.util.HashMap;
import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;


public class HashMapDebug {

    static class HashKey{

        HashKey(String name,String hashKey,String equalsTag){
            this.hashKey=hashKey;
            this.name=name;
            this.equalsTag=equalsTag;
        }
        public String equalsTag;
        public String hashKey;
        public String name;

        @Override
        public int hashCode() {
            return Integer.parseInt(hashKey,2);
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof HashKey)){
                return false;
            }
            return this.equalsTag.equals(((HashKey) o).equalsTag);
        }
    }


    @Test
    public void concurrentHashMapTest(){
        ConcurrentHashMap<HashKey, Object> map = new ConcurrentHashMap<>();
        map.put(new HashKey("我是第一个","1","tag1"),new Object());
        map.put(new HashKey("我是第二个","1","tag2"),new Object());
        map.put(new HashKey("我是第三个","1","tag3"),new Object());
        map.put(new HashKey("我是第四个","1","tag4"),new Object());
        map.put(new HashKey("我是第五个","1","tag5"),new Object());
        map.put(new HashKey("我是第六个","1","tag6"),new Object());
        map.put(new HashKey("我是第七个","1","tag7"),new Object());
        map.put(new HashKey("我是第八个","1","tag8"),new Object());
        map.put(new HashKey("我是第九个","1","tag9"),new Object());
        map.put(new HashKey("我是第10个","1","tag10"),new Object());
        map.put(new HashKey("我是第11个","1","tag11"),new Object());
    }


    public static void main(String[] args) throws InterruptedException {

        HashMap<HashKey, Object> map = new HashMap<>(1);
        System.out.println(map.threshold);
        map.put(new HashKey("我是第一个","1","tag1"),new Object());
        map.put(new HashKey("我是第二个","1","tag2"),new Object());
        map.put(new HashKey("我是第三个","1","tag3"),new Object());
        map.put(new HashKey("我是第四个","1","tag4"),new Object());
        map.put(new HashKey("我是第五个","1","tag5"),new Object());
        map.put(new HashKey("我是第六个","1","tag6"),new Object());
        map.put(new HashKey("我是第七个","1","tag7"),new Object());
        map.put(new HashKey("我是第八个","1","tag8"),new Object());
        map.put(new HashKey("我是第九个","1","tag9"),new Object());
        map.put(new HashKey("我是第10个","1","tag10"),new Object());
        map.put(new HashKey("我是第11个","1","tag11"),new Object());
//            for (int i = 10; i < 100; i++) {
//                int finalI = i;
//                new Thread(()->map.put(new HashKey("我是第"+ finalI +"个","1","tag"+ finalI),new Object())).start();
//
//        }
//            Thread.sleep(5000L);
    }

}
