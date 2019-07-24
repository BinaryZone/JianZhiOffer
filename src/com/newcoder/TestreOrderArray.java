package com.newcoder;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
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
	    	if (temp%2==1) {//奇数
				array1[i] = temp;
				i++;
			}
	    }
	//        System.out.println(Arrays.toString(array));
	    for(int temp:array) {
	    	if (temp%2==0) {//偶数
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
