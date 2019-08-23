package com.wh;

import java.util.Arrays;

/**
 * ��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�Ҳ��֪��ÿ�������ظ����Ρ�
 * ���ҳ�����������һ���ظ������֡� ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��
 * @author DELL
 *
 */
public class Offer03_1 {
	// ��ϣ��O(n)ʱ�临�Ӷȣ�O(n)�ռ临�Ӷ�
	public boolean duplicate(int numbers[],int length,int [] duplication) {
	    boolean[] k = new boolean[length];
	    for(int i=0;i<length;i++) {
	    	if (k[numbers[i]]==true) {
				duplication[0] = numbers[i];
				return true;
			}
	    	k[numbers[i]] = true;
	    }
	    return false;
    }
	// ������Ŀ�������������ַ��ڶ�Ӧλ���ϡ�
	public boolean duplicate1(int numbers[],int length,int [] duplication) {
		for(int i = 0;i < length;i++) {
			if (numbers[i] != i) {
				if (numbers[numbers[i]] == numbers[i]) {
					duplication[0] = numbers[i];
					return true;
				}
				int temp = numbers[i];
				numbers[i] = numbers[temp];
				numbers[temp] = temp;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[] numbers = {2,1,3,1,4};
		System.out.println(new Offer03_1().duplicate1(numbers, 5, new int[1]));
	}
}
