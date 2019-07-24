package com.newcoder;

import java.util.ArrayList;

public class Offer57_2 {
	public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
	       ArrayList<ArrayList<Integer>> al = new ArrayList<>();
	       int ahead = 1;
	       int last = 2;
	       int mid = (sum+1)/2;
	       while(ahead < last && last <= mid) {
	    	   int sum1 = (last-ahead+1)*(ahead+last)/2;
	    	   if (sum1 == sum) {
	    		   ArrayList<Integer> al1 = new ArrayList<>();
	    		   for(int i = ahead;i<=last;i++) {
	    			   al1.add(i);
	    		   }
	    		   al.add(al1);
	    		   last++;
	    	   }else if (sum1 > sum) {
	    		   ahead++;
			   }else {
				   last++;
			   }
	       }
	       return al;
    }
}
