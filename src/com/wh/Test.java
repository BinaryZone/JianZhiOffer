package com.wh;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
 
/**
 * Ұ�����޵�ʿ
 * @author 
 *
 */
/**
 * ���ݽṹ������ʹ��List����洢code�ڵ���Ϣ
 * @author dell-
 *
 */
public class Test {
	static int N;//N��Ұ�ˣ�N���޵�ʿ
	static int K;//����������K����
	static int count=0;
	static List<code>s=new ArrayList<code>();
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("������Ұ��/����ʿ:");
		N=in.nextInt();
		System.out.println("�����봬�������˵ĸ���:");
		K=in.nextInt();
		code c=new code(N,N,1);//1:������ 0:�����Ұ�
		s.add(c);
		bfs(c);
		System.out.println("count:"+count);
	}
	public static boolean check(List<code>s,code c){//�Ϸ�״̬���ж�
		//1.�����ظ�
		if(!s.isEmpty()){//������Ԫ�أ����к��ظ�Ԫ��
			for(int i=0;i<s.size();i++){
				if(s.get(i).Boat==c.Boat&&s.get(i).leftC==c.leftC&&s.get(i).leftM==c.leftM){
					return false;
				}
			}
		}
		//2.�Ƿ�����m>=c
		if((c.leftM!=0&&c.leftM<c.leftC)){//((N-c.leftM!=0)&&(N-c.leftM<c.leftC))){
			return false;
		}
		if((N-c.leftM!=0)&&(N-c.leftM<N-c.leftC)){
			return false;
		}
		return true;
	}
	/**
	 * ���ѣ����������������
	 */
	
	public static void bfs(code c){
		if(c.leftC==0&&c.leftM==0&&c.Boat==0){
			for(int i=0;i<s.size();i++){
				s.get(i).toGetString();
			}
			count++;
			System.out.println("==============================");
			return;
		}
		/**
		 * �жϴ�������Ұ�˺��޵�ʿ������
		 */
		int k,k1;
		if(c.Boat==1){
			k=c.leftM>=K?K:c.leftM;
			k1=c.leftC>=K?K:c.leftC;
		}
		else{
			k=(N-c.leftM)>=K?K:(N-c.leftM);
			k1=(N-c.leftC)>=K?K:(N-c.leftC);
		}
		/**
		 * ö�ٹ��ӵ��������
		 */
		for(int i=0;i<=k;i++){
			int m=i;//�����޵�ʿ����
			for(int j=0;j<=((K-m)>=k1?k1:(K-m));j++){
				int n=j;//����Ұ������
				int tleftM,tleftC,tflag;
				if(m==0&&n==0) continue;
				code ct;
				if(c.Boat==1){//��ǰ״̬�ǺϷ������������󰶿��Կ����Ұ�
					tflag=0;//m,n�Ǵ��ϵ�Ұ�˺��޵�ʿ
					tleftM=N-((N-c.leftM)+m);//
					tleftC=N-((N-c.leftC)+n);
					ct=new code(tleftM,tleftC,tflag);
					if(check(s,ct)){
						s.add(ct);//�����
						bfs(ct);
						s.remove(ct);//����
					}	
				}else{//�Ұ�-����
					tflag=1;
					tleftM=N-((N-c.leftM)-m);
					tleftC=N-((N-c.leftC)-n);
					ct=new code(tleftM,tleftC,tflag);
					if(check(s,ct)){
						s.add(ct);
						bfs(ct);
						s.remove(ct);
					}							
				}
			}
		}
		return ;
	}	
	
} 
class code{
	int leftM;//���޵�ʿ
	int leftC;//��Ұ��
	int Boat;//����״̬
	public code(int leftM,int leftC,int Boat){
		this.leftC=leftC;
		this.leftM=leftM;
		this.Boat=Boat;
	} 
	public void toGetString(){
		System.out.print("�޵�ʿ��"+this.leftM+" Ұ�ˣ� "+this.leftC+" ���ķ���");
		if(this.Boat==1){
			System.out.println("��-->�Ұ�");
		}else{
			System.out.println("�Ұ�-->��");
		}
	}
}
