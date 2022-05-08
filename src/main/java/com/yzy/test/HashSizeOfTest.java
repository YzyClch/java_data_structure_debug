package com.yzy.test;

import com.yzy.util.HashMap;

public class HashSizeOfTest {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * 用于保证hashmap的初始容量一定是2的次幂
     * @param cap
     * @return
     */
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        System.out.println("            n："+BinOut.toBinaryString(n)+" ："+n);
        System.out.println("     n >>>  1："+BinOut.toBinaryString(n>>>1));
        n |= n >>> 1;
        System.out.println("n |= n >>>  1："+BinOut.toBinaryString(n)+" ："+n);
        System.out.println("     n >>>  2："+BinOut.toBinaryString(n>>>2));
        n |= n >>> 2;
        System.out.println("n |= n >>>  2："+BinOut.toBinaryString(n)+" ："+n);
        System.out.println("     n >>>  4："+BinOut.toBinaryString(n>>>4));
        n |= n >>> 4;
        System.out.println("n |= n >>>  4："+BinOut.toBinaryString(n)+" ："+n);
        System.out.println("     n >>>  8："+BinOut.toBinaryString(n>>>8));
        n |= n >>> 8;
        System.out.println("n |= n >>>  8："+BinOut.toBinaryString(n)+" ："+n);
        System.out.println("     n >>> 16："+BinOut.toBinaryString(n>>>16));
        n |= n >>> 16;
        System.out.println("n |= n >>> 16："+BinOut.toBinaryString(n)+" ："+n);
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public static void main(String[] args) {
        System.out.println(tableSizeFor(2));

        System.out.println(tableSizeFor(6));
    }
}
