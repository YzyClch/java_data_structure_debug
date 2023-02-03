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
        for (int i = 1; i < n + 1; i++) {
            if (i%)
        }
    }

    @Test
    public void testcountPrimes(){
        System.out.println(countPrimes(10));

    }



    @Test
    public void testfizzBuzz(){
        System.out.println(fizzBuzz(3));
    }
}
