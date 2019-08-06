package com.newcoder;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Offer32_3 {
	// “之”字打印
	public static void levelOrder2(TreeNode root) {
		if (root == null) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		Deque<Integer> stack = new LinkedList<>();
		queue.add(root);
		TreeNode curNode;
		int curCount = 0;
		int nextCount = 1;
		boolean flag = false;
		while(!queue.isEmpty()) {
			curCount = nextCount;
			nextCount = 0;
			for(int i = 0;i < curCount;i++) {
				curNode = queue.poll();
				if (!flag) {
					System.out.print(curNode.val +" ");
				}else {
					stack.push(curNode.val);
				}
				if (curNode.left != null) {
					queue.add(curNode.left);
					nextCount++;
				}
				if (curNode.right != null) {
					queue.add(curNode.right);
					nextCount++;
				}
			}
			while(!stack.isEmpty()) {
				System.out.print(stack.pop() + " ");
			}
			flag = !flag;
			System.out.println();
		}
	}
	public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		if (pRoot== null) {
			return arr;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		Deque<Integer> stack = new LinkedList<>();
		queue.add(pRoot);
		TreeNode curNode;
		int curCount = 0;
		int nextCount = 1;
		boolean flag = false;
		while(!queue.isEmpty()) {
			curCount = nextCount;
			nextCount = 0;
			ArrayList<Integer> arr1 = new ArrayList<>();
			for(int i = 0;i < curCount;i++) {
				curNode = queue.poll();
				if (!flag) {
					arr1.add(curNode.val);
				}else {
					stack.push(curNode.val);
				}
				if (curNode.left != null) {
					queue.add(curNode.left);
					nextCount++;
				}
				if (curNode.right != null) {
					queue.add(curNode.right);
					nextCount++;
				}
			}
			while(!stack.isEmpty()) {
				arr1.add(stack.pop());
			}
			arr.add(arr1);
			flag = !flag;
			System.out.println();
		}
		return arr;
    }
	// 两个栈来实现
	public ArrayList<ArrayList<Integer> > Print1(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		if (pRoot== null) {
			return arr;
		}
		Deque<TreeNode> stack1 = new LinkedList<>();
		Deque<TreeNode> stack2 = new LinkedList<>();
		stack1.push(pRoot);
		TreeNode node;
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			ArrayList<Integer> arr1 = new ArrayList<>();
			while(!stack1.isEmpty()) {
				node = stack1.pop();
				arr1.add(node.val);
				if (node.left != null) {
					stack2.push(node.left);
				}
				if (node.right != null) {
					stack2.push(node.right);
				}
			}
			if (!arr1.isEmpty()) {
				arr.add(arr1);
			}
			
			ArrayList<Integer> arr2 = new ArrayList<>();
			while(!stack2.isEmpty()) {
				node = stack2.pop();
				arr2.add(node.val);
				if (node.right != null) {
					stack1.push(node.right);
				}
				if (node.left != null) {
					stack1.push(node.left);
				}
			}
			if (!arr2.isEmpty()) {
				arr.add(arr2);
			}
			
		}
		return arr;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(6);
		TreeNode node6 = new TreeNode(7);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		levelOrder2(root);
	}
}
