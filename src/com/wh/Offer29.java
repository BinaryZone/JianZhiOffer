package com.wh;

import java.util.ArrayList;

public class Offer29 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
    	ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
			return list;
		}
        int start = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        // ȷ����ʼ��
        while(2*start < rows && 2*start < cols) {
        	printCircle(matrix,list,start);
        	start++;
        }
        return list;
    }
    private static void printCircle(int[][] matrix,ArrayList<Integer> list,int start) {
    	int rEnd = matrix.length - start - 1;
    	int cEnd = matrix[0].length - start - 1;
    	// ��ӡ��һ��
		for(int i = start;i <= cEnd;i++) {
			list.add(matrix[start][i]);
		}
		// ��ӡ���һ��
		if (rEnd > start) {
			for(int i = start+1;i <= rEnd;i++) {
				list.add(matrix[i][cEnd]);
			}
		}
		// ��ӡ���һ��
		if (cEnd > start && rEnd > start) {
			for(int i = cEnd-1;i >= start;i--) {
				list.add(matrix[rEnd][i]);
			}
		}
		// ��ӡ��һ��
		if (rEnd - start > 1 && cEnd > start) {
			for(int i = rEnd-1;i > start;i--) {
				list.add(matrix[i][start]);
			}
		}
	}
}
