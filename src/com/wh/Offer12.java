package com.wh;

public class Offer12 {
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		boolean[] flag = new boolean[matrix.length];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				// 此处为何要加if？？？
				if (hasPath(matrix, flag, i, j, rows, cols, str, 0)) {
					return true;
				}
			}
		}
		return false;
	}
	public static boolean hasPath(char[] matrix,boolean[] flag,int i,int j,int rows, int cols, char[] str,int k) {
		int index = i*cols + j;
		// 递归头
		if (i<0 || j<0 || i >= rows || j >= cols || matrix[index] != str[k] || flag[index] == true) {
			return false;
		}
		if (k == str.length - 1) {
			return true;
		}
		flag[index] = true;		
		if (hasPath(matrix, flag, i-1, j, rows, cols, str, k+1) || 
				hasPath(matrix, flag, i+1, j, rows, cols, str, k+1) || 
				hasPath(matrix, flag, i, j-1, rows, cols, str, k+1) || 
				hasPath(matrix, flag, i, j+1, rows, cols, str, k+1)) {
			return true;
		}
		flag[index] = false;
		return false;
	}
}
