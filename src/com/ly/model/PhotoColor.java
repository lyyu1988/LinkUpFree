package com.ly.model;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.ly.bean.SamePhoto;
import com.ly.constant.AllConstant;

public class PhotoColor
{

	private static SamePhoto[] samePhoto;

	/**
	 * 设置每个按钮的背景色
	 * 
	 * @param position
	 *            颜色位置信息，通过这个来确定每个按钮的颜色
	 * @param button
	 *            按钮数组
	 * @return 是否每个颜色都两两配对
	 */

	public boolean setPhotoColor(int[] position, JButton[][] button)
	{
		int num = (button.length - 2) * (button[1].length - 2);
		if (position.length != num)
			return false;

		int count = 0;
		int[][] p = new int[12][22];

		ImageIcon[][] image = new ImageIcon[12][22];

		samePhoto = new SamePhoto[50];

		int typeCount = num / 50;

		for (int i = 0; i < samePhoto.length; i++)
		{
			samePhoto[i] = new SamePhoto(typeCount);
		}

		for (int i = 1; i < button.length - 1; i++)
		{
			for (int j = 1; j < button[i].length - 1; j++)
			{

				image[i][j] = new ImageIcon("image//1 ("
						+ (position[count] + 1) + ").gif");

				p[i][j] = position[count];

				button[i][j].setIcon(image[i][j]);

				samePhoto[position[count]].add(i, j);

				count++;
			}
		}

		for (int i = 0; i < p[0].length; i++)
		{
			p[0][i] = -1;
			p[11][i] = -1;
		}

		for (int i = 0; i < p.length; i++)
		{
			p[i][0] = -1;
			p[i][21] = -1;
		}

		AllConstant.position = p;

		return true;
	}

	public static SamePhoto[] getSamePhoto()
	{
		return samePhoto;
	}
}