package com.wh;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Offer40 {
	// 1.���ÿ⺯�������㷨���Ӷ�ΪO(nlogn)
	
	// 2.ʹ��partition�����ҳ���k������֣��㷨���Ӷ�ΪO(n)
	public static ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
		ArrayList<Integer> al = new ArrayList<>();
		if (input == null || input.length <= 0 || k > input.length || k <= 0) {
			return al;
		}  
        int low = 0;
        int high = input.length - 1;
        int index = partition(input, low, high);
        while(index != k-1) {
        	if (index < k-1) {
				index = partition(input, index+1, high);
			}else {
				index = partition(input, low, index-1);
			}
        }
        for(int i = 0;i<=k-1;i++) {
        	al.add(input[i]);
        }
        return al;
    }
	public static int partition(int [] array,int low,int high) {
		int x = array[low];
		int i = low;
		int j = high;
		while(i < j) {
			while(array[j] >= x && i < j) {
				j--;
			}
			if (i < j) {
				array[i] = array[j];
				i++;
			}
			while(array[i] <= x && i < j) {
				i++;
			}
			if (i < j) {
				array[j] = array[i];
				j--;
			}
		}
		array[i] = x;
		return i;
	}
	// 3.���ı�����ṹ�����ô����Ĵ���ʽ
	public static ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
		ArrayList<Integer> al = new ArrayList<>();
		if (input == null || input.length <= 0 || k > input.length || k <= 0) {
			return al;
		}
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});
		for(int i = 0;i < input.length;i++) {
			if (maxHeap.size() < k) {
				maxHeap.offer(input[i]);
			}else if (maxHeap.peek() > input[i]) {
				maxHeap.poll();
				maxHeap.offer(input[i]);
			}
		}
		for(Integer i:maxHeap) {
			al.add(i);
		}
		return al;
	}
	public static void main(String[] args) {
		int[] arr = {4,5,1,6,2,7,3,8};
		System.out.println(GetLeastNumbers_Solution2(arr, 4));
	}
}
