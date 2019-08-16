package com.wh;

import java.util.ArrayList;

public class Offer34 {
	private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    private ArrayList<Integer> temp = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    	if (root == null) {
			return result;
		}
    	temp.add(root.val);
    	target -= root.val;
    	if (target == 0 && root.left == null && root.right == null) {
			result.add(new ArrayList<>(temp));
		}
    	FindPath(root.left, target);
    	FindPath(root.right, target);
    	temp.remove(temp.size()-1);
    	return result;
    }
}
