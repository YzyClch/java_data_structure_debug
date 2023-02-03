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
