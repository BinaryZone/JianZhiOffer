package com.newcoder;

import java.util.Arrays;

public class Offer14 {
	// 动态规划
	public static int maxProductAfterCutting2(int len) {
		if (len < 2) {
			return 0;
		}
		if (len == 2) {
			return 2;
		}
		if (len == 3) {
			return 2;
		}
		int[] maxProduct = new int[len+1];
		maxProduct[0] = 0;
		maxProduct[1] = 1;
		maxProduct[2] = 2;
		maxProduct[3] = 3;
		for(int i = 4;i <= len;i++) {
			int max = 0;
			for(int j = 1;j <= i/2;j++) {
				if (maxProduct[j]*maxProduct[i-j] > max) {
					max = maxProduct[j]*maxProduct[i-j];
				}
			}
			maxProduct[i] = max;
		}
		return maxProduct[len];
	}
	
	public static void main(String[] args) {
		System.out.println(maxProductAfterCutting1(12));
	}
	
	

	
	
	//贪心算法
	public static int maxProductAfterCutting1(int len) {
		if (len < 2) {
			return 0;
		}
		if (len == 2) {
			return 1;
		}
		if(len == 3) {
			return 2;
		}
		int timeof3 = len/3;
		if (len - timeof3*3 == 1) {
			timeof3--;
		}
		int timeof2 = (len-timeof3*3)/2;
		return (int) (Math.pow(3, timeof3)*Math.pow(2, timeof2));
	}
}
