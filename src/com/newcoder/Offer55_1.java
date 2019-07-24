package com.newcoder;

public class Offer55_1 {
	public boolean IsBalanced_Solution(TreeNode1 root) {
        return TreeDepth1(root) != -1;
    }
	public int TreeDepth1(TreeNode1 root) {
		if (root == null) {
			return 0;
		}
        int left = TreeDepth1(root.left);
        if (left == -1) {
			return -1;
		}
        int right = TreeDepth1(root.right);
        if (right == -1) {
			return -1;
		}
        return Math.abs(left-right)>1 ? -1:Math.max(left, right) + 1;
	}
}
