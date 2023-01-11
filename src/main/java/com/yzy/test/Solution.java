package com.yzy.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

public class Solution {


    public static int[]intersect(int []nums1,int []nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int [] result=new int[Math.min(nums1.length, nums2.length)];
        int x =0;
        int k=0;
        int i = 0;
        while (i != nums2.length && k != nums1.length) {
            int n1 = nums2[i];
            int n2 = nums1[k];
            if (n1 == n2) {
                result[x] = n1;
                x++;
                i++;
                k++;
            } else if (n1 < n2) {
                i++;
            } else {
                k++;
            }
        }
        return Arrays.copyOfRange(result,0,x);
    }

    public  int[] plusOne(int[] digits) {
        for (int i=digits.length-1;i>=0;i--){
            digits[i]++;
            if ((digits[i]=digits[i]%10)!=0){
                return digits;
            }
        }
        int[] ints = new int[digits.length + 1];
        ints[0]=1;
        return ints;
    }


    /**
     * 双指针遍历交换
     * @param nums
     */
    public void moveZeroes3(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    public void moveZeroes2(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    // 0,1,0,3,12
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length -1; i++) {
            if (nums[i]==0){
                // 找到下个不为0的交换位置
                int n=i+1;
                while (n<nums.length-1 && nums[n]==0){
                    n++;
                };
                nums[i]=nums[n];
                nums[n]=0;
            }
        }
    }

    @Test
    public void testMoveZeroes(){
        moveZeroes(new int[]{0,1,0,3,12});
    }

    @Test
    public void testPlusOne(){
        for (int i : plusOne(new int[]{8,9,9,9})) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,3,3};
        int[] nums2 = new int[]{3,5,2,2};
        int[] intersect = intersect(nums1, nums2);
        for (int i : intersect) {
            System.out.println(i);
        }
    }

}
