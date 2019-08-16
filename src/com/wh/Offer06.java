package com.wh;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * ����һ������������ֵ��β��ͷ��˳�򷵻�һ��ArrayList��
 * @author DELL
 *
 */
public class Offer06 {
	// �ݹ�
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
    	ArrayList<Integer> arrayList = new ArrayList<>();
    	return help(listNode, arrayList);
    }
    public ArrayList<Integer> help(ListNode listNode,ArrayList<Integer> arrayList) {
    	if (listNode != null) {
			help(listNode.next, arrayList);
			arrayList.add(listNode.val);
		}
    	return arrayList;
    }
    
    // ����ջ
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
    	ArrayList<Integer> arrayList = new ArrayList<>();
    	Deque<ListNode> stack = new LinkedList<>();
    	while(listNode != null) {
    		stack.push(listNode);
    		listNode = listNode.next;
    	}
    	while(!stack.isEmpty()) {
    		arrayList.add(stack.pop().val);
    	}
    	return arrayList;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //����ջ�ĺ���ȳ�ԭ��
		//1.������ջ
		Deque<Integer> stack = new LinkedList<>();
		//2.�������е����ݴ���ջ��
		do {
			stack.push(listNode.val);
			listNode = listNode.next;
		} while (listNode!=null);
		//3.����ArrayList����ջ��Ԫ��ȡ������ArrayList
		ArrayList<Integer> list = new ArrayList<>();
		while(!stack.isEmpty()) {
			list.add(stack.pop());
		}
		//4.����ArrayList
		return list;
    }
	//���õݹ�ԭ��
	ArrayList<Integer> list1 = new ArrayList<>();
	public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        //�ݹ�ͷ
		if (listNode!=null) {
			printListFromTailToHead1(listNode.next);//�ݹ���
			list1.add(listNode.val);
		}
		return list1;
    }
	
}

