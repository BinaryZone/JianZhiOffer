package com.wh;
/**
 * ��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20����
 * ���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 * @author DELL
 *
 */
public class Offer05 {
	// ��ǰ����
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
	// �Ӻ���ǰ
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
    	int spacenum = 0;//spacenumΪ����ո���
    	for(int i=0;i<str.length();i++) {
    		if(str.charAt(i)==' ') {
    			spacenum++;
    		}
    	}
    	int indexold = str.length()-1;//�滻ǰstr�±�
    	int newlength = str.length() + spacenum*2;//�滻��str�ĳ���
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
