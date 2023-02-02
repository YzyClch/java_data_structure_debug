package com.yzy.test;

import java.util.HashSet;
import java.util.Random;

public class Solution {


    int [] nums;
    Random random=new Random();

    public Solution(int[] nums) {
        this.nums=nums;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] a = nums.clone();
        Random random = new Random();
        for(int i = 0; i < nums.length; i++) {
            int j = random.nextInt(i+1);
            if(i != j) {
                a[i] ^= a[j];
                a[j] ^= a[i];
                a[i] ^= a[j];
            }
        }
        return a;

    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2, 3});
        for (int i : solution.shuffle()) {
            System.out.println(i);
        }
        System.out.println("++++");
        for (int i : solution.reset()) {
            System.out.println(i);
        }
        System.out.println("++++");
        for (int i : solution.shuffle()) {
            System.out.println(i);
        }
    }


}

