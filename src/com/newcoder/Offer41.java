package com.newcoder;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Offer41 {
	int count;
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	});
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	public void Insert(Integer num) {
	    // 奇数插入最大堆，偶数插入最小堆
		// 插入最大堆中的数大于最小堆的最小值，则将该数插入最小堆，并将最小堆的最小数插入最大堆。
		count++;
		if ((count & 1) == 1) {
			if (!minHeap.isEmpty() && minHeap.peek() < num) {
				minHeap.offer(num);
				num = minHeap.poll();
			}
			maxHeap.offer(num);
		}else {
			if (!maxHeap.isEmpty() && maxHeap.peek() > num) {
				maxHeap.offer(num);
				num = maxHeap.poll();
			}
			minHeap.offer(num);
		}
    }

    public Double GetMedian() {
    	if ((count & 1) == 1) {
    		if (maxHeap.size() > minHeap.size()) {
				return (double)maxHeap.peek();
			}else {
				return (double)minHeap.peek();
			}
    	}else {
			return ((double)maxHeap.peek()+(double)minHeap.peek())/2;
		}
    }
}
