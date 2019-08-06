package com.newcoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Offer32_2 {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
			return result;
		}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        TreeNode node;
        int len;
        while(!queue.isEmpty()) {
        	len = queue.size();
        	ArrayList<Integer> arrayList = new ArrayList<>();
        	for(int i = 0;i < len;i++) {
        		node = queue.poll();
        		arrayList.add(node.val);
        		if (node.left != null) {
					queue.add(node.left);
				}
        		if (node.right != null) {
					queue.add(node.right);
				}
        	}
        	result.add(arrayList);
        }
        return result;
    }
}
