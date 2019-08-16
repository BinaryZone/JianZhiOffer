package com.wh;

import java.util.ArrayList;
import java.util.Arrays;

public class Offer42 {
	// 1.���ö�̬�滮����⡣д������ʽ���ݹ����������ʵ�֡�
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
