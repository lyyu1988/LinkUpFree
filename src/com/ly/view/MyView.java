package com.ly.view;

import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.ly.bean.MyBean;
import com.ly.constant.GetPosition;
import com.ly.controller.ButtonAction;
import com.ly.model.PhotoColor;
import com.ly.model.PhotoPosition;

public class MyView extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static JButton[][] button;

	public static HashMap<JButton, MyBean> hashButtons = new HashMap<>();

	private void initButton()
	{
		for (int i = 0; i < button.length; i++)
		{
			for (int j = 0; j < button[i].length; j++)
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
				hashButtons.put(button[i][j], myBean);
			}
		}
	}

	public MyView(int width, int height)
	{

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GetPosition position = new GetPosition(width, height);

		this.setBounds(position.getX(), position.getY(), width, height);

		this.setLayout(new GridLayout(10, 20));

		// MyJButton[][] button = new MyJButton[10][20];
		button = new JButton[12][22];

		for (int i = 0; i < button.length; i++)
		{
			for (int j = 0; j < button[i].length; j++)
			{
				if (0 == i || (button.length - 1) == i || 0 == j
						|| (button[i].length - 1) == j)
				{
					button[i][j] = new JButton();
				} else
				{
					button[i][j] = new JButton();
					button[i][j].addActionListener(new ButtonAction(i, j));
					this.add(button[i][j]);
				}
			}
		}

		initButton();

		PhotoPosition photoPosition = new PhotoPosition();

		photoPosition.setPosition(200, 50);

		PhotoColor photoColor = new PhotoColor();

		photoColor.setPhotoColor(photoPosition.getView(), button);

		this.setVisible(true);

	}
}
