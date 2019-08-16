package com.wh;

import java.util.ArrayDeque;

//��Ŀ���붨��һ�����в�ʵ�ֺ���max�õ�����������ֵ��Ҫ����max��
//push_back��pop_front��ʱ�临�Ӷȶ���O(1)��
// ע����Ҫ��������index
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
			System.out.println("����Ϊ�գ��޷�ɾ��");
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
			throw new RuntimeException("����Ϊ�գ������ֵ");
		}
		return ad_max.getFirst().number;
	}
}
