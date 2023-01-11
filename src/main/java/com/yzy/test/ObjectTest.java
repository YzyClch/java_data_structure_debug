package com.yzy.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

public class ObjectTest {


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class MyObject implements Cloneable{
        public MyObject(Long id,String name){
            this.id=id;
            this.name=name;
            o2=new MyObject();
        }
        Long id;
        String name;
        Object o=new Object();
        MyObject o2=null;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


    public static void main(String[] args) throws CloneNotSupportedException {
        MyObject o = new MyObject(1L, "nn");
        Object o2 = o.clone();
        o.setId(2L);
        System.out.println(o);

        System.out.println(o2);
    }
}
