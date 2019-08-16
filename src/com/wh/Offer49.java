package com.wh;

import java.util.ArrayList;
import java.util.LinkedList;

public class Offer49 {
	// 1.�����ⷨ���㷨���Ӷȹ����޷�ͨ��
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
	// 2.�ռ任ʱ�䣬����ǰ��ĳ������ɺ���ĳ��������ü��ÿ�������Ƿ��ǳ��������ϵ͵�ʱ�临�Ӷ�
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int GetUglyNumber_Solution1(int index) {
		if (index < 1) {
			return 0;
		}
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		int m2 = 0;
		int m3 = 0;
		int m5 = 0;
		while(list.size() < index) {
			int l1 = 2 * list.get(m2);
			int l2 = 3 * list.get(m3);
			int l3 = 5 * list.get(m5);
			int min = Math.min(l1, Math.min(l2, l3));
			list.add(min);
			if (l1 == list.get(list.size()-1)) {
				m2++;
			}
			if (l2 == list.get(list.size()-1)) {
				m3++;
			}
			if (l3 == list.get(list.size()-1)) {
				m5++;
			}
		}
		return list.get(list.size()-1);
	}
}
