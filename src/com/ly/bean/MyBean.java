package com.ly.bean;

import java.util.HashMap;

public class MyBean
{

	private HashMap<String, String[]> result = new HashMap<>();
	
	/**
	 * 初始化按钮四个方向是否已经走过
	 * @param direction  方向
	 * @param isTrue     该按钮第几个转折是否已经走过
	 */

	public void setDirection(String direction, String[] isTrue)
	{
		result.put(direction, isTrue);
	}
	
	/**
	 * 设置按钮四个方向是否已经走过
	 * @param direction  方向
	 * @param num        第几次转折
	 * @param isTrue     是否已经走过，是为"t"，否为"f"，默认为"f"
	 */

	public void setDirection(String direction, int num, String isTrue)
	{
		result.get(direction)[num] = isTrue;
	}
	
	/**
	 * 获取该方向第几个转折是否已经走过
	 * @param direction   方向
	 * @param num         第几次转折
	 * @return
	 */

	public String getResult(String direction, int num)
	{
		return result.get(direction)[num];
	}

}
