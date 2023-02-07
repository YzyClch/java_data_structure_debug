package com.yzy.leecode;

import org.junit.Test;

public class OtherTest {




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
