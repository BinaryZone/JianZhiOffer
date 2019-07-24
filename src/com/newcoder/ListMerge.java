package com.newcoder;
/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @author DELL
 *
 */
public class ListMerge {
	//递归
    public ListNode Merge(ListNode list1,ListNode list2) {
    	if (list1 == null && list2 == null) {
			return null;
		}
        if (list1 == null) {
			return list2;
		}
        if (list2 == null) {
			return list1;
		}
        if (list1.val <= list2.val) {
			list1.next = Merge(list1.next, list2);
			return list1;
		}else {
			list2.next = Merge(list2.next, list1);
			return list2;
		}
    }
}
