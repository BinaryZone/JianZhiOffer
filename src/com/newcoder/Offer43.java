package com.newcoder;

public class Offer43 {
	// 1.暴力解法
	public static int NumberOf1Between1AndN_Solution1(int n) {
	    int count = 0;
	    for(int i = 1;i <= n;i++) {
	    	int num = i;
	    	while(num != 0) {
	    		if (num % 10 == 1) {
					count++;
				}
	    		num /= 10;
	    	}
	    }
	    return count;
    }
	// 2.根据属性规律，找出各个数位上出现1的次数
	public static int NumberOf1Between1AndN_Solution2(int n) {
		int count = 0;
		for(int i = 1;i <= n;i *= 10) {
			int a = n/i;
			int b = n%i;
			if (a%10 == 0) {
				count += (a/10) * i;
			}else if (a%10 == 1) {
				count += ((a/10)*i)+b+1;
			}else {
				count += (a/10+1)*i;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		System.out.println(NumberOf1Between1AndN_Solution2(123));
	}
}
