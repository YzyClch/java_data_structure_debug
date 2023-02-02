package com.yzy.leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class MinStack {


    List<Integer> list = new ArrayList();


    public MinStack() {

    }

    public void push(int val) {
        list.add(val);
    }

    public void pop() {
        list.remove(list.size()-1);
    }

    public int top() {
        return list.get(list.size()-1);
    }

    public int getMin() {
        Optional<Integer> min = list.stream().filter(Objects::nonNull).min(Integer::compareTo);
        return min.orElse(null);
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }


}
