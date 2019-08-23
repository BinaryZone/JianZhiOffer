package com.wh;

public class Offer21 {
	// 书上原题
    public void reOrderArray(int[] array) {
        if (array == null || array.length == 0) {
			return;
		}
        int i = 0;
        int j = array.length - 1;
        while(i < j) {
        	while(i < j && array[i]%2 == 1) {
        		i++;
        	}
        	while(i < j && array[j]%2 == 0) {
        		j--;
        	}
        	if (i < j) {
        		int temp = array[i];
            	array[i] = array[j];
            	array[j] = temp;
			}        	
        }
    }
    // 牛客变形
    public void reOrderArray1(int[] array) {
    	for(int i = 0;i < array.length;i++) {
    		boolean flag = true;
    		for(int j = 0;j < array.length-1;j++) {
    			if ((array[j] & 1) == 0 && (array[j+1] & 1) == 1) {
    				flag = false;
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
    		}
    		if (flag) {
				break;
			}
    	}
    }
}
