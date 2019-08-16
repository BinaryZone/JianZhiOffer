package com.wh;

public class Offer53_2 {
	public static int GetMissingNumber(int[] numbers) {
		if (numbers == null || numbers.length == 0) {
			return -1;
		}
		int low = 0;
		int high = numbers.length - 1;
		return GetMissingNumber(numbers, low, high);
	}
	public static int GetMissingNumber(int[] numbers,int low,int high) {
		if (low > high) {
			return -1;
		}
		int mid = (low + high)>>1;
		if (numbers[mid] == mid) {
			return GetMissingNumber(numbers, mid+1, high);
		}else if (mid-1>=0 && numbers[mid-1] != mid-1) {
			return GetMissingNumber(numbers, low, mid-1);
		}else {
			return mid;
		}
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		System.out.println(GetMissingNumber(arr));
	}
}
