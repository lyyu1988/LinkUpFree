package com.ly.model;

public class PhotoPosition
{
	private int[] view;       //��ɫλ�õ�һά����

	/**
	 * �������ÿ����ť����ɫ
	 * 
	 * @param num
	 *            ���ж��ٸ���ť
	 * @param type
	 *            �ж��������ɫ
	 * @return �����Ƿ�ɹ�
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
	 * ���������е�����Ԫ��
	 * @param l   ����
	 * @param a   ��һ������λ��
	 * @param b   �ڶ�������λ��
	 */

	private void swap(int[] l, int a, int b)
	{
		int temp = l[a];
		l[a] = l[b];
		l[b] = temp;
	}
	
	/**
	 * ��ȡ��ɫλ�õ�һά����
	 * @return   ��ɫ�����һά����
	 */

	public int[] getView()
	{
		return view;
	}
}
