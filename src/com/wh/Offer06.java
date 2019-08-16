package com.wh;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * @author DELL
 *
 */
public class Offer06 {
	// 递归
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
    	ArrayList<Integer> arrayList = new ArrayList<>();
    	return help(listNode, arrayList);
    }
    public ArrayList<Integer> help(ListNode listNode,ArrayList<Integer> arrayList) {
    	if (listNode != null) {
			help(listNode.next, arrayList);
			arrayList.add(listNode.val);
		}
    	return arrayList;
    }
    
    // 辅助栈
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
    	ArrayList<Integer> arrayList = new ArrayList<>();
    	Deque<ListNode> stack = new LinkedList<>();
    	while(listNode != null) {
    		stack.push(listNode);
    		listNode = listNode.next;
    	}
    	while(!stack.isEmpty()) {
    		arrayList.add(stack.pop().val);
    	}
    	return arrayList;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //利用栈的后进先出原理
		//1.创建空栈
		Deque<Integer> stack = new LinkedList<>();
		//2.将链表中的数据存入栈中
		do {
			stack.push(listNode.val);
			listNode = listNode.next;
		} while (listNode!=null);
		//3.创建ArrayList并将栈中元素取出存入ArrayList
		ArrayList<Integer> list = new ArrayList<>();
		while(!stack.isEmpty()) {
			list.add(stack.pop());
		}
		//4.返回ArrayList
		return list;
    }
	//利用递归原理
	ArrayList<Integer> list1 = new ArrayList<>();
	public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        //递归头
		if (listNode!=null) {
			printListFromTailToHead1(listNode.next);//递归体
			list1.add(listNode.val);
		}
		return list1;
    }
	
}

