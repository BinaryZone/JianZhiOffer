package com.wh;

public class Offer35 {
	public static RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null) {
			return null;
		}
        RandomListNode currentNode = pHead;
        while(currentNode != null) {
        	RandomListNode cloneNode = new RandomListNode(currentNode.label);
        	RandomListNode nextNode = currentNode.next;
        	currentNode.next = cloneNode;
        	cloneNode.next = nextNode;
        	currentNode = nextNode;
        }
        RandomListNode currentNode1 = pHead;
        while(currentNode1 != null) {
        	currentNode1.next.random = currentNode1.random == null?null:currentNode1.random.next;
        	currentNode1 = currentNode1.next.next;
        }
        RandomListNode cloneHead = pHead.next;
        RandomListNode currentNode2 = pHead;
        while(currentNode2 != null) {
        	RandomListNode cloneNode = currentNode2.next;
        	currentNode2.next = currentNode2.next.next;
        	cloneNode.next = cloneNode.next == null?null:cloneNode.next.next;
        	currentNode2 = currentNode2.next;
        }
        return cloneHead;
    }
    public static void main(String[] args) {
		RandomListNode head = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		head.next = node2;
		node2.next = node3;
		head.random = node3;
		RandomListNode cloneNode = Clone(head);
		System.out.println(cloneNode.label);
		System.out.println(cloneNode.random.label);
	}
}
