package com.wh;

public class Offer18_1 {
	public ListNode deleteNode(ListNode head,ListNode pToBeDeleted) {
		if (head == null || pToBeDeleted == null) {
			return head;
		}
		// 删除的不是尾节点
		if (pToBeDeleted.next != null) {
			ListNode pNext = pToBeDeleted.next;
			pToBeDeleted.val = pNext.val;
			pToBeDeleted.next = pNext.next;
			pNext = null;
		// 删除的是尾节点并且原链表只有一个节点
		}else if (head == pToBeDeleted) {
			pToBeDeleted = null;
			head = null;
		// 删除的是尾节点并且原链表有多个节点
		}else {
			ListNode node = head;
			while(node.next != pToBeDeleted) {
				node = node.next;
			}
			node.next = null;
			pToBeDeleted = null;
		}
		return head;
	}
}
