package com.newcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Offer45 {
	public String PrintMinNumber(int [] numbers) {
		ArrayList<Integer> al = new ArrayList<>();
		for(Integer i:numbers) {
			al.add(i);
		}
		Collections.sort(al, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				String s1 = o1 + "" + o2;
				String s2 = o2 + "" + o1;
				return s1.compareTo(s2);
			}
		});
		String s = "";
		for(Integer j:al) {
			s += j;
		}
		return s;
    }
}
