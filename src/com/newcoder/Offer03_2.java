package com.newcoder;

public class Offer03_2 {
	public int getDuplication(int[] nums,int length) {
		int start = 1;
		int end = length - 1;
		while(start <= end) {
			int mid = (start + end) >> 1;
			int count = countRange(nums, start, mid);
			if (start == end) {
				if (count > 1) {
					return start;
				}else {
					break;
				}
			}
			if (count > mid - start + 1) {
				end = mid;
			}else {
				start = mid + 1;
			}
		}
		return -1;
	}
	public static int countRange(int[] nums,int start,int end) {
		int count = 0;
		for(int i = 0;i < nums.length;i++) {
			if (nums[i] >= start && nums[i] <= end) {
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		int[] nums = {2,3,5,4,3,2,6,7};
		System.out.println(new Offer03_2().getDuplication(nums, 8));
	}
}
