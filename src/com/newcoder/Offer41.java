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
	    // �����������ѣ�ż��������С��
		// ���������е���������С�ѵ���Сֵ���򽫸���������С�ѣ�������С�ѵ���С���������ѡ�
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
