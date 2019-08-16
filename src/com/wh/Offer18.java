package com.wh;

public class Offer18 {
	public ListNode deleteDuplication1(ListNode pHead) {
		if (pHead == null || pHead.next == null) {
			return pHead;
		}
		ListNode preHead = null;
		ListNode curHead = pHead;
		while(curHead != null) {
			if (curHead.next != null && curHead.val == curHead.next.val) {
				int value = curHead.val;
				ListNode tempNode = curHead;
				while(tempNode != null && tempNode.val == value) {
					tempNode = tempNode.next;
				}
				if (curHead == pHead) {
					pHead = tempNode;
				}else {
					preHead.next = tempNode;
				}
				curHead = tempNode;
			}else {
				preHead = curHead;
				curHead = curHead.next;
			}
		}
		return pHead;
	}
	
	
	
	
	
	
	
	
	
	
	
	public ListNode deleteDuplication(ListNode pHead)
    {
		if (pHead == null || pHead.next == null) {
			return pHead;
		}
		ListNode preNode = null;
		ListNode curNode = pHead;
		while(curNode != null) {
			boolean needDel = false;
			if (curNode.next != null && curNode.val == curNode.next.val) {
				needDel = true;
			}
			if (!needDel) {
				preNode = curNode;
				curNode = curNode.next;
			}else {
				int value = curNode.val;
				ListNode toBeDel = curNode;
				while(toBeDel != null && toBeDel.val == value ) {
					toBeDel = toBeDel.next;
				}
				if (preNode == null) {
					pHead = toBeDel;
				}else {
					preNode.next = toBeDel;
				}
				curNode = toBeDel;
			}
		}
		return pHead;
    }
	public static void main(String[] args) {
		
	}
}
