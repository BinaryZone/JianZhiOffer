package com.wh;

public class Offer22 {
    public ListNode FindKthToTail(ListNode head,int k) {
    	if (head == null || k <= 0) {
			return null;
		}
    	ListNode preHead = head;
    	ListNode curHead = head;
    	for(int i = 0;i < k - 1;i++) {
    		curHead = curHead.next;
    	}
    	if (curHead == null) {
			return null;
		}
    	while(curHead.next != null) {
    		preHead = preHead.next;
    		curHead = curHead.next;
    	}
    	return preHead;
    }
}
