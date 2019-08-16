package com.wh;

public class Offer15_1 {
	public static int mAndN(int n) {
		int count = 0;
		while(n!=0) {
			count++;
			n = (n&(n-1));
		}
		return count;
	}
}
