package com.newcoder;

import java.util.Arrays;
import java.util.HashMap;

public class Offer39 {
	// 1.利用HashMap，时间复杂度O(n)，空间复杂度O(n)
	public int MoreThanHalfNum_Solution1(int [] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<array.length;i++) {
        	if (hm.containsKey(array[i])) {
				hm.put(array[i], hm.get(array[i])+1);
			}else {
				hm.put(array[i], 1);
			}
        }
        for(int j:hm.keySet()) {
        	if (hm.get(j) > (array.length>>1)) {
				return j;
			}
        }
        return -1;
    }
	// 2.利用partion函数找出中位数，检查中位数的频率。时间复杂度O(n)
	public static int MoreThanHalfNum_Solution2(int [] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int middle = array.length >> 1;
		int low = 0;
		int high = array.length - 1;
		int index = partition(array, low, high);
		while (index != middle) {
			if (index < middle) {
				index = partition(array, index+1, high);
			}
			if (index > middle) {
				index = partition(array, low, index-1);
			}
		}
		System.out.println(index);
		System.out.println(array[index]);
		System.out.println(Arrays.toString(array));
		int count = 0;
		for(int i = 0;i < array.length;i++) {
			if (array[i] == array[index]) {
				count++;
			}
		}
		if (count > middle) {
			return array[index];
		}
		return 0;
	}
	// 如果不允许改变数组
	// 
	public static int MoreThanHalfNum_Solution3(int [] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int result = array[0];
		int times = 1;
		for(int i = 1;i < array.length;i++) {
			if (times == 0) {
				result = array[i];
				times = 1;
			}else if (array[i] == result) {
				times++;
			}else {
				times--;
			}
		}
		int count = 0;
		for(int i = 0;i < array.length;i++) {
			if (array[i] == result) {
				count++;
			}
		}
		if (count > array.length >> 1) {
			return result;
		}
		return 0;
	}
	public static int partition(int [] array,int low,int high) {
		int x = array[low];
		int i = low;
		int j = high;
		while(i < j) {
			while(array[j] >= x && i < j) {
				j--;
			}
			if (i < j) {
				array[i] = array[j];
				i++;
			}
			while(array[i] <= x && i < j) {
				i++;
			}
			if (i < j) {
				array[j] = array[i];
				j--;
			}
		}
		array[i] = x;
		return i;
	}
	public static void main(String[] args) {
		int[] arr = {2,2,2,2,2,1,3,4,5};
		System.out.println(MoreThanHalfNum_Solution2(arr));
	}
}
