package com.yzy.test;

public class BinOut {


    public static String toBinaryString(Integer i){
        String b = Integer.toBinaryString(i);
        int l;
        String s="";
        if ((l=32-b.length())>0){
            for (int i1 = 0; i1 < l; i1++) {
                s+="0";
            }
        }
        return s+b;
    }

    public static void main(String[] args) {
        System.out.println(toBinaryString(2));
    }

}
