package com.newcoder;

import javax.xml.soap.Node;

public class Offer08 {
	// 1.存在右子树，下一个节点为右子树中最左节点
	// 2.没有右子树，如果节点是它父节点的左子节点，则下一个节点为父节点
	// 			  如果节点是它父节点的右子节点，向上遍历，直到找到一个是它父节点左子节点的节点。
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
	// 简化代码
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