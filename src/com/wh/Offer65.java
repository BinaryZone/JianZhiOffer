package com.wh;

public class Offer65 {
	public int Add(int num1,int num2) {
		// 不考虑进位相加
        int s1 = num1 ^ num2;
        // 进位
        int s2 = (num1 & num2)<<1;
        int result = s1;
        while(s2 != 0) {
        	result ^= s2;
        	s2 = (s1 & s2)<<1;
        	s1 = result;
        }
        return result;
    }
	// 代码优化
	public int Add1(int num1,int num2) {
		while(num2 != 0) {
			int temp = num1 ^ num2;
			num2 = (num1 & num2)<<1;
			num1 = temp;
		}
		return num1;
    }
}
