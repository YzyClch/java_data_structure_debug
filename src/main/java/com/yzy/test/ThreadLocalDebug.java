package com.yzy.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//import java.lang.ThreadLocal;
public class ThreadLocalDebug {



    public static void main(String[] args) {

        ThreadLocal<String>t1=new ThreadLocal<>();
        ThreadLocal<String>t2=new ThreadLocal<>();
        ThreadLocal<String>t3=new ThreadLocal<>();
        t1.set("1");
        t2.set("2");
        t3.set("3");
        HashMap hashMap = new HashMap();
        String s = t1.get();

        Map map = Collections.synchronizedMap(hashMap);


    }


}
