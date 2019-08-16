package com.wh;

public class Offer15_2 {
	public static boolean test(int n) {
		if (n!=1) {
			return (n&(n-1))==0;
		}else {
			return false;
		}		
	}
}
