package com.newcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class LeetCode871 {
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
    	if (stations.length == 0) {
			return startFuel >= target?0:-1;
		}
    	int rest = startFuel;
    	int addCount = 0;
    	PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2)->o2-o1);
    	ArrayList<int[]> sta = new ArrayList<>();
    	for(int[] link:stations) {
    		sta.add(link);
    	}
    	sta.add(new int[] {target,0});
//    	for(int[] link:sta) {
//    		System.out.println(Arrays.toString(link));
//    	}
        for(int i = 0;i < sta.size();i++) {
        	int distance;
        	if (i == 0) {
        		distance = sta.get(i)[0];
			}else{
				distance = sta.get(i)[0] - sta.get(i-1)[0];
			}
//        	System.out.println(distance);
        	while(distance > rest) {
        		if (maxHeap == null || maxHeap.isEmpty()) {
					return -1;
				}
        		rest += maxHeap.poll();
        		addCount++;
        	}
        	rest -= distance;
        	maxHeap.add(sta.get(i)[1]); 
        }
        return addCount;
    }
    public static void main(String[] args) {
		int[][] stations = {{10,60},{20,30},{30,30},{60,40}};
		System.out.println(minRefuelStops(100, 10, stations));
	}
}
