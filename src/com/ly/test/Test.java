package com.ly.test;

import java.util.ArrayList;
import java.util.HashMap;

public class Test
{

	private HashMap<String, String[]> map = new HashMap<>();

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Test t = new Test();
		// int[] a = t.test2();
		// System.out.println(""+a[0]+a[1]);

		// ArrayList<int[][]> t = new ArrayList<int[][]>();
		//
		// int[][] a = new int[10][11];
		// int[][] b = new int[10][11];
		//
		// t.add(a);
		// t.add(b);
		// int[] a = new int[2];
		// a[0] = 1;
		// a[1] = 2;
		// t.test3(a);
		//
		// System.out.println("a[0]=" + a[0] + ",a[1]=" + a[1]);

		String u = "u";
		String[] s = new String[4];

		s[0] = "0";
		s[1] = "1";
		s[2] = "2";
		s[3] = "3";

		t.test4(u, s);

		t.test4("u", 3, "ghe");

		System.out.println(t.getMap().get("u")[3]);

		String[] test =
		{ "t", "f" };

		System.out.println(test[1]);

	}

	public HashMap<String, String[]> getMap()
	{
		return map;
	}

	public void test4(String t, String[] s)
	{
		map.put(t, s);
	}

	public void test4(String t, int num, String s)
	{
		map.get(t)[num] = s;
	}

	public void test3(int[] t)
	{
		t[0] = 10;
		t[1] = 20;
	}

	public int[] test()
	{
		int[] l = new int[2];
		l[0] = 1;
		l[1] = 2;
		swap(l[0], l[1]);
		return l;
	}

	public int[] test2()
	{
		int[] l = new int[2];
		l[0] = 1;
		l[1] = 2;
		swap(l, 0, 1);
		return l;
	}

	private void swap(int a, int b)
	{
		int temp = a;
		a = b;
		b = temp;
		System.out.println("" + a + b);
	}

	private void swap(int[] l, int a, int b)
	{
		int temp = l[a];
		l[a] = l[b];
		l[b] = temp;
	}

}
