package com.wh;

public class Offer18_1 {
	public ListNode deleteNode(ListNode head,ListNode pToBeDeleted) {
		if (head == null || pToBeDeleted == null) {
			return head;
		}
		// ɾ���Ĳ���β�ڵ�
		if (pToBeDeleted.next != null) {
			ListNode pNext = pToBeDeleted.next;
			pToBeDeleted.val = pNext.val;
			pToBeDeleted.next = pNext.next;
			pNext = null;
		// ɾ������β�ڵ㲢��ԭ����ֻ��һ���ڵ�
		}else if (head == pToBeDeleted) {
			pToBeDeleted = null;
			head = null;
		// ɾ������β�ڵ㲢��ԭ�����ж���ڵ�
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
