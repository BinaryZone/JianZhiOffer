package com.wh;
/**
 * ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n���0��ʼ����0��Ϊ0����n<=39 
 * @author DELL
 *
 */
public class TestFibonacci {
	public int Fibonacci(int n) {
		//ȷ��ǰ����
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
		//ȷ��ǰ����
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
