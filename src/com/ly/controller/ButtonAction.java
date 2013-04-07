package com.ly.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;

import com.ly.bean.MyBean;
import com.ly.bean.SamePhoto;
import com.ly.constant.AllConstant;
import com.ly.model.PhotoColor;
import com.ly.view.MyView;

public class ButtonAction implements ActionListener
{

	private int[] row = new int[2]; // �ð�ť��λ��

	private static int num = 0; // �ڼ��ε����ť

	private static int[] row0 = new int[2]; // ��һ�ε���İ�ť��λ�� row0=-1, cow0=-1;
											// row0Ϊ�У�cow0Ϊ��

	private static JButton temp; // ��һ�ε���İ�ť

	private JButton[][] allButton = MyView.button; // ��ť����

	public static int[][] position = new int[12][22]; // ������ɫλ�õ�����

	private static HashMap<JButton, MyBean> hashButtons; // ÿ����ť����ÿ�������Ƿ��Ѿ��������Ĺ���

	public ButtonAction(int cow, int row)
	{
		this.row[0] = row;
		this.row[1] = cow;
		hashButtons = MyView.hashButtons;
	}

	/**
	 * ��ʼ����ť�Ƿ��߹� ÿ�ν�����Ҫ��ʼ��
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
	 * ��ť����¼�
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
			// System.out.println("click one: row0[0]=" + row0[0] + ",row0[1]="
			// + row0[1]);
		} else
		{
			int[] t = new int[2];
			t[0] = row0[0];
			t[1] = row0[1];

			/*
			 * �ڶ��ε��������жϣ�����ɫ��ȣ��ڽ���
			 */

			if (temp.getIcon().toString().equals(button.getIcon().toString()))
			{
				// System.out.println("equal");
				if ((0 == (row[0] - t[0]) && 1 == Math.abs(row[1] - t[1]))
						|| (0 == (row[1] - t[1]) && 1 == Math
								.abs(row[0] - t[0])) || isGet(t, row))
				{
					temp.setBackground(Color.WHITE);
					temp.setIcon(null);
					button.setBackground(Color.WHITE);
					button.setIcon(null);
					temp.setEnabled(false);
					button.setEnabled(false);
					temp = null;
					AllConstant.position[row0[1]][row0[0]] = -1;
					AllConstant.position[row[1]][row[0]] = -1;
					// System.out.println("row0[0]=" + row0[0] + ",row0[1]="
					// + row0[1] + ",row[0]=" + row[0] + ",row[1]="
					// + row[1]);
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

			/*
			 * �������ж��Ƿ��п��������µ����
			 */

//			SamePhoto[] samePhoto = PhotoColor.getSamePhoto();
//
//			// for (int i = 0; i < samePhoto.length; i++)
//			for (int i = 0; i < samePhoto.length; i++)
//			{
//				int[][] temp = samePhoto[i].getSamePhoto();
//				for (int k = 0; k < temp.length - 1; k++)
//				{
//					for (int j = k + 1; j < temp.length; j++)
//					{
//						if (!allButton[temp[k][0]][temp[k][1]].getBackground()
//								.equals(Color.WHITE)
//								&& !allButton[temp[j][0]][temp[j][1]]
//										.getBackground().equals(Color.WHITE))
//						{
//							int[] t1 = new int[2];
//							int[] t2 = new int[2];
//							t1[0] = temp[k][1];
//							t1[1] = temp[k][0];
//							t2[0] = temp[j][1];
//							t2[1] = temp[j][0];
//							// System.out.println("test��" + temp[k][0] + ","
//							// + temp[k][1] + ",test��" + temp[j][0] + ","
//							// + temp[j][1]);
//							if ((0 == (t1[0] - t2[0]) && 1 == Math.abs(t1[1]
//									- t2[1]))
//									|| (0 == (t1[1] - t2[1]) && 1 == Math
//											.abs(t1[0] - t2[0]))
//									|| isGet(t1, t2))
//							{
//								System.out.println("���������У�" + temp[k][0] + ","
//										+ temp[k][1] + ",���������У�" + temp[j][0]
//										+ "," + temp[j][1]);
//								initButton();
//								return;
//							}
//						}
//						initButton();
//					}
//				}
//			}
		}
//		System.out.println("end");

	}

	/**
	 * �жϸ�λ���Ƿ��Ѿ�����
	 * 
	 * @param a
	 *            ��
	 * @param b
	 *            ��
	 * @return
	 */
	private boolean notOut(int a, int b)
	{
		if (a < 0 || b < 0 || a > 21 || b > 11)
			return false;
		return true;
	}

	/**
	 * �ж�������ť���ܷ񵽴�
	 * 
	 * @param a1
	 *            ��һ�ε���İ�ť��λ��
	 * @param a2
	 *            �ڶ��ε����ť��λ��
	 * @return �����Ƿ���Ե������Ϊ�棬����Ϊ��
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
	 * �жϸı䷽��ʱ��ť����ʾ������
	 * 
	 * @param d1
	 *            ����1
	 * @param d2
	 *            ����2
	 * @return �ı�ķ�����ַ�
	 */

	// private String changeDirection(String d1, String d2)
	// {
	// if (d1 == d2)
	// {
	// return d2;
	// } else
	// return d1 + d2;
	// }

	/**
	 * �����Ƿ���Ե������Ϊ�棬����Ϊ��
	 * 
	 * @param a1
	 *            ��һ�ε����λ��
	 * @param a2
	 *            �ڶ��ε��i��λ��
	 * @param direction1
	 *            �ϴεķ���
	 * @param direction2
	 *            �������ķ���
	 * @param nflag
	 *            �ڼ��ε��øú�����Ĭ��Ϊtrue���ݹ�ʱΪfalse
	 * @param zNum
	 *            �ڼ���ת��
	 * @return ������ť���ܷ񵽴����Ϊtrue
	 */

	private boolean helpIsGet(int[] a1, int[] a2, String direction1,
			String direction2, boolean nflag, int zNum)
	{

		// allButton[a1[1]][a1[0]].setText(changeDirection(direction2, "R"));

		/*
		 * ����������ͬ����ת�ۼ�һ
		 */

		if (direction1 != direction2)
		{
			zNum++;
		}

		/*
		 * �ж�����λ���ܷ񵽴���ת��3�Σ���ʼ��Ϊ��һ��
		 */

		if (zNum < 3)
		{
			if (nflag)
			{
				if (a1[0] == a2[0] && 1 == Math.abs(a2[1] - a1[1]))
				{
					// System.out.println("zNum < 3    U");
					return true;
				} else if (a1[1] == a2[1] && 1 == Math.abs(a2[0] - a1[0]))
				{
					// System.out.println("zNum < 3    R");
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
			// System.out.println("zNum>3");
			return false;
		}

		/*
		 * �ݹ��ж������Ƿ��ܹ��ɹ�
		 */

		if ("L" != direction2
				&& notOut(a1[0] + 1, a1[1])
				&& -1 == AllConstant.position[a1[1]][a1[0] + 1]
				&& "f" == hashButtons.get(allButton[a1[1]][a1[0]]).getResult(
						"R", zNum))
		{
			// System.out.println("R");
			// hashButtons.get(allButton[a1[1]][a1[0]]).setDirection("R", zNum,
			// "t"); �ð�ť���¸�����Ϊת�ۣ�����zNum��һ
			hashButtons.get(allButton[a1[1]][a1[0]]).setDirection("R",
					"R" == direction2 ? zNum : zNum + 1, "t");
			// System.out.println("set ��=" + a1[0] + ",��=" + a1[1] + ",zNum="
			// + zNum + ",direction=R to t");
			a1[0]++;
			// System.out.println("��=" + a1[0] + ",��=" + a1[1] + ",zNum=" +
			// zNum);
			if (helpIsGet(a1, a2, direction2, "R", true, zNum))
			{
				// allButton[a1[1]][a1[0]]
				// .setText(changeDirection(direction2, "R"));
				System.out.println("true,button1=" + a1[0] + "," + a1[1]
						+ ",button2=" + a2[0] + "," + a2[1] + "direction2="
						+ direction2 + ",d=R");
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
			// System.out.println("L");
			// hashButtons.get(allButton[a1[1]][a1[0]]).setDirection("L", zNum,
			// "t");
			hashButtons.get(allButton[a1[1]][a1[0]]).setDirection("L",
					"L" == direction2 ? zNum : zNum + 1, "t");
			// System.out.println("set ��=" + a1[0] + ",��=" + a1[1] + ",zNum="
			// + zNum + ",direction=L to t");
			a1[0]--;
			// System.out.println("��=" + a1[0] + ",��=" + a1[1] + ",zNum=" +
			// zNum);
			if (helpIsGet(a1, a2, direction2, "L", true, zNum))
			{
				// allButton[a1[1]][a1[0]]
				// .setText(changeDirection(direction2, "L"));
				System.out.println("true,button1=" + a1[0] + "," + a1[1]
						+ ",button2=" + a2[0] + "," + a2[1] + "direction2="
						+ direction2 + ",d=L");
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
			// System.out.println("U");
			// hashButtons.get(allButton[a1[1]][a1[0]]).setDirection("U", zNum,
			// "t");
			hashButtons.get(allButton[a1[1]][a1[0]]).setDirection("U",
					"U" == direction2 ? zNum : zNum + 1, "t");
			// System.out.println("set ��=" + a1[0] + ",��=" + a1[1] + ",zNum="
			// + zNum + ",direction=U to t");
			a1[1]--;
			// System.out.println("��=" + a1[0] + ",��=" + a1[1] + ",zNum=" +
			// zNum);
			if (helpIsGet(a1, a2, direction2, "U", true, zNum))
			{
				// allButton[a1[1]][a1[0]]
				// .setText(changeDirection(direction2, "U"));
				System.out.println("true,button1=" + a1[0] + "," + a1[1]
						+ ",button2=" + a2[0] + "," + a2[1] + "direction2="
						+ direction2 + ",d=U");
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
			// System.out.println("D");
			// hashButtons.get(allButton[a1[1]][a1[0]]).setDirection("D", zNum,
			// "t");
			hashButtons.get(allButton[a1[1]][a1[0]]).setDirection("D",
					"D" == direction2 ? zNum : zNum + 1, "t");
			// System.out.println("set ��=" + a1[0] + ",��=" + a1[1] + ",zNum="
			// + zNum + ",direction=D to t");
			a1[1]++;
			// System.out.println("��=" + a1[0] + ",��=" + a1[1] + ",zNum=" +
			// zNum);
			if (helpIsGet(a1, a2, direction2, "D", true, zNum))
			{
				// allButton[a1[1]][a1[0]]
				// .setText(changeDirection(direction2, "D"));
				System.out.println("true,button1=" + a1[0] + "," + a1[1]
						+ ",button2=" + a2[0] + "," + a2[1] + "direction2="
						+ direction2 + ",d=D");
				return true;
			}
			a1[1]--;
		}

		// System.out.println("false    ��=" + a1[0] + ",��=" + a1[1] + ",zNum="
		// + zNum);

		return false;
	}
}
