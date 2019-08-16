package com.wh;

import java.util.Deque;
import java.util.LinkedList;

public class Offer52 {
	// 1.���ø���ջ
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
	// 2.��ͳ����������ĳ���m��n�����ó�һ�����������|m-n|��,�Ż��˿ռ�Ч��
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    	if (pHead1 == null || pHead2 == null) {
			return null;
		}
    	int l1 = getLength(pHead1);
    	int l2 = getLength(pHead2);
    	int count = Math.abs(l1-l2);
    	if (l1 > l2) {
			while(count > 0) {
				pHead1 = pHead1.next;
				count--;
			}
		}else {
			while(count > 0) {
				pHead2 = pHead2.next;
				count--;
			}
		}
    	while(pHead1 != null && pHead2 != null) {
    		if (pHead1 == pHead2) {
				return pHead1;
			}
    		pHead1 = pHead1.next;
    		pHead2 = pHead2.next;
    	}
    	return null;
    }
}
