package com.wh;

import java.util.Stack;

// ���ø���ջ
public class Offer09 {
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    	if (stack2.isEmpty()) {
    		if (stack1.empty()) {
                throw new RuntimeException("����Ϊ�գ�");
    		}else {
				while(!stack1.isEmpty()) {
					stack2.push(stack1.pop());
				}
			}
			return stack2.pop();
		}else {
			return stack2.pop();
		}
    }
}
