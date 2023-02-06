package com.yzy.leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MathTest {



    public List<String> fizzBuzz(int n) {
        ArrayList<String> r = new ArrayList<>();
        for (int i = 1; i < n+1; i++) {
            if (i %3==0 && i%5==0){
                r.add("FizzBuzz");
            }else if (i %3==0){
                r.add("Fizz");

            }else if(i %5==0){
                r.add("Buzz");
            }else {
                r.add(Integer.toString(i));
            }
        }
        return r;
    }

    public int romanToInt(String s) {


        int pre = 0, cur;
        int sum = 0;
        int size = s.length();
        for(int i = 0; i < size; i++) {
            switch(s.charAt(i)) {
                case 'I': cur = 1;    sum += cur; pre = cur; break;
                case 'V': cur = 5;    sum += cur - (pre == 1 ? 2 : 0); pre = cur; break;
                case 'X': cur = 10;   sum += cur - (pre == 1 ? 2 : 0); pre = cur; break;
                case 'L': cur = 50;   sum += cur - (pre == 10 ? 20 : 0); pre = cur; break;
                case 'C': cur = 100;  sum += cur - (pre == 10 ? 20 : 0); pre = cur; break;
                case 'D': cur = 500;  sum += cur - (pre == 100 ? 200 : 0); pre = cur; break;
                case 'M': cur = 1000; sum += cur - (pre == 100 ? 200 : 0); pre = cur; break;
                default: break;
            }
        }
        return sum;
    }


    public boolean isPowerOfThree(int n) {
       return n >0 && 1162261467 % n == 0;
    }


    @Test
    public void testisPowerOfThree(){
        System.out.println(isPowerOfThree(0));
    }



    @Test
    public void testromanToInt(){
        System.out.println(romanToInt("VI"));
    }

    public int countPrimes(int n) {
        boolean[] arr = new boolean[n];
        int c=0;
        for (int i = 1; i < n-1; i++) {
            if (arr[i]){
                continue;
            }
            c++;
            for (int j = i; j <n-1; j+=i+1) {
                arr[j]=true;
            }
        }
        return c;
    }

    @Test
    public void testcountPrimes(){
        System.out.println(countPrimes(9));

    }



    @Test
    public void testfizzBuzz(){
        System.out.println(fizzBuzz(3));
    }
}
