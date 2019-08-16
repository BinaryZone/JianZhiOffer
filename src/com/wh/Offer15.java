package com.wh;

public class Offer15 {
	// 普通方法
	public int NumberOf1(int n) {
		int flag = 1;
		int count = 0;
		while(flag != 0) {
			if ((n & flag) != 0) {
				count++;
			}
			flag = (flag << 1);
		}
		return count;
	}
	// 巧妙方法
	public int NumberOf11(int n) {
		int count = 0;
		while(n!=0) {
			count++;
			n = n & (n-1);
		}
		return count;
	}
}
