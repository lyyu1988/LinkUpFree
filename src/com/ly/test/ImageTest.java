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
		ImageIcon image = new ImageIcon("image//1 (1).gif");

		ImageIcon image2 = new ImageIcon("image//1 (1).gif");
		JButton button = new JButton();

		button.setIcon(image);

		button.getIcon();

		JButton button2 = new JButton();
		
		button2.setIcon(image2);

		System.out.println(button.getIcon().toString() == button2.getIcon()
				.toString());

		System.out.println(image.getImage().equals(image2.getImage()));

		
		JFrame frame = new JFrame();

		frame.setBounds(100, 100, 1000, 1000);

		frame.add(button);

		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
