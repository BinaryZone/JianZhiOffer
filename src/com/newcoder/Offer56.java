package com.newcoder;

public class Offer56 {
	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length < 2) {
			return;
		}
        int result = 0;
        for(int i = 0;i < array.length;i++) {
        	result ^= array[i];
        }
        int index = firstIndex(result);
        for(int i = 0;i < array.length;i++) {
        	if (isBit1(array[i], index)) {
				num1[0] ^= array[i];
			}else {
				num2[0] ^= array[i];
			}
        }
    }
	public static int firstIndex(int result) {
		int index = 0;
		while((result&1) == 0) {
			index++;
			result=result>>1;
		}
		return index;
	}
	public static boolean isBit1(int n,int index) {
		while(index != 0) {
			n = n>>1;
			index--;
		}
		if ((n & 1) == 1) {
			return true;
		}else {
			return false;
		}
	}
	public static void main(String[] args) {
		
	}
}
