package com.wh;
/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39 
 * @author DELL
 *
 */
public class TestFibonacci {
	public int Fibonacci(int n) {
		//确定前两项
		if (n==0) {
			return 0;
		}
		if (n==1) {
			return 1;
		}
		int f = 0;
		if (n>1 && n<=39) {
			f = Fibonacci(n-1) + Fibonacci(n-2);
		}
		
		return f;
    }
	public int Fibonacci01(int n) {
		//确定前两项
		if (n==0) {
			return 0;
		}
		if (n==1) {
			return 1;
		}
		int f = 0;
		int preNum = 1;
		int prepreNum = 0;
		if (n>1 && n<=39) {
			for(int i=1;i<n;i++) {
				f = preNum + prepreNum;
				prepreNum = preNum;
				preNum = f;
			}
		}
		return f;
		
	}
}
