package com.newcoder;

public class Offer15_1 {
	public static boolean test(int n) {
		if (n!=1) {
			return (n&(n-1))==0;
		}else {
			return false;
		}		
	}
	public static void main(String[] args) {
		System.out.println(test(31));
	}
}
