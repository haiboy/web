/**
 * ��ˮ������8����ί��֡�
 * �˶�Ա�ɼ���8���ɼ�ȥ��һ����߷֣�ȥ��һ����ͷ�
 * ʣ�µ�����������ƽ���־������÷�
 * ʹ��һά����ʵ�ִ�ֹ��ܡ�
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
	//����һ�����Դ��8��С������
	float fens[]=null;
	int size=8;
	//���캯��
	public Judge()
	{
		fens=new float[size];
		//��ʼ����
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		{
			
			try { 
				for(int i=0;i<fens.length;i++)
				{
				System.out.println("�������"+(i+1)+"���еĳɼ�");
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
	//�õ��˶�Ա�����÷�
	public float lastFen()
	{
		
		//2��ȥ����߷�
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
	//1,ȥ����ͷ֣�Ŀ�ľ����ҵ���ͷֵ��±�
	public int getLowFenIndex()
	{
		//ѡ��
		//��Ϊ��һ�������
		float minFen=fens[0];
		int minIndex=0;
		for(int i=1;i<fens.length;i++)
		{
			if(minFen>fens[i]){
				//�޸���ͷ�
				minFen=fens[i];
				minIndex=i;
			}
		}
		return minIndex;
	}
	//�õ���߷�
	public int getHignFenIndex()
	{
		//ѡ��
		//��Ϊ��һ�������
		float maxFen=fens[0];
		int maxIndex=0;
		for(int i=1;i<fens.length;i++)
		{
			if(maxFen<fens[i]){
				//�޸���߷�
				maxFen=fens[i];
				maxIndex=i;
			}
		}
		return maxIndex;
	}
}