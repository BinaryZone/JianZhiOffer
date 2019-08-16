package com.wh;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
 
/**
 * 野人与修道士
 * @author 
 *
 */
/**
 * 数据结构分析：使用List对象存储code节点信息
 * @author dell-
 *
 */
public class Test {
	static int N;//N个野人，N个修道士
	static int K;//船上至多有K个人
	static int count=0;
	static List<code>s=new ArrayList<code>();
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("请输入野人/传教士:");
		N=in.nextInt();
		System.out.println("请输入船至多载人的个数:");
		K=in.nextInt();
		code c=new code(N,N,1);//1:船在左岸 0:船在右岸
		s.add(c);
		bfs(c);
		System.out.println("count:"+count);
	}
	public static boolean check(List<code>s,code c){//合法状态的判断
		//1.不可重复
		if(!s.isEmpty()){//包含此元素，表中含重复元素
			for(int i=0;i<s.size();i++){
				if(s.get(i).Boat==c.Boat&&s.get(i).leftC==c.leftC&&s.get(i).leftM==c.leftM){
					return false;
				}
			}
		}
		//2.是否满足m>=c
		if((c.leftM!=0&&c.leftM<c.leftC)){//((N-c.leftM!=0)&&(N-c.leftM<c.leftC))){
			return false;
		}
		if((N-c.leftM!=0)&&(N-c.leftM<N-c.leftC)){
			return false;
		}
		return true;
	}
	/**
	 * 深搜：输出所有满足序列
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
		 * 判断船上至多野人和修道士的数量
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
		 * 枚举过河的所有情况
		 */
		for(int i=0;i<=k;i++){
			int m=i;//船上修道士数量
			for(int j=0;j<=((K-m)>=k1?k1:(K-m));j++){
				int n=j;//船上野人数量
				int tleftM,tleftC,tflag;
				if(m==0&&n==0) continue;
				code ct;
				if(c.Boat==1){//当前状态是合法条件，船在左岸可以开往右岸
					tflag=0;//m,n是船上的野人和修道士
					tleftM=N-((N-c.leftM)+m);//
					tleftC=N-((N-c.leftC)+n);
					ct=new code(tleftM,tleftC,tflag);
					if(check(s,ct)){
						s.add(ct);//加入表
						bfs(ct);
						s.remove(ct);//回溯
					}	
				}else{//右岸-》左岸
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
	int leftM;//左岸修道士
	int leftC;//左岸野人
	int Boat;//船的状态
	public code(int leftM,int leftC,int Boat){
		this.leftC=leftC;
		this.leftM=leftM;
		this.Boat=Boat;
	} 
	public void toGetString(){
		System.out.print("修道士："+this.leftM+" 野人： "+this.leftC+" 船的方向：");
		if(this.Boat==1){
			System.out.println("左岸-->右岸");
		}else{
			System.out.println("右岸-->左岸");
		}
	}
}
