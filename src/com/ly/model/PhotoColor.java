package com.ly.model;

import java.awt.Color;

import javax.swing.JButton;

import com.ly.constant.AllConstant;

public class PhotoColor
{

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
		if (position.length != (button.length - 2) * (button[1].length - 2))
			return false;

		int count = 0;
		int[][] p = new int[12][22];

		for (int i = 1; i < button.length - 1; i++)
		{
			for (int j = 1; j < button[i].length - 1; j++)
			{
				switch (position[count])
				{
				case 0:
					p[i][j] = 0;
					button[i][j].setBackground(Color.BLUE);
					break;
				case 1:
					p[i][j] = 1;
					button[i][j].setBackground(Color.RED);
					break;
				case 2:
					p[i][j] = 2;
					button[i][j].setBackground(Color.GREEN);
					break;
				case 3:
					p[i][j] = 3;
					button[i][j].setBackground(Color.YELLOW);
					break;
				case 4:
					p[i][j] = 4;
					button[i][j].setBackground(Color.CYAN);
					break;
				default:
					System.out.println("error");
					break;
				}
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
}
