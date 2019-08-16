package com.wh;

public class Offer36 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
			return null;
		}
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
			return pRootOfTree;
		}
        // 返回左子树链表的头节点
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode p = left;
        // 寻找左子树链表的尾节点
        while(p != null && p.right != null) {
        	p = p.right;
        }
        // 将根结点加入左子树链表
        if (p != null) {
			p.right = pRootOfTree;
			pRootOfTree.left = p;
		}
        // 返回右子树链表的头节点
        TreeNode right = Convert(pRootOfTree.right);
        // 如果右子树不为空，将其加入根结点
        if (right != null) {
			pRootOfTree.right = right;
			right.left = pRootOfTree;
		}
        return left == null?pRootOfTree:left;
    }
}
