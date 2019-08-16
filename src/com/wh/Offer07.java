package com.wh;
/**
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
 * @author DELL
 *
 */
public class Offer07 {
	public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		if (pre == null || in == null || pre.length <= 0 || in.length <= 0 || pre.length != in.length) {
			return null;
		}
		return reConstructBinaryTree(pre, in, 0, pre.length-1, 0, in.length-1);
    }
	public static TreeNode reConstructBinaryTree(int [] pre,int [] in,int pStart,int pEnd,int iStart,int iEnd) {
		TreeNode root = new TreeNode(pre[pStart]);
		if (pStart == pEnd && iStart == iEnd) {
			if (pre[pStart] != in[iStart])
                throw new RuntimeException("���鲻���Ϲ淶��");
			return root;
		}
		int index = iStart;
		while(index <= iEnd && in[index] != root.val ) {
			index++;
		}
//		System.out.print(index + " ");
//		System.out.println(iEnd);
		if (index > iEnd)
            throw new RuntimeException("���鲻���Ϲ淶��");
		int leftLength = index - iStart;
//		System.out.println(leftLength);
		if (leftLength > 0) {
			root.left = reConstructBinaryTree(pre, in, pStart+1, pStart+leftLength, iStart, index-1);
		}
		if (iEnd - iStart - leftLength > 0) {
			root.right = reConstructBinaryTree(pre, in, pStart+leftLength+1, pEnd, index+1, iEnd);
		}
		return root;
	}
	public static void preTraverse(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		preTraverse(root.left);
		preTraverse(root.right);
	}
	public static void inTraverse(TreeNode root) {
		if (root == null) {
			return;
		}
		inTraverse(root.left);
		System.out.print(root.val + " ");
		inTraverse(root.right);
	}
	public static void main(String[] args) {
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
		TreeNode root = reConstructBinaryTree(pre, in);
		preTraverse(root);
		System.out.println();
		inTraverse(root);
	}
}


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
 }