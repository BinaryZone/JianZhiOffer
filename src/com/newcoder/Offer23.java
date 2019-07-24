package com.newcoder;

public class Offer23 {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode fastNode = pHead;
        ListNode slowNode = pHead;
        while(fastNode != null && fastNode.next != null) {
        	fastNode = fastNode.next.next;
        	slowNode = slowNode.next;
        	if (fastNode == slowNode) {
				while(pHead != fastNode) {
					pHead = pHead.next;
					fastNode = fastNode.next;
				}
				return fastNode;
			}
        }
        return null;
    }
}
