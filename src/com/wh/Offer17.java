package com.wh;

// 大数问题不能直接使用int或者long，可能会爆内存
public class Offer17 {
	public static void print1ToMaxOfNDigits(int n) {
		char[] nums = new char[n];
		for(int i = 0;i < n;i++) {
			nums[i] = '0';
		}
		while(!increment(nums)) {
			printNum(nums);
		}
	}
	private static boolean increment(char[] nums) {
		// 进位
		int takeOver = 0;
		for(int i = nums.length - 1;i >= 0;i--) {
			int num = nums[i] - '0' + takeOver;
			if (i == nums.length - 1) {
				num++;
			}
			if (num >= 10) {
				if (i == 0) {
					return true;
				}
				takeOver = 1;
				num -= 10;
				nums[i] = (char)(num+'0');
			}else {
				nums[i] = (char)(num+'0');
				break;
			}
		}
		return false;
	}
	private static void printNum(char[] nums) { 
		boolean flag = false;
		for(int i = 0;i < nums.length;i++) {
			if (nums[i] != '0' && !flag) {
				flag = true;
			}
			if (flag) {
				System.out.print(nums[i]);
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		print1ToMaxOfNDigits(2);
	}
}
