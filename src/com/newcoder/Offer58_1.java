package com.newcoder;

import java.util.Deque;
import java.util.LinkedList;

public class Offer58_1 {
	// 1.利用Java的函数，Strig，StringBuilder等
	public static String ReverseSentence(String str) {
        Deque<String> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < str.length();i++) {
        	if (str.charAt(i) != ' ') {
				sb.append(str.charAt(i));
			}else {
				String s = sb.toString();
				stack.push(s);
//				System.out.println(sb);
//				System.out.println(stack);
				sb.delete(0, sb.length());
//				System.out.println(sb);
			}
        }
        stack.push(sb.toString());
//        System.out.println(stack);
        String result1 = "";
        while(!stack.isEmpty()) {
        	result1 += stack.pop();
        	result1 += " ";
        }
        String result = result1.substring(0, result1.length() - 1);
        return result;
    }
	public String ReverseSentence1(String str) {
		char[] arr = str.toCharArray();
		reverse(arr, 0, arr.length-1);
		int startIndex = -1;
		for(int i = 0;i < arr.length;i++) {
			if (arr[i] == ' ') {
				int endIndex = i;
				reverse(arr, startIndex+1, endIndex-1);
				startIndex = endIndex;
			}
		}
		reverse(arr, startIndex+1, arr.length-1);
		return new String(arr);
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
	public static void main(String[] args) {
		String str = "I am a student.";
		System.out.println(ReverseSentence(str));
	}
}
