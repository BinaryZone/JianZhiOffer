package com.wh;
/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * @author DELL
 *
 */
public class Offer50_1 {
	private int index;
	private int[] occurence;
	public Offer50_1() {
		index = 0;
		occurence = new int[256];
		for(int i = 0;i < 256;i++) {
			occurence[i] = -1;
		}
	}
	public void insert(char ch) {
		if (occurence[(int)ch] == -1) {
			occurence[(int)ch] = index;
		}else {
			occurence[(int)ch] = -2;
		}
		index++;
	}
	public char getFirst() {
		int minIndex = Integer.MAX_VALUE;
		char ch = '#';
		for(int i = 0;i < 256;i++) {
			if (occurence[i] >= 0 && occurence[i] < minIndex) {
				minIndex = occurence[i];
				ch = (char)i;
			}
		}
		return ch;
	}
	public static void main(String[] args) {
		Offer50_1 off = new Offer50_1();
		off.insert('g');
		off.insert('o');
		off.insert('o');
		off.insert('g');
		off.insert('l');
		off.insert('e');
		System.out.println(off.getFirst());
	}
}
