package com.newcoder;
/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author DELL
 *
 */
public class Offer04 {
	// n次二分查找得出
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
    // 从右上角开始查找
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
