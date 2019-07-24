package com.newcoder;

public class Offer16 {
	public static double Power(double base, int exponent) {
		int exponent1;
		double result = 1;
		double cur = base;
		// ����ָ���ĸ������
		if (exponent > 0) {
			exponent1 = exponent;
		}else if (exponent == 0) {
			return 1;
		}else {
			exponent1 = -exponent;
			if (base == 0) {
				throw new RuntimeException("ָ��Ϊ����ʱ����������Ϊ0");
			}
		}
		// ���ÿ����ݼ���
		// ѭ��
//		while(exponent1 != 0) {
//			if ((exponent1&1) == 1) {
//				result *= cur;
//			}
//			cur *= cur;
//			exponent1 >>= 1;
//		}
		// �ݹ�
		result = quickPower(base, exponent1);		
		return exponent>0?result:1/result;
	}
	public static double quickPower(double base, int exponent1) {
		if (exponent1 == 0) {
			return 1;
		}
		if (exponent1 == 1) {
			return base;
		}
		double result =  quickPower(base, exponent1>>1);
		result *= result;
		if ((exponent1&1) == 1) {
			result *= base;
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(Power(2, 3));
	}
}
