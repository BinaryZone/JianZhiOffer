package com.wh;

import java.util.ArrayDeque;

//题目：请定义一个队列并实现函数max得到队列里的最大值，要求函数max、
//push_back和pop_front的时间复杂度都是O(1)。
// 注意需要加上索引index
public class Offer59_2 {
	ArrayDeque<InternalData> ad_data = new ArrayDeque<>();
	ArrayDeque<InternalData> ad_max = new ArrayDeque<>();
	private class InternalData{
        int number;
        int index;
        public InternalData(int number,int index) {
            this.number=number;
            this.index=index;
        }
    }
	private int curIndex;
	public void push_back(int number) {
		InternalData curData = new InternalData(number, curIndex);
		ad_data.addLast(curData);
		while(!ad_max.isEmpty() && number > ad_max.getLast().number) {
			ad_max.removeLast();
		}
	}
	public void pop_front() {
		if (ad_data.isEmpty()) {
			System.out.println("队列为空，无法删除");
			return;
		}else {
			InternalData curData = ad_data.removeFirst();
			if (curData.index == ad_max.getFirst().index) {
				ad_max.removeFirst();
			}
		}
	}
	public int max() {
		if (ad_max.isEmpty()) {
			throw new RuntimeException("队列为空，无最大值");
		}
		return ad_max.getFirst().number;
	}
}
