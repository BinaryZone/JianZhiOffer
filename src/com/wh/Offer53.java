package com.wh;

public class Offer53 {
	// 二分法查找的应用
	public int GetNumberOfK(int [] array , int k) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int low = 0;
		int high = array.length - 1;
		int first = binarySearchFirst(array, k, low, high);
		System.out.println(first);
		int last = binarySearchLast(array, k, low, high);
		System.out.println(last);
		return last-first+1;
    }
	public static int binarySearchFirst(int [] array , int k,int low,int high) {
		if (low > high) {
			return -1;
		}
		int mid = (low+high)>>1;
		if (array[mid] > k) {
			return binarySearchFirst(array, k, low, mid - 1);
		}else if (array[mid] < k) {
			return binarySearchFirst(array, k, mid+1, high);
		}else if (mid - 1 >= low && array[mid - 1] == k) {
			return binarySearchFirst(array, k, low, mid - 1);
		}else {
			return mid;
		}
	}
	public static int binarySearchLast(int [] array , int k,int low,int high) {
		int mid = (low+high)>>1;
		while(low <= high) {
			if (array[mid] > k) {
				high = mid - 1;
			}else if (array[mid] < k) {
				low = mid + 1;
			}else if (mid+1 <= high && array[mid + 1] == k) {
				low = mid + 1;
			}else {
				return mid;
			}
			mid = (low+high)>>1;
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] arr = {1,3,3,3,3,4,5};
		System.out.println(new Offer53().GetNumberOfK(arr, 2));
	}
}
