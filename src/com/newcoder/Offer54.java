package com.newcoder;

import java.util.Deque;
import java.util.LinkedList;

public class Offer54 {
	// �ǵݹ�ʵ��
	TreeNode KthNode(TreeNode pRoot, int k)
    {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = pRoot;
        int count = 0;
        while(!stack.isEmpty() || node != null) {
        	while(node != null) {
        		stack.push(node);
        		node = node.left;
        	}
        	if(!stack.isEmpty()) {
        		node = stack.pop();
        		count++;
        		if (count == k) {
					return node;
				}
        		node = node.right;
        	}
        }
        return null;
    }
	// �ݹ�ʵ�֣�����
}
