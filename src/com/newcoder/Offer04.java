package com.newcoder;
/**
 * ��һ����ά�����У�ÿ��һά����ĳ�����ͬ����ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
 * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 * @author DELL
 *
 */
public class Offer04 {
	// n�ζ��ֲ��ҵó�
    public boolean Find(int target, int [][] array) {
        for(int i=0;i<array.length;i++){
            int low = 0;
            int high = array[i].length-1;
            while(low<=high){
                int mid = (low+high)/2;
                if(target>array[i][mid]){
                    low = mid+1;
                }
                else if(target<array[i][mid]){
                    high = mid-1;
                }
                else
                    return true;
            }
        }
        return false;
    }
    // �����Ͻǿ�ʼ����
    public boolean Find1(int target, int [][] array) {
    	int row = 0;
    	int columns = array[0].length - 1;
    	while(row < array.length && columns >= 0) {
    		if (array[row][columns] == target) {
				return true;
			}else if (array[row][columns] > target) {
				columns--;
			}else {
				row++;
			}
    	}
    	return false;
    }
}
