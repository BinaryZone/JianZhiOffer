package com.wh;

import java.util.ArrayList;

public class Offer66 {
	public int[] multiply(int[] A) {
		if (A == null) {
			return null;
		}
		int len = A.length;
		int[] B = new int[len];
		if (len > 0) {
			B[0] = 1;
			for(int i = 1;i < len;i++) {
				B[i] = B[i-1] * A[i-1];
			}
			int temp = 1;
			for(int j = len-2;j >= 0;j--) {
				temp *= A[j+1];
				B[j] = temp * B[j];
			}
		}
		return B;
    }
}
