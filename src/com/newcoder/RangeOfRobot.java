package com.newcoder;

public class RangeOfRobot {
	public int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] flag = new boolean[rows][cols];
        return movingCount(threshold, 0, 0, rows, cols, flag);
    }
	public static int movingCount(int threshold, int i,int j,int rows, int cols,boolean[][] flag) {
		int index = i*rows + cols;
		//µÝ¹éÍ·
		if (i < 0 || j < 0 || i >= rows || j >= cols || numSum(i) + numSum(j) > threshold || flag[i][j] == true) {
			return 0;
		}
		flag[i][j] = true;
		return movingCount(threshold, i-1, j, rows, cols, flag) + 
				movingCount(threshold, i+1, j, rows, cols, flag) + 
				movingCount(threshold, i, j-1, rows, cols, flag) + 
				movingCount(threshold, i, j+1, rows, cols, flag) + 1;
	}
	public static int numSum(int t) {
		int sum = 0;
		while(t != 0) {
			sum += t%10;
			t /= 10;
		}
		return sum;
	}
}
