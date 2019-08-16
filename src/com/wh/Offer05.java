package com.wh;
/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @author DELL
 *
 */
public class Offer05 {
	// 从前往后
	public static String replaceSpace1(StringBuffer str) {
    	int i = 0;
    	while(i < str.length()) {
    		if (str.charAt(i) == ' ') {
				str.replace(i, i+1, "%");
				str.insert(i+1, "20");
			}
    		i++;
    	}
    	return str.toString();
    }
	// 从后往前
	public static String replaceSpace2(StringBuffer str) {
		int count = 0;
		for(int i = 0;i < str.length();i++) {
			if (str.charAt(i) == ' ') {
				count++;
			}
		}
		int newLength = count*2 + str.length();
		int p1 = str.length() - 1;
		int p2 = newLength - 1;
		str.setLength(newLength);
		while(p1 >=0 && p2 >= 0) {
			if (str.charAt(p1) == ' ') {
				str.setCharAt(p2--, '0');
				str.setCharAt(p2--, '2');
				str.setCharAt(p2--, '%');
				p1--;
			}else {
				str.setCharAt(p2, str.charAt(p1));
				p1--;
				p2--;
			}
		}
		return str.toString();
	}
	public static void main(String[] args) {
		StringBuffer str = new StringBuffer("We Are Happy");
		System.out.println(str);
		String rs = replaceSpace1(str);
		System.out.println(rs.toString());
	}
	
	
    public String replaceSpace(StringBuffer str) {
    	int spacenum = 0;//spacenum为计算空格数
    	for(int i=0;i<str.length();i++) {
    		if(str.charAt(i)==' ') {
    			spacenum++;
    		}
    	}
    	int indexold = str.length()-1;//替换前str下标
    	int newlength = str.length() + spacenum*2;//替换后str的长度
    	int indexnew = newlength - 1;
    	str.setLength(newlength);
    	for(;indexold>=0 && indexold<newlength;indexold--) {
    		if (str.charAt(indexold)==' ') {
				str.setCharAt(indexnew--, '0');
				str.setCharAt(indexnew--, '2');
				str.setCharAt(indexnew--, '%');
			}else {
				str.setCharAt(indexnew--, str.charAt(indexold));
			}
    	}
    	return str.toString();
    }
}
