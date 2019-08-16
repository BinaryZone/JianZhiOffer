package com.wh;

public class Offer36 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
			return null;
		}
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
			return pRootOfTree;
		}
        // ���������������ͷ�ڵ�
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode p = left;
        // Ѱ�������������β�ڵ�
        while(p != null && p.right != null) {
        	p = p.right;
        }
        // ��������������������
        if (p != null) {
			p.right = pRootOfTree;
			pRootOfTree.left = p;
		}
        // ���������������ͷ�ڵ�
        TreeNode right = Convert(pRootOfTree.right);
        // �����������Ϊ�գ������������
        if (right != null) {
			pRootOfTree.right = right;
			right.left = pRootOfTree;
		}
        return left == null?pRootOfTree:left;
    }
}
