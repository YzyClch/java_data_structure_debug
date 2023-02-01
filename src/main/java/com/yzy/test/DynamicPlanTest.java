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
            int pre= Math.max(nums[0], 0);
            int max =nums[0];
            for (int i = 1; i < nums.length; i++) {
                int d =nums[i]+pre;
                pre=Math.max(d,0);
                max=Math.max(d,max);
            }
            return max;
    }


    
    @Test
    public void testmaxSubArray(){
        System.out.println(maxSubArray(new int[]{3,-2,3}));
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
