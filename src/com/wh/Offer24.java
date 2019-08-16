package com.wh;
/**
 * ����һ��������ת��������������ı�ͷ��
 * @author DELL
 *
 */
public class Offer24 {
	// �ݹ�
    public ListNode ReverseList1(ListNode head) {
    	if (head == null || head.next == null) {
			return head;
		}
    	ListNode node = ReverseList1(head.next);
    	head.next.next = head;
    	head.next = null;
    	return node;
	}
    // ˫ָ��
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
