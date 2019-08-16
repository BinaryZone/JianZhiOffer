package com.wh;
/**
 * ���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
 * @author DELL
 *
 */
public class ListMerge {
	//�ݹ�
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
    
    public ListNode Merge1(ListNode list1,ListNode list2) {
        if (list1 == null && list2 == null) {
			return null;
		}
        if (list1 == null) {
			return list2;
		}
        if (list2 == null) {
			return list1;
		}
        ListNode head;
        ListNode node1 = list1;
        ListNode node2 = list2;
        if (list1.val < list2.val) {
			head = list1;
			node1 = node1.next;
		}else {
			head = list2;
			node2 = node2.next;
		}
        ListNode temp = head;
        while(node1 != null && node2 != null) {
        	if (node1.val < node2.val) {
				temp.next = node1;
				node1 = node1.next;
			}else {
				temp.next = node2;
				node2 = node2.next;
			}
        	temp = temp.next;
        }
        return head;
    }
    public ListNode Merge2(ListNode list1,ListNode list2) {
    	ListNode preHead = new ListNode(-1);
    	ListNode prev = preHead;
    	while(list1 != null && list2 != null) {
    		if (list1.val < list2.val) {
				prev.next = list1;
				list1 = list1.next;
			}else {
				prev.next = list2;
				list2 = list2.next;
			}
    		prev = prev.next;
    	}
    	prev.next = list1 == null?list2:list1;
    	return preHead.next;
    }
}
