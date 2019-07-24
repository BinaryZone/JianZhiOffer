package com.newcoder;
/**
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� ����һ���Ǽ�����������һ����ת�������ת�������СԪ�ء� 
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1�� NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 * @author DELL
 *
 */
public class Find01 {
	public int minNumberInRotateArray(int [] array) {
		//�������СΪ0������0
		if (array.length == 0) {
			return 0;
		}
		
		//������ָ�룬��ָ���middle
		int left = 0;
		int right = array.length - 1;
		
		int middle = -1;
		while(array[left]>=array[right]) {
			if (right-left==1) {
				middle = right;
				break;
			}
			middle = left + (right - left)/2;
			
			if (array[middle]>=array[left]) {
				left = middle;
			}
			if (array[middle]<=array[right]) {
				right = middle;
			}
		}
		return array[middle];
	}
}
