package com.wh;

public class Offer13 {
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
	
	private static int count = 0;
    public int movingCount1(int threshold, int rows, int cols)
    {
        boolean[][] flag = new boolean[rows][cols];
        help(threshold, rows, cols, 0, 0, flag);
        return count;
    }
    private static void help(int threshold, int rows, int cols,int i,int j,boolean[][] flag) {
    	if (i >= rows || j >= cols) {
			return;
		}
    	int sum = 0;
		int m = i;
		int n = j;
		while(m != 0) {
			sum += m%10;
			m = m/10;
		}
		while(n != 0) {
			sum += n%10;
			n = n/10;
		}
		if (sum > threshold) {
			return;
		}
		if (flag[i][j]) {
			return;
		}
		flag[i][j] = true;
		count++;
    	help(threshold, rows, cols, i+1, j, flag);
		help(threshold, rows, cols, i, j+1, flag);
	}
    public static void main(String[] args) {
		System.out.println(new Offer13().movingCount1(15, 20, 20));
	}
}
