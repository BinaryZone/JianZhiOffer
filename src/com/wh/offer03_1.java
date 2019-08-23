package com.wh;

import java.util.Arrays;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * @author DELL
 *
 */
public class Offer03_1 {
	// 哈希表，O(n)时间复杂度，O(n)空间复杂度
	public boolean duplicate(int numbers[],int length,int [] duplication) {
	    boolean[] k = new boolean[length];
	    for(int i=0;i<length;i++) {
	    	if (k[numbers[i]]==true) {
				duplication[0] = numbers[i];
				return true;
			}
	    	k[numbers[i]] = true;
	    }
	    return false;
    }
	// 利用题目条件，所有数字放在对应位置上。
	public boolean duplicate1(int numbers[],int length,int [] duplication) {
		for(int i = 0;i < length;i++) {
			if (numbers[i] != i) {
				if (numbers[numbers[i]] == numbers[i]) {
					duplication[0] = numbers[i];
					return true;
				}
				int temp = numbers[i];
				numbers[i] = numbers[temp];
				numbers[temp] = temp;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[] numbers = {2,1,3,1,4};
		System.out.println(new Offer03_1().duplicate1(numbers, 5, new int[1]));
	}
}
