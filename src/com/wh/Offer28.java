package com.wh;

import java.awt.Robot;

public class Offer28 {
	boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null) {
			return true;
		}
        return check(pRoot.left, pRoot.right);
    }
	boolean check(TreeNode left,TreeNode right) {
		if (left == null) {
			return right == null;
		}
		if (right == null) {
			return false;
		}
		if (left.val != right.val) {
			return false;
		}
		return check(left.left, right.right) && check(left.right, right.left);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    boolean isSymmetrical1(TreeNode pRoot)
    {
        if (pRoot == null) {
			return false;
		}
        return helper(pRoot.left, pRoot.right);
    }
    boolean helper(TreeNode left,TreeNode right) {
    	if (left == null) {
			return right == null;
		}
    	if (right == null) {
			return false;
		}
    	if (left.val != right.val) {
			return false;
		}
    	return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
