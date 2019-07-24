package com.newcoder;

public class Offer20 {
	// 注意 ||的短路特性
	private int index = 0;
	public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
			return false;
		}
        boolean flag = scanInteger(str);
        if (index < str.length && str[index] == '.') {
			index++;
			flag = unsignedScanInteger(str) || flag ;
			System.out.println("小数");
		}
        System.out.println("小数后"+index);
        if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
			index++;
			flag = flag && scanInteger(str);
			System.out.println("指数");
		}
        System.out.println(flag);
        System.out.println(index);
        return flag && index == str.length;
    }
	public boolean scanInteger(char[] str) {
		if (index < str.length && (str[index] == '+' || str[index] == '-')) {
			index++;
		}
		return unsignedScanInteger(str);
	}
	public boolean unsignedScanInteger(char[] str) {
		int start = index;
		while (index < str.length && str[index] >= '0' && str[index] <= '9') {
			index ++;
		}
		return start < index;
	}
	public static void main(String[] args) {
		String s = "123.45e+6";
		char[] str = s.toCharArray();
		System.out.println(new Offer20().isNumeric(str));
	}
}
