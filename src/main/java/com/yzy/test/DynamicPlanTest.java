package com.yzy.test;

import org.junit.Test;

public class DynamicPlanTest {






    public int climbStairs(int n) {
        if (n<=2){
            return n;
        }
       int x=1;
       int y=2;
        for (int i = 2; i < n; i++) {
            if (x<y){
                x=x+y;
            }else {
                y=x+y;
            }
        }
        return Math.max(x,y);
    }

    @Test
    public void testclimbStairs(){
        System.out.println(climbStairs(1));
    }
}
