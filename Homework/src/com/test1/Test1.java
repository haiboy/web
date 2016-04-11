/**
 * 跳水比赛，8个评委打分。
 * 运动员成绩是8个成绩去掉一个最高分，去掉一个最低分
 * 剩下的六个分数的平均分就是最后得分
 * 使用一维数组实现打分功能。
 */
package com.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Judge judge=new Judge();
		System.out.println(judge.lastFen());

	}

}

class Judge
{
	//定义一个可以存放8个小数数组
	float fens[]=null;
	int size=8;
	//构造函数
	public Judge()
	{
		fens=new float[size];
		//初始化。
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		{
			
			try { 
				for(int i=0;i<fens.length;i++)
				{
				System.out.println("请输入第"+(i+1)+"裁判的成绩");
				fens[i]=Float.parseFloat(br.readLine());
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	//得到运动员的最后得分
	public float lastFen()
	{
		
		//2，去掉最高分
		//float lastFen=0;
		float allFen=0;
		int minIndex=this.getLowFenIndex();
		int maxIndex=this.getHignFenIndex();
		for(int i=0;i<fens.length;i++)
		{
			if(i!=minIndex&&i!=maxIndex)
			{
				allFen+=fens[i];
			}
		}
		return allFen/(fens.length-2);	
		
	}
	//1,去掉最低分（目的就是找到最低分的下标
	public int getLowFenIndex()
	{
		//选择法
		//认为第一个是最低
		float minFen=fens[0];
		int minIndex=0;
		for(int i=1;i<fens.length;i++)
		{
			if(minFen>fens[i]){
				//修改最低分
				minFen=fens[i];
				minIndex=i;
			}
		}
		return minIndex;
	}
	//得到最高分
	public int getHignFenIndex()
	{
		//选择法
		//认为第一个是最高
		float maxFen=fens[0];
		int maxIndex=0;
		for(int i=1;i<fens.length;i++)
		{
			if(maxFen<fens[i]){
				//修改最高分
				maxFen=fens[i];
				maxIndex=i;
			}
		}
		return maxIndex;
	}
}