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
	// ���1��ģʽ�ڶ���Ϊ��*��
	//       	���ַ���һ����ģʽ��һ��ƥ��
	//				��*����ʾ0���ַ���ģʽ������λ���ַ�����
	//				��*����ʾ1�����߶���ַ����ַ�����һλ��ģʽ����
	//			���ַ���һ����ģʽ��һ����ƥ�䣺
	//				ģʽ������λ���ַ�����
	// ���2��ģʽ�ڶ�����Ϊ��*��
	//			���ַ���һ����ģʽ��һ��ƥ��
	//				�ַ���ģʽ������һλ
	//			���ַ���һ����ģʽ��һ����ƥ��
	//				����false
	public static boolean match(char[] str,int strIndex,char[] pattern,int patternIndex) {
		// �ݹ�ͷ
		if (strIndex == str.length && patternIndex == pattern.length) {
			return true;
		}
		if (strIndex !=  str.length && patternIndex == pattern.length) {
			return false;
		}
		if (patternIndex+1 < pattern.length && pattern[patternIndex+1] == '*') {
			if ((strIndex != str.length && str[strIndex] == pattern[patternIndex]) 
					|| (strIndex != str.length && pattern[patternIndex] == '.')) { // ��һ��strIndex != str.length���ܶ�
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
