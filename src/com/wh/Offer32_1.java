package com.wh;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Offer32_1 {
    public static ArrayList<Integer> Print(TreeNode pRoot) {
    	ArrayList<Integer> result = new ArrayList<>();
    	if (pRoot == null) {
			return result;
		}
    	Queue<TreeNode> queue = new LinkedList<>();
    	TreeNode node;
    	queue.add(pRoot);
    	while(!queue.isEmpty()) {
    		node = queue.poll();
    		result.add(node.val);
    		if (node.left != null) {
				queue.add(node.left);
			}
    		if (node.right != null) {
				queue.add(node.right);
			}
    	}
    	return result;
    }
    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		System.out.println(Print(root));
	}
}
