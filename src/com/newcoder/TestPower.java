package com.newcoder;

import javax.management.RuntimeErrorException;

/**
 * ����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η���
 * @author DELL
 *
 */
public class TestPower {
	public double Power(double base, int exponent) {
		int exponent1;
		double result = 1;
		double curr = base;
		//���Ǹ������
        if (exponent>0) {
			exponent1 = exponent;
		}else if (exponent<0) {
			if (base==0) {
				throw new RuntimeException("��ĸ����Ϊ0");
			}
			exponent1 = -exponent;
		}else { //exponent = 0
			return 1;
		}
        
        //���ÿ����ݽ��м���
        while(exponent1 != 0) {
        	if ((exponent1 & 1) == 1) {
			result *= curr;
		}
        	curr *= curr;
        	exponent1 >>= 1;
        }
        
        return exponent>=0?result:(1/result);
         
	 }
}
