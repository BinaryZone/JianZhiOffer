package com.newcoder;

import java.util.Arrays;
import java.util.LinkedHashMap;

import javax.naming.InitialContext;

public class Offer50 {
	// 1.算法复杂度有点高
	public static int FirstNotRepeatingChar1(String str) {
        if (str == null || str.length() == 0) {
			return -1;
		}
        int[] flag = new int[str.length()];
        char[] ch = str.toCharArray();
        for(int i = 0;i < ch.length;i++) {
        	if (flag[i] == -1) {
        		continue;
			}
        	boolean f = false;
        	for(int j = i+1;j < ch.length;j++) {
        		if (ch[j] == ch[i]) {
					flag[j] = -1;
					f = true;
				}
        	}
        	System.out.println(f);
        	if (f == false) {
				return i;
			}
        }
        System.out.println(Arrays.toString(flag));
        return -1;
    }
	// 2.利用哈希表
	public static int FirstNotRepeatingChar2(String str) {
        if (str == null || str.length() == 0) {
			return -1;
		}
        LinkedHashMap<Character, Integer> hm = new LinkedHashMap<>();
        char[] c = str.toCharArray();
        for(int i = 0;i < str.length();i++) {
        	if (hm.containsKey(c[i])) {
				hm.put(c[i], hm.get(c[i])+1);
			}else {
				hm.put(c[i], 1);
			}
        }
        for(Character ch:hm.keySet()) {	
        	if (hm.get(ch) == 1) {
				return str.indexOf(ch);
			}
        }
        return -1;
	}
	// 3.手动实现哈希表
	public static int FirstNotRepeatingChar3(String str) {
		if (str == null || str.length() == 0) {
			return -1;
		}
		int[] hash = new int[256];
		for(int i = 0;i < str.length();i++) {
			hash[(int)str.charAt(i)-1]++;
		}
		for(int i = 0;i < str.length();i++) {
			if (hash[(int)str.charAt(i)-1] == 1) {
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		System.out.println(FirstNotRepeatingChar2("google"));
	}
}
