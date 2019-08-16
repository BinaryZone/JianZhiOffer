package com.wh;
/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 * @author DELL
 *
 */
public class Offer24 {
	// 递归
    public ListNode ReverseList1(ListNode head) {
    	if (head == null || head.next == null) {
			return head;
		}
    	ListNode node = ReverseList1(head.next);
    	head.next.next = head;
    	head.next = null;
    	return node;
	}
    // 双指针
    public ListNode ReverseList2(ListNode head) {
    	if (head == null || head.next == null) {
			return head;
		}
    	ListNode preNode = null;
    	ListNode curNode = head;
    	while(curNode != null) {
    		ListNode temp = curNode.next;
    		curNode.next = preNode;
    		preNode = curNode;
    		curNode = temp;
    	}
    	return preNode;
    }
}
