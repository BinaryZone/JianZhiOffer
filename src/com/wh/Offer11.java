package com.wh;

public class Offer11 {
	public int minNumberInRotateArray(int [] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int left = 0;
		int right = array.length - 1;
		int mid = -1;
		while(array[left] >= array[right]) {
			if (right - left == 1) {
				break;
			}
			mid = (left + right) >> 1;
			if (array[mid] >= array[left]) {
				left = mid;
			}
			if (array[mid] <= array[right]) {
				right = mid;
			}
		}
		return array[right];
	}
}
