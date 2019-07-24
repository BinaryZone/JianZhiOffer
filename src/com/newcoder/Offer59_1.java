package com.newcoder;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Offer59_1 {
	public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> arr = new ArrayList<>();
        if (num == null || num.length == 0 || size <= 0 || size > num.length) {
			return arr;
		}
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for(int i = 0;i < size - 1;i++) {
        	while(!ad.isEmpty() && num[i] > num[ad.peekLast()]) {
        		ad.removeLast();
        	}
        	ad.addLast(i);
        }
        for(int i = size-1;i < num.length;i++) {
        	while(!ad.isEmpty() && num[i] > num[ad.peekLast()]) {
        		ad.removeLast();
        	}
        	ad.addLast(i);
        	if (i - ad.peekFirst() + 1> size) {
				ad.removeFirst();
			}
        	arr.add(num[ad.peekFirst()]);
        }
        return arr;
    }
}
