package com.wh;

public class Offer62 {
	//1.约瑟夫环问题，实现循环链表
	public int LastRemaining_Solution1(int n, int m) {
        if (n <= 0 || m <= 0) {
			return -1;
		}
        ListNode head = new ListNode(0);
        ListNode pre = head;
        for(int i = 1;i < n;i++) {
        	ListNode temp = new ListNode(i);
        	pre.next = temp;
        	pre = temp;
        }
        pre.next = head;
        ListNode temp2 = head;
        while(n != 1) {
        	for(int j = 0;j < m-2;j++) {
        		temp2 = temp2.next;
        	}
        	temp2.next = temp2.next.next;
        	temp2 = temp2.next;
        	n--;
        }
        return temp2.val;
    }
	// 2.推出递归公式 ???
	public int LastRemaining_Solution2(int n, int m) {
		if (n <= 0 || m <= 0) {
			return -1;
		}
		int result = 0;
		for(int i = 2;i <= n;i++) {
			result = (result + m) % i;
		}
		return result;
	}
}
