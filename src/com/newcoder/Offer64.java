package com.newcoder;

public class Offer64 {
	public static int Sum_Solution(int n) {
		int sum = n;
		boolean flag = (n > 1) && (sum += Sum_Solution(n - 1))>0;
//        if (n >= 1) {
//			return Sum_Solution(n-1) + n;
//		}
        return sum;
    }
	public static void main(String[] args) {
		System.out.println(Sum_Solution(10));
	}
}
