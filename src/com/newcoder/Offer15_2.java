package com.newcoder;

public class Offer15_2 {
	public static int mAndN(int m,int n) {
		int i = m^n;
		int count = 0;
		while(i!=0) {
			count++;
			i = (i&(i-1));
		}
		return count;
	}
	public static void main(String[] args) {
		System.out.println(mAndN(10, 13));
	}
}
