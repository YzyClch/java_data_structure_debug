package com.yzy.leecode;

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


    public int rob(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int[] count = new int[nums.length];
        count[0]=nums[0];
        count[1]=Math.max(nums[0],nums[1]);
        int max=count[1];
        for (int i = 2; i < nums.length; i++) {
            count[i] = Math.max(max,count[i-2]+nums[i]);
            max=Math.max(count[i],max);
        }
        return max;

    }


    @Test
    public void testrob(){
        System.out.println(rob(new int[]{1,3,1,3,100}));
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
