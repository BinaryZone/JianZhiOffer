package com.newcoder;

public class Offer58_2 {
	public String LeftRotateString(String str,int n) {
        if (str == null || n < 0) {
			return null;
		}
        if (str.length() == 0) {
			return "";
		}
        char[] s = str.toCharArray();
        reverse(s, 0, s.length - 1);
        reverse(s, 0, s.length - n - 1);
        reverse(s, s.length - n, s.length-1);
        return new String(s);
    }
	public static void reverse(char[] arr,int low,int high) {
		while(low < high) {
			char temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
			low++;
			high--;
		}
	}
}
