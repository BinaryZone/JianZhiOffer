package com.newcoder;

import javax.xml.soap.Node;

public class Offer08 {
	// 1.��������������һ���ڵ�Ϊ������������ڵ�
	// 2.û��������������ڵ��������ڵ�����ӽڵ㣬����һ���ڵ�Ϊ���ڵ�
	// 			  ����ڵ��������ڵ�����ӽڵ㣬���ϱ�����ֱ���ҵ�һ���������ڵ����ӽڵ�Ľڵ㡣
	public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode.right != null) {
			TreeLinkNode rightNode = pNode.right;
			while(rightNode.left != null) {
				rightNode = rightNode.left;
			}
			return rightNode;
		}else if (pNode.next != null && pNode.next.left != null 
				&& pNode == pNode.next.left) {
			return pNode.next;
		}else if (pNode.next != null && pNode.next.right != null 
				&& pNode == pNode.next.right) {
			TreeLinkNode fNode = pNode.next;
			while(fNode.next != null && fNode.next.right == fNode) {
				fNode = fNode.next;
			}
			if (fNode.next != null) {
				return fNode.next;
			}else {
				return null;
			}
		}
        return null;
    }
	// �򻯴���
	public TreeLinkNode GetNext1(TreeLinkNode pNode)
    {
        if (pNode.right != null) {
			TreeLinkNode rightNode = pNode.right;
			while(rightNode.left != null) {
				rightNode = rightNode.left;
			}
			return rightNode;
		}
        while(pNode.next != null) {
        	if (pNode.next.left == pNode) {
				return pNode.next;
			}
        	pNode = pNode.next;
        }
        return null;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}