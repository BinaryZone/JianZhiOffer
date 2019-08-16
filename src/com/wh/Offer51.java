package com.wh;

import java.util.Arrays;

public class Offer51 {
	public static int InversePairs(int [] array) {
        if (array == null || array.length == 0) {
			return 0;
		}
        int low = 0;
        int high = array.length - 1;
        int[] copy = new int[array.length];
        for(int i = 0;i < copy.length;i++) {
        	copy[i] = array[i];
        }
        return InversePairsCore(array,copy, low, high);
    }
	public static int InversePairsCore(int [] array,int[] copy,int low,int high) {
		if (low == high) {
			return 0;
		}
		int mid = (low + high)>>1;
		int leftCount = InversePairsCore(array,copy ,low, mid)%1000000007;
		int rightCount = InversePairsCore(array,copy, mid+1, high)%1000000007;
		int count = 0;
		int i = mid;
		int j = high;
		int k = high;
		while(i >= low && j >mid) {
			if (array[i] > array[j]) {
				count += (j-mid);
				copy[k--] = array[i--];
				if (count>=1000000007) {
					count%=1000000007;
				}
			}else {
				copy[k--] = array[j--];
			}
		}
		while(i >= low) {
			copy[k--] = array[i--];
		}
		while(j > mid) {
			copy[k--] = array[j--];
		}
		for(int m = low;m <= high;m++) {
			array[m] = copy[m];
		}
		return (count + leftCount + rightCount)%1000000007;
	}
	public static void main(String[] args) {
		int[] arr = {7,5,6,4};
		System.out.println(InversePairs(arr));
		System.out.println(Arrays.toString(arr));
	}
}
