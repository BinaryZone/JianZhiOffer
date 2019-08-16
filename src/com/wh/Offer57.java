package com.wh;

import java.util.ArrayList;

public class Offer57 {
	public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		ArrayList<Integer> al = new ArrayList<>();
		if (array == null || array.length < 2) {
			return al;
		}
        int ahead = 0;
        int last = array.length - 1;
        while(ahead < last) {
        	if (array[ahead] + array[last] == sum) {
				al.add(array[ahead]);
				al.add(array[last]);
				break;
			}else if (array[ahead] + array[last] > sum) {
				last--;
			}else {
				ahead++;
			}
        }
        return al;
    }
	public static void main(String[] args) {
		int[] arr = {1,2,4,7,11,15};
		System.out.println(FindNumbersWithSum(arr, 15));
	}
}
