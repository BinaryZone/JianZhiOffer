package com.wh;

import java.util.Deque;
import java.util.LinkedList;

public class Offer31 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int i = 0;
        int j = 0;
        Deque<Integer> stack = new LinkedList<>();
        while(i < pushA.length && j < popA.length) {
        	stack.push(pushA[i]);
        	while (!stack.isEmpty() && j < popA.length && popA[j] == stack.peek()) {
				stack.pop();
				j++;
			}
        	i++;
        }
        return i >= popA.length;
    }
}
