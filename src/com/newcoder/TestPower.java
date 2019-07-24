package com.newcoder;

import javax.management.RuntimeErrorException;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @author DELL
 *
 */
public class TestPower {
	public double Power(double base, int exponent) {
		int exponent1;
		double result = 1;
		double curr = base;
		//考虑各种情况
        if (exponent>0) {
			exponent1 = exponent;
		}else if (exponent<0) {
			if (base==0) {
				throw new RuntimeException("分母不能为0");
			}
			exponent1 = -exponent;
		}else { //exponent = 0
			return 1;
		}
        
        //利用快速幂进行计算
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
