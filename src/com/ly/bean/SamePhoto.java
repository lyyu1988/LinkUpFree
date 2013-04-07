package com.ly.bean;

public class SamePhoto
{

	private int[][] p;
	private int i = 0;

	public SamePhoto(int num)
	{
		p = new int[num][2];
	}

	public void add(int x, int y)
	{
		p[i][0] = x;
		p[i][1] = y;
		i++;
	}

	public int[][] getSamePhoto()
	{
		return p;
	}

}
