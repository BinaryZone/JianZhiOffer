package com.wh;

public class Offer67 {
	// 特殊情况：
	// 字符串为null
	// 字符串为空
	// 字符串包含非数字
	// 字符串包含正负号(仅包含正负号，首位为正负号，非首位有正负号)
	// 数字溢出
	private boolean isValid = true;
	public int StrToInt(String str) {
        if (str == null || str.trim().length() == 0) {
        	isValid = false;
        	
			return 0;
		}
        if (str.trim().length() == 1 && str.charAt(0) == '+' || 
        		str.trim().length() == 1 && str.charAt(0) == '-') {
			isValid = false;
			
			return 0;
		}
        boolean minus = false;
        long num = 0;
        char[] arr = str.toCharArray();
        for(int i = 0;i < arr.length;i++) {
        	if (i == 0 && arr[i] == '+') {
				minus = false;
			}else if (i == 0 && arr[i] == '-') {
				minus = true;
			}else {
				int m = (int)arr[i] - '0';
				if (m < 0 || m > 9) {
					isValid = false;
					System.out.println(1);
					return 0;
				}
				num = (minus == true)?(num*10 - m):(num*10 + m);
				if (!minus && num > 0x7FFFFFFF ||
						minus && num < 0x80000000) {
					isValid = false;
					return 0;
				}
			}
        }
        return (int)num;
    }
	public static void main(String[] args) {
		System.out.println(new Offer67().StrToInt("123"));
//		System.out.println((int)'1');
	}
}
