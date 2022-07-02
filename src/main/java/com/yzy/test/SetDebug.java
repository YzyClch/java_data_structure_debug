package com.yzy.test;

//import org.testng.annotations.Test;

import org.junit.Test;

import java.util.*;

public class SetDebug {

    public static void main(String[] args) {

        HashMap hashMap = new HashMap();
        Set set = hashMap.keySet();

        HashSet<Object> hashSet = new HashSet<>();
        LinkedHashSet<Object> linkedHashSet = new LinkedHashSet<>();
        TreeSet<Object> treeSet = new TreeSet<>();
        TreeMap<Integer, Object> treeMap = new TreeMap<>();
        treeMap.put(1,1);
        treeMap.put(3,3);
        treeMap.put(2,2);

        new LinkedHashMap<>();
        treeSet.add(null)
        ;
        linkedHashSet.add(null);
        hashSet.add(new Object());
        Iterator<Object> iterator = hashSet.iterator();
        Object next = iterator.next();
        System.out.println(next);

    }


    @Test
    public void linkedHashMapTest(){
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("test1",new Object());
        LinkedHashSet linkedHashSet=new LinkedHashSet();
//        linkedHashSet.add()
    }


    @Test
    public void LinkedListTest(){
        new LinkedList<>().add(null);
    }

    @Test
    public void arrayListTest(){
        new ArrayList<>().add(null);
    }

    static class HashCodeClass implements Comparable{
        @Override
        public int hashCode() {
            return 100;
        }

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }

    @Test
    public void identityHashCodeTest(){
        System.out.println(System.identityHashCode(new HashCodeClass()));
        System.out.println(System.identityHashCode(new HashCodeClass()));
    }
}
