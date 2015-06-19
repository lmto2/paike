package com.lm.hib;
import com.lm.hib.orm.*;


import java.util.Iterator;

public class TestJava {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hell world");
		TaTrainPro tat=new TaTrainPro();

		tat.setStudyTerm("141502");
		tat.setTrainProName("测试培养方案");
		tat.setTrainProPresent("测试介绍，测试介绍，测试介绍");

		//System.out.println("id:"+myuser.getUserId()+"name:"+myuser.getUserName()+"\n");
		DataService th=new DataService();
		th.insertTrain(tat);
	for(int i = 1;i<100000;i++)
		{
		tat.setStudyTerm("141502");
		tat.setTrainProName("测试培养方案");
		tat.setTrainProPresent("测试介绍，测试介绍，测试介绍");
		th.insertTrain(tat);
		}
		Iterator iterator=th.listTrain().iterator();
		while(iterator.hasNext())
		{
		tat=(TaTrainPro)(iterator.next());
		System.out.println("id:"+tat.getTrainProId()+"  name:"+tat.getTrainProName());
		}
		
		
		
		
	}

}
