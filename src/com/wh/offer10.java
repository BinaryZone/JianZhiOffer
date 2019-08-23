package com.wh;

public class Offer10 {
	//µÝ¹é
	public static int fibonacci(int n) {
		if (n<=0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}
	//Ñ­»·
	public static int fibonacci1(int n) {
		if (n<=0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int fibNMinusOne = 1;
		int fibNMinusTwo = 0;
		int fibN = 0;
		for(int i=2;i<=n;i++) {
			fibN = fibNMinusOne + fibNMinusTwo;
			fibNMinusTwo = fibNMinusOne;
			fibNMinusOne = fibN;
		}
		return fibN;
	}
	public static void main(String[] args) {
		System.out.println(fibonacci(6));
		System.out.println(fibonacci1(6));
	}
}
