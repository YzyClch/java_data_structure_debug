package com.yzy.test;

import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDebug {


    public static void main(String[] args) {



        CopyOnWriteArrayList<Object> list = new CopyOnWriteArrayList<>();
        list.add(new Object());
        list.get(1);
    }
}
