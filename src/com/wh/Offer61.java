package com.wh;

import java.util.Arrays;

public class Offer61 {
	public boolean isContinuous(int [] numbers) {
		if (numbers == null || numbers.length == 0) {
			return false;
		}
		Arrays.sort(numbers);
		int zeroNum = 0;
		int gapNum = 0;
		for(int i = 0;i < numbers.length;i++) {
			if (numbers[i] == 0) {
				zeroNum++;
			}
		}
		int index = zeroNum;
		while(index < numbers.length - 1) {
			if (numbers[index] == numbers[index+1]) {
				return false;
			}
			gapNum += numbers[index+1] - numbers[index] - 1;
			index++;
		}
		if (zeroNum >= gapNum) {
			return true;
		}
		return false;
    }
}
