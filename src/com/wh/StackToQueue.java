package com.wh;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @author DELL
 *
 */
public class StackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    	if (stack1.empty() && stack2.empty()) {
			throw new RuntimeException("Queue is empty!");
		}
    	if (stack2.empty()) {
			while(!stack1.isEmpty()) {
    		stack2.push(stack1.pop());
    	}
		}
    	
    	return stack2.pop();
    }
}
