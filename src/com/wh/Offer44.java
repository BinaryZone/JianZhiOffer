package com.wh;

public class Offer44 {
	// 找数学规律
	public static int offer(int n) {
		if (n < 0) {
			return -1;
		}
		if (n >= 0 && n < 10) {
			return n;
		}
		for(int i = 2;i <= n;i++) {
			if ((10 + i * 9 * Math.pow(10, i-1)) >= n) {
				if (i == 2) {
					int m = n - 10;
					int a = (m-1) / i;
					int b = m % i;
					return (int) (((Math.pow(10, i-1) + a)/Math.pow(10, i-b-1))%10);
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		System.out.println(offer(17));
	}
}
