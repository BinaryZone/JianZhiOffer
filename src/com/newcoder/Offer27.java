package com.newcoder;

public class Offer27 {
	// ��һ�Ŷ������ľ���
	public void Mirror(TreeNode root) {
		if (root == null || root.left == null && root.right == null) {
			return;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		Mirror(root.left);
		Mirror(root.right);
	}
}
