package com.wh;
/**
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2����
 * �����������һ��n����̨���ܹ��ж������������Ⱥ����ͬ�㲻ͬ�Ľ������
 * @author DELL
 *
 */
public class Jump {
	public int JumpFloor(int target) {
		if (target==0) {
			return 0;
		}
		int result = 0;
		if (target>0) {
			if (target==1) {
				return 1;
			}
			if (target==2) {
				return 2;
			}
			
			int preNum = 2;
			int prepreNum = 1;
			for(int i=2;i<target;i++) {
				result = preNum + prepreNum;
				prepreNum = preNum;
				preNum = result;
				
			}
			
		}
		return result;
    }
	
	public int JumpFloor01(int target) {
		if (target<=0) {
			return -1;
		}
		int result = 0;
		if (target>0) {
			if (target==1) {
				return 1;
			}
			if (target==2) {
				return 2;
			}
			result = JumpFloor(target-1) + JumpFloor(target-2);
		}
		return result;
    }
}
