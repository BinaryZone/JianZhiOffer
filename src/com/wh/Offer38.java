package com.wh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Offer38 {
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        char[] ch = str.toCharArray();
        helper(set, ch, 0);
        res.addAll(set);
        Collections.sort(res);
        return res;
    }
    private static void helper(Set<String> set,char[] ch,int i) {      	
		for(int j = i;j < ch.length;j++) {				
			swap(ch, i, j);
			set.add(new String(ch));
			helper(set, ch, i+1);
			swap(ch, j, i);
		}	
	}
    private static void swap(char[] arr,int i,int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
    
    public static void main(String[] args) {
		ArrayList<String> arrayList = Permutation("abc");
		System.out.println(arrayList);
	}

    public static ArrayList<String> Permutation1(String str) {
        ArrayList<String> arrList = new ArrayList<>();
        if (str != null && str.length() != 0) {
     	   char[] strArr = str.toCharArray();
     	   Permutation1(strArr, 0, arrList);
            Collections.sort(arrList);
        }
        return arrList;
     }
     public static void Permutation1(char[] arr,int i,ArrayList<String> arrList) {
     	if (i==arr.length-1) {
     		arrList.add(new String(arr));
     		
 		}else {
             Set<Character> charSet = new HashSet<>();
 			for(int j=i;j<arr.length;j++) {
         		if (!charSet.contains(arr[j])) {
 					charSet.add(arr[j]);
 	        		swap1(arr, i, j);
 	        		Permutation1(arr, i+1, arrList);
 	        		swap1(arr, j, i);
 				}				
         	}
 		}
 	}
     public static void swap1(char[] arr,int i,int j) {
 		char temp = arr[i];
 		arr[i] = arr[j];
 		arr[j] = temp;
 	}
}
