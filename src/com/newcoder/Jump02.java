package com.newcoder;
/**
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n����
 * �����������һ��n����̨���ܹ��ж�����������
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
