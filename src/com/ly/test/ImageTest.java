package com.ly.test;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ImageTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ImageIcon image = new ImageIcon("image//test.jpg");
		JButton button = new JButton(image);
		JFrame frame = new JFrame();

		frame.setBounds(100, 100, 100, 100);

		frame.add(button);

		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
