package com.newcoder;

import java.util.Arrays;

/**
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣�
 * ���е�ż��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
 * @author DELL
 *
 */
public class TestreOrderArray {
	public static int[] reOrderArray(int [] array) {
		if (array==null || array.length == 0) {
			return null;
		}
		int[] array1 = new int[array.length];
	//		System.arraycopy(array, 0, array1, 0, array.length);
	//        System.out.println(Arrays.toString(array1));
	    int i = 0;
	    for(int temp:array) {
	    	if (temp%2==1) {//����
				array1[i] = temp;
				i++;
			}
	    }
	//        System.out.println(Arrays.toString(array));
	    for(int temp:array) {
	    	if (temp%2==0) {//ż��
				array1[i] = temp;
				i++;
			}
	    }
	//        System.out.println(Arrays.toString(array1));
	    System.arraycopy(array1, 0, array, 0, array.length);;
	    return array;
	//        System.out.println(Arrays.toString(array));
	}
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8,9};
		System.out.println(Arrays.toString(reOrderArray(array)));
	}
}
