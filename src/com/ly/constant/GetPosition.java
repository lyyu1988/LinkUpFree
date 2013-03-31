package com.ly.constant;

public class GetPosition
{

	private int x;
	private int y;
	GetSize size = new GetSize();

	public GetPosition(int width, int height)
	{
		size.setHeight(height);
		size.setWidth(width);
	}

	public int getX()
	{
		int x = AllConstant.screenWide;
		setX((x - size.getWidth()) / 2);
		return this.x;
	}

	public int getY()
	{
		int y = AllConstant.screenHight;
		setY((y - size.getHeight()) / 2);
		return this.y;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public void setY(int y)
	{
		this.y = y;
	}

}
