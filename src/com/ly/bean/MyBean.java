package com.ly.bean;

import java.util.HashMap;

public class MyBean
{

	private HashMap<String, String[]> result = new HashMap<>();
	
	/**
	 * ��ʼ����ť�ĸ������Ƿ��Ѿ��߹�
	 * @param direction  ����
	 * @param isTrue     �ð�ť�ڼ���ת���Ƿ��Ѿ��߹�
	 */

	public void setDirection(String direction, String[] isTrue)
	{
		result.put(direction, isTrue);
	}
	
	/**
	 * ���ð�ť�ĸ������Ƿ��Ѿ��߹�
	 * @param direction  ����
	 * @param num        �ڼ���ת��
	 * @param isTrue     �Ƿ��Ѿ��߹�����Ϊ"t"����Ϊ"f"��Ĭ��Ϊ"f"
	 */

	public void setDirection(String direction, int num, String isTrue)
	{
		result.get(direction)[num] = isTrue;
	}
	
	/**
	 * ��ȡ�÷���ڼ���ת���Ƿ��Ѿ��߹�
	 * @param direction   ����
	 * @param num         �ڼ���ת��
	 * @return
	 */

	public String getResult(String direction, int num)
	{
		return result.get(direction)[num];
	}

}
