package com.newcoder;

import java.util.ArrayList;

public class Offer49 {
	// 1.暴力解法，算法复杂度过大无法通过
	public static int GetUglyNumber_Solution(int index) {
		if (index <= 0) {
			return 0;
		}
        int count = 1;
        int number = 1;
        while(count <= index) {
        	if (isUglyNumber(number)) {
				count++;
			}
        	number++;
        }
        return number-1;
    }
	public static boolean isUglyNumber(int number) {
		while(number%2 == 0) {
			number /= 2;
		}
		while(number%3 == 0) {
			number /= 3;
		}
		while(number%5 == 0) {
			number /= 5;
		}
		return number == 1? true:false;
	}
	// 2.空间换时间，利用前面的丑数生成后面的丑数，不用检测每个整数是否是丑数，大大较低的时间复杂度
	public static int GetUglyNumber_Solution2(int index) {
		if (index <= 0) {
			return 0;
		}
		ArrayList<Integer> al = new ArrayList<>();
		al.add(1);
		int m2 = 0;
		int m3 = 0;
		int m5 = 0;
		while(al.size() < index) {
			int a2 = 2*al.get(m2);
			int a3 = 3*al.get(m3);
			int a5 = 5*al.get(m5);
			int min = Math.min(a2, Math.min(a3, a5));
			al.add(min);
			if(a2 <= al.get(al.size()-1)) {
				m2 ++;
			}
			if(a3 <= al.get(al.size()-1)) {
				m3 ++;
			}
			if(a5 <= al.get(al.size()-1)) {
				m5 ++;
			}
		}
		return al.get(index-1);
	}	
	public static void main(String[] args) {
		System.out.println(GetUglyNumber_Solution2(7));
	}
}
