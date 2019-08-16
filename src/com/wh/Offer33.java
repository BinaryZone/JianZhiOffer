package com.wh;

public class Offer33 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
			return false;
		}
        return helper(sequence, 0, sequence.length-1);
    }
    private static boolean helper(int [] sequence,int start,int end) {
    	// 注意此处写==可能产生数组越界
    	if (start >= end) {
			return true;
		}
		int root = sequence[end];
		int index = start;
		while(index < end && sequence[index] < root) {
			index++;
		}
		for(int i = index;i < end;i++) {
			if (sequence[i] < root) {
				return false;
			}
		}
		return helper(sequence, start, index-1) && helper(sequence, index, end-1);
	}
}
