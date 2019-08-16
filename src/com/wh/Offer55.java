package com.wh;

import java.util.LinkedList;
import java.util.Queue;

public class Offer55 {
	// 1.利用层序遍历
	public int TreeDepth1(TreeNode1 root) {
        if (root == null) {
			return 0;
		}
        int depth = 0;
        int count = 0;
        // 每层节点数
        int nextcount = 1;
        Queue<TreeNode1> queue1 = new LinkedList<>();
        TreeNode1 node = root;
        queue1.add(node);
        while(queue1.size() != 0) {
    		node = queue1.poll();
    		count++;
    		if (node.left != null) {
				queue1.add(node.left);
			}
        	if (node.right != null) {
				queue1.add(node.right);
			}
        	if (count == nextcount) {
				depth++;
				count = 0;
				nextcount = queue1.size();
			}
        }
        return depth;
    }
	// 2.递归思想
	public int TreeDepth2(TreeNode1 root) {
        if (root == null) {
			return 0;
		}
        int left = TreeDepth1(root.left);
        int right = TreeDepth1(root.right);
        return Math.max(left, right)+1;
	}
	// 3.极简代码
	public int TreeDepth3(TreeNode root) {
		if (root == null) {
			return 0;
		}
        return Math.max(TreeDepth3(root.left), TreeDepth3(root.right))+1;
    }
}

class TreeNode1 {
    int val = 0;
    TreeNode1 left = null;
    TreeNode1 right = null;

    public TreeNode1(int val) {
        this.val = val;
    }

}