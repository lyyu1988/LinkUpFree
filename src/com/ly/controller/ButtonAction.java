package com.ly.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;

import com.ly.bean.MyBean;
import com.ly.constant.AllConstant;
import com.ly.view.MyView;

public class ButtonAction implements ActionListener
{

	private int[] row = new int[2]; // 该按钮的位置

	private static int num = 0; // 第几次点击按钮

	private static int[] row0 = new int[2]; // 第一次点击的按钮的位置 row0=-1, cow0=-1;
											// row0为行，cow0为列

	private static JButton temp; // 第一次点击的按钮

	private JButton[][] allButton = MyView.button; // 按钮数组

	public static int[][] position = new int[12][22]; // 各个颜色位置的数组

	private static HashMap<JButton, MyBean> hashButtons; // 每个按钮和他每个方向是否已经遍历过的关联

	public ButtonAction(int cow, int row)
	{
		this.row[0] = row;
		this.row[1] = cow;
		hashButtons = MyView.hashButtons;
	}

	/**
	 * 初始化按钮是否走过 每次结束后要初始化
	 */

	private void initButton()
	{
		for (int i = 0; i < allButton.length; i++)
		{
			for (int j = 0; j < allButton[i].length; j++)
			{
				MyBean myBean = new MyBean();
				String[] isTrue1 =
				{ "f", "f", "f", "f", "f" };
				String[] isTrue2 =
				{ "f", "f", "f", "f", "f" };
				String[] isTrue3 =
				{ "f", "f", "f", "f", "f" };
				String[] isTrue4 =
				{ "f", "f", "f", "f", "f" };
				myBean.setDirection("U", isTrue1);
				myBean.setDirection("D", isTrue2);
				myBean.setDirection("L", isTrue3);
				myBean.setDirection("R", isTrue4);
				hashButtons.put(allButton[i][j], myBean);
			}
		}
	}

	/**
	 * 按钮点击事件
	 */

	@Override
	public void actionPerformed(ActionEvent arg0)
	{

		JButton button = (JButton) (arg0.getSource());

		ButtonAction.num++;

		if (1 == ButtonAction.num)
		{
			ButtonAction.temp = button;
			row0[0] = row[0];
			row0[1] = row[1];
			button.setEnabled(false);
			System.out.println("click one: row0[0]=" + row0[0] + ",row0[1]="
					+ row0[1]);
		} else
		{
			int[] t = new int[2];
			t[0] = row0[0];
			t[1] = row0[1];

			/*
			 * 第二次点击后进行判断，若颜色相等，在进入
			 */

			if (temp.getBackground().equals(button.getBackground()))
			{
				if ((0 == (row[0] - t[0]) && 1 == Math.abs(row[1] - t[1]))
						|| (0 == (row[1] - t[1]) && 1 == Math
								.abs(row[0] - t[0])) || isGet(t, row))
				{
					temp.setBackground(Color.WHITE);
					button.setBackground(Color.WHITE);
					temp.setEnabled(false);
					button.setEnabled(false);
					temp = null;
					AllConstant.position[row0[1]][row0[0]] = -1;
					AllConstant.position[row[1]][row[0]] = -1;
					System.out.println("row0[0]=" + row0[0] + ",row0[1]="
							+ row0[1] + ",row[0]=" + row[0] + ",row[1]="
							+ row[1]);
				} else
				{
					temp.setEnabled(true);
					temp = null;
				}
			} else
			{
				temp.setEnabled(true);
				temp = null;
			}
			num = 0;
			row0[0] = -1;
			row0[1] = -1;
			initButton();
		}
		System.out.println("end");
	}

	/**
	 * 判断该位置是否已经出界
	 * 
	 * @param a
	 *            列
	 * @param b
	 *            行
	 * @return
	 */
	private boolean notOut(int a, int b)
	{
		if (a < 0 || b < 0 || a > 21 || b > 11)
			return false;
		return true;
	}

	/**
	 * 判断两个按钮见能否到达
	 * 
	 * @param a1
	 *            第一次点击的按钮的位置
	 * @param a2
	 *            第二次点击按钮的位置
	 * @return 两个是否可以到达，可以为真，否则为假
	 */
	private boolean isGet(int[] a1, int[] a2)
	{

		if (helpIsGet(a1, a2, null, null, false, 0))
		{
			return true;
		}
		return false;
	}

	/**
	 * 两个是否可以到达，可以为真，否则为假
	 * 
	 * @param a1
	 *            第一次点击的位置
	 * @param a2
	 *            第二次点击i的位置
	 * @param direction1
	 *            上次的方向
	 * @param direction2
	 *            接下来的方向
	 * @param nflag
	 *            第几次调用该函数，默认为true，递归时为false
	 * @param zNum
	 *            第几次转折
	 * @return 两个按钮按能否到达，可以为true
	 */

	private boolean helpIsGet(int[] a1, int[] a2, String direction1,
			String direction2, boolean nflag, int zNum)
	{

		/*
		 * 若两个方向不同，则转折加一
		 */

		if (direction1 != direction2)
		{
			zNum++;
		}

		/*
		 * 判断两个位置能否到达，最多转折3次，初始化为第一次
		 */

		if (zNum < 3)
		{
			if (nflag)
			{
				if (a1[0] == a2[0] && 1 == Math.abs(a2[1] - a1[1]))
				{
					System.out.println("zNum < 3    U");
					return true;
				} else if (a1[1] == a2[1] && 1 == Math.abs(a2[0] - a1[0]))
				{
					System.out.println("zNum < 3    R");
					return true;
				}
			}
		} else if (3 == zNum)
		{
			// System.out.println("3 == zNum");
			if (nflag)
			{
				if ("U" == direction2 && a1[0] == a2[0] && 1 == a1[1] - a2[1])
				{
					return true;
				} else if ("D" == direction2 && a1[0] == a2[0]
						&& 1 == a2[1] - a1[1])
				{
					return true;
				} else if ("L" == direction2 && a1[1] == a2[1]
						&& 1 == a1[0] - a2[0])
				{
					return true;
				} else if ("R" == direction2 && a1[1] == a2[1]
						&& 1 == a2[0] - a1[0])
				{
					return true;
				}
			}
		} else
		{
			System.out.println("zNum>3");
			return false;
		}

		/*
		 * 递归判断向右是否能够成功
		 */

		if ("L" != direction2
				&& notOut(a1[0] + 1, a1[1])
				&& -1 == AllConstant.position[a1[1]][a1[0] + 1]
				&& "f" == hashButtons.get(allButton[a1[1]][a1[0]]).getResult(
						"R", zNum))
		{
			System.out.println("R");
			// hashButtons.get(allButton[a1[1]][a1[0]]).setDirection("R", zNum,
			// "t"); 该按钮若下个方向为转折，则需zNum加一
			hashButtons.get(allButton[a1[1]][a1[0]]).setDirection("R",
					"R" == direction2 ? zNum : zNum + 1, "t");
			System.out.println("set 列=" + a1[0] + ",行=" + a1[1] + ",zNum="
					+ zNum + ",direction=R to t");
			a1[0]++;
			System.out.println("列=" + a1[0] + ",行=" + a1[1] + ",zNum=" + zNum);
			if (helpIsGet(a1, a2, direction2, "R", true, zNum))
			{
				// allButton[a1[1] - 1][a1[0] - 1].setBackground(Color.BLACK);
				return true;
			}
			a1[0]--;
		}

		if ("R" != direction2
				&& notOut(a1[0] - 1, a1[1])
				&& -1 == AllConstant.position[a1[1]][a1[0] - 1]
				&& "f" == hashButtons.get(allButton[a1[1]][a1[0]]).getResult(
						"L", zNum))
		{
			System.out.println("L");
			// hashButtons.get(allButton[a1[1]][a1[0]]).setDirection("L", zNum,
			// "t");
			hashButtons.get(allButton[a1[1]][a1[0]]).setDirection("L",
					"L" == direction2 ? zNum : zNum + 1, "t");
			System.out.println("set 列=" + a1[0] + ",行=" + a1[1] + ",zNum="
					+ zNum + ",direction=L to t");
			a1[0]--;
			System.out.println("列=" + a1[0] + ",行=" + a1[1] + ",zNum=" + zNum);
			if (helpIsGet(a1, a2, direction2, "L", true, zNum))
			{
				// allButton[a1[1] - 1][a1[0] - 1].setBackground(Color.BLACK);
				return true;
			}
			a1[0]++;
		}

		if ("D" != direction2
				&& notOut(a1[0], a1[1] - 1)
				&& -1 == AllConstant.position[a1[1] - 1][a1[0]]
				&& "f" == hashButtons.get(allButton[a1[1]][a1[0]]).getResult(
						"U", zNum))
		{
			System.out.println("U");
			// hashButtons.get(allButton[a1[1]][a1[0]]).setDirection("U", zNum,
			// "t");
			hashButtons.get(allButton[a1[1]][a1[0]]).setDirection("U",
					"U" == direction2 ? zNum : zNum + 1, "t");
			System.out.println("set 列=" + a1[0] + ",行=" + a1[1] + ",zNum="
					+ zNum + ",direction=U to t");
			a1[1]--;
			System.out.println("列=" + a1[0] + ",行=" + a1[1] + ",zNum=" + zNum);
			if (helpIsGet(a1, a2, direction2, "U", true, zNum))
			{
				// allButton[a1[1] - 1][a1[0] - 1].setBackground(Color.BLACK);
				return true;
			}
			a1[1]++;
		}

		if ("U" != direction2
				&& notOut(a1[0], a1[1] + 1)
				&& -1 == AllConstant.position[a1[1] + 1][a1[0]]
				&& "f" == hashButtons.get(allButton[a1[1]][a1[0]]).getResult(
						"D", zNum))
		{
			System.out.println("D");
			// hashButtons.get(allButton[a1[1]][a1[0]]).setDirection("D", zNum,
			// "t");
			hashButtons.get(allButton[a1[1]][a1[0]]).setDirection("D",
					"D" == direction2 ? zNum : zNum + 1, "t");
			System.out.println("set 列=" + a1[0] + ",行=" + a1[1] + ",zNum="
					+ zNum + ",direction=D to t");
			a1[1]++;
			System.out.println("列=" + a1[0] + ",行=" + a1[1] + ",zNum=" + zNum);
			if (helpIsGet(a1, a2, direction2, "D", true, zNum))
			{
				// allButton[a1[1] - 1][a1[0] - 1].setBackground(Color.BLACK);
				return true;
			}
			a1[1]--;
		}

		System.out.println("false");

		return false;
	}
}
