package com.newcoder;
/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author DELL
 *
 */
public class Jump02 {
	public int JumpFloorII(int target) {
        if (target<=0) {
			return -1;
		}
        if (target==1) {
			return 1;
		}
        if (target==2) {
			return 2;
		}
        int result = 0;
        if (target>2) {
        	for(int i=1;i<target;i++) {
        		result += JumpFloorII(i);
        	}
		}
        return result+1;
    }
	
	public int JumpFloorII01(int target) {
		if(target<=0) return -1;
		int result = 1;
		target--;
		while(target != 0) {
			result = result << 1;
			target--;
		}
		return result;
	}
}
