package com.ly.model;

public class PhotoPosition
{
	private int[] view;       //颜色位置的一维数组

	/**
	 * 随机分配每个按钮的颜色
	 * 
	 * @param num
	 *            共有多少个按钮
	 * @param type
	 *            有多少类的颜色
	 * @return 分配是否成功
	 */

	public boolean setPosition(int num, int type)
	{
		if (0 != num % type)
			return false;

		view = new int[num];

		int oneNum = num / type;

		for (int i = 0; i < view.length; i++)
		{
			view[i] = -1;
		}

		int[] temp = new int[num];

		for (int i = 0; i < view.length; i++)
		{
			temp[i] = i;
		}

		int count = 0;

		for (int i = 0; i < type; i++)
		{
			for (int j = 0; j < oneNum; j++)
			{
				int p = (int) (Math.random() * (num - count));

				view[temp[p]] = i;

				swap(temp, p, num - count - 1);

				count++;
			}
		}

		return true;
	}
	
	/**
	 * 交换数组中的两个元素
	 * @param l   数组
	 * @param a   第一个数的位置
	 * @param b   第二个数的位置
	 */

	private void swap(int[] l, int a, int b)
	{
		int temp = l[a];
		l[a] = l[b];
		l[b] = temp;
	}
	
	/**
	 * 获取颜色位置的一维数组
	 * @return   颜色数组的一维数组
	 */

	public int[] getView()
	{
		return view;
	}
}
