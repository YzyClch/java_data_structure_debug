package com.yzy.leecode;

import org.junit.Test;

public class OtherTest {


    public int reverseBits(int n) {

        /**
         * 101010 -> 010101
         *
         * 000000
         * 000000
         * 000001
         *
         */
        int r =0;
        for (int i = 0; i < 32; i++) {
            r <<=1;
            r |= n & 1; // r与n最低位做或运算
            n >>= 1;
        }
        return r;
    }


    @Test
    public void testreverseBits(){
        System.out.println(reverseBits(2));
    }



    @Test
    public void testhammingDistance(){
        System.out.println(hammingDistance(1, 3));
    }


    public int hammingDistance(int x, int y) {
        int j = x ^ y;
        int c =0;
        for (int i = 0; i < 32; i++) {
            if (((j>>>i)& 1)==1){
                c++;
            }
        }
        return c;
    }



}
