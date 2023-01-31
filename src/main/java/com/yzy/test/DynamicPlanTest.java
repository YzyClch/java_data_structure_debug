package com.yzy.test;

import org.junit.Test;

public class DynamicPlanTest {





    public int maxProfit(int[] prices) {

        int min =prices[0];
        int max =0;
        for (int price : prices) {
            if (price < min) {
                min = price;
                continue;
            }
            int l = price - min;
            max = Math.max(l, max);

        }
        return max;
    }

    @Test
    public void testmaxProfit(){
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }


    public int maxSubArray(int[] nums) {

    }
    
    @Test
    public void test(){
    
    }

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
