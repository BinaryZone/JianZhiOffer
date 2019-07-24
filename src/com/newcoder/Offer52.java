package com.newcoder;

import java.util.Deque;
import java.util.LinkedList;

public class Offer52 {
	// 1.利用辅助栈
	public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
		 Deque<ListNode>  stack1 = new LinkedList<>();
		 Deque<ListNode>  stack2 = new LinkedList<>();
		 ListNode node1 = pHead1;
		 ListNode node2 = pHead2;
		 while(node1 != null) {
			 stack1.push(node1);
			 node1 = node1.next;
		 }
		 while(node2 != null) {
			 stack2.push(node2);
			 node2 = node2.next;
		 }
		 ListNode last = null;
		 ListNode node3 = null;
		 ListNode node4 = null;
		 while(!stack1.isEmpty() && !stack2.isEmpty()) {
			 node3 = stack1.pop();
			 node4 = stack2.pop();
			 if (node3 == node4) {
				last = node3;
			}else {
				break;
			}
		 }
		 return last;
    }
	// 2.先统计两个链表的长度m、n，再让长一点的链表先走|m-n|步,优化了空间效率
	public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
		int l1 = getLength(pHead1);
		int l2 = getLength(pHead2);
		ListNode node1 = pHead1;
		ListNode node2 = pHead2;
		int m = l1 - l2;
		if (m > 0) {
			while(m != 0) {
				node1 = node1.next;
				m--;
			}
		}else {
			while(m != 0) {
				node2 = node2.next;
				m++;
			}
		}
		while(node1 != null && node2 != null) {
			if (node1 == node2) {
				break;
			}
			node1 = node1.next;
			node2 = node2.next;
		}
		return node1;
	}
	public static int getLength(ListNode head) {
		int count = 0;
		ListNode node = head;
		while(node != null) {
			count++;
			node = node.next;
		}
		return count;
	}
}
