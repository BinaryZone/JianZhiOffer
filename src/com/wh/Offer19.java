package com.wh;

public class Offer19 {
	public static boolean match(char[] str, char[] pattern)
    {
		if (str == null || pattern == null) {
			return false;
		}
		int strIndex = 0;
		int patternIndex = 0;
		return match(str, strIndex, pattern, patternIndex);
    }
	// 情况1：模式第二个为‘*’
	//       	若字符第一个与模式第一个匹配
	//				‘*’表示0个字符：模式后移两位，字符不变
	//				‘*’表示1个或者多个字符：字符后移一位，模式不变
	//			若字符第一个与模式第一个不匹配：
	//				模式后移两位，字符不变
	// 情况2：模式第二个不为‘*’
	//			若字符第一个与模式第一个匹配
	//				字符与模式都后移一位
	//			若字符第一个与模式第一个不匹配
	//				返回false
	public static boolean match(char[] str,int strIndex,char[] pattern,int patternIndex) {
		// 递归头
		if (strIndex == str.length && patternIndex == pattern.length) {
			return true;
		}
		if (strIndex !=  str.length && patternIndex == pattern.length) {
			return false;
		}
		if (patternIndex+1 < pattern.length && pattern[patternIndex+1] == '*') {
			if ((strIndex != str.length && str[strIndex] == pattern[patternIndex]) 
					|| (strIndex != str.length && pattern[patternIndex] == '.')) { // 后一个strIndex != str.length不能丢
				return match(str, strIndex, pattern, patternIndex+2) || 
						match(str, strIndex+1, pattern, patternIndex);
			}else {
				return match(str, strIndex, pattern, patternIndex+2);
			}
		}
		if ((strIndex < str.length && str[strIndex] == pattern[patternIndex]) 
				|| (patternIndex < pattern.length && pattern[patternIndex] == '.')) {
			return match(str, strIndex+1, pattern, patternIndex+1);
		}
		return false;		
	}
	public static void main(String[] args) {
		char[] str = {'a'};
		char[] pattern = {};
		System.out.println(match(str, pattern));
	}
}
