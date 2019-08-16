package com.wh;

public class Offer56_2 {
	public static int findNumberAppearingOnce(int[] arr) {
		if (arr == null || arr.length == 0) {
			throw new RuntimeException("∑«∑® ‰»Î");
		}
		int[] bitNum = new int[32];
		for(int i = 0;i < arr.length;i++) {
			int bit = 1;
			for(int j = 31;j >= 0;j--) {
				int m = bit&arr[i];
				if (m != 0) {
					bitNum[j] += 1;
				}
				bit  = bit << 1;
			}
		}
		int result = 0;
		for(int i = 0;i < 32;i++) {
			result = result<<1;
			result += (bitNum[i]%3);			
		}
		return result;
	}
	public static void main(String[] args) {
		int[] arr = {1,1,1,2,3,3,3};
		System.out.println(findNumberAppearingOnce(arr));
	}
}
