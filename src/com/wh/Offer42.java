package com.wh;

import java.util.ArrayList;
import java.util.Arrays;

public class Offer42 {
	// 1.利用动态规划来理解。写出递推式，递归分析，反向实现。
	public int FindGreatestSumOfSubArray1(int[] array) {
        if (array == null || array.length == 0) {
			return 0;
		}
        int addSum = array[0];
        int maxSum = array[0];
        for(int i = 1;i < array.length;i++) {
        	if (addSum >= 0) {
				addSum += array[i]; 
			}else {
				addSum = array[i];
			}
        	if (addSum > maxSum) {
				maxSum = addSum;
			}
        }
        return maxSum;
    }
}
