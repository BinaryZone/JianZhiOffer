package com.wh;

import java.util.Deque;
import java.util.LinkedList;

// ÀûÓÃ¸¨ÖúÕ»
public class Offer30 {
	Deque<Integer> stack_data = new LinkedList<>();
	Deque<Integer> stack_min = new LinkedList<>();
	public void push(int node) {
		stack_data.push(node);
        if (stack_min.isEmpty() || stack_min.peek() > node) {
        	stack_min.push(node);
		}else {
			stack_min.push(stack_min.peek());
		}
    }
    
    public void pop() {
        if (!stack_data.isEmpty()) {
			stack_data.pop();
			stack_min.pop();
		}
    }
    
    public int top() {
        return stack_data.peek();
    }
    
    public int min() {
        return stack_min.peek();
    }
}
