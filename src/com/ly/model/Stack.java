package com.ly.model;

import java.util.ArrayList;

public class Stack
{

	private static ArrayList<int[]> stack = new ArrayList<int[]>();

	private static int num = 0;

	public static void add(int[] data)
	{
		num++;
		stack.add(data);
	}

	public static int[] get()
	{
		if (0 == num)
			return null;
		return stack.get(num - 1);
	}

	public static int[] out()
	{
		if (0 == num)
			return null;
		int[] t = new int[2];
		t = stack.get(num - 1);
		stack.set(num - 1, null);
		num--;
		return t;
	}

}
