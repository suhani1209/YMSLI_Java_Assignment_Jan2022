package com.day5.q6;

public class CustomException extends Exception{
	public CustomException(int num)
	{
		super("Input number cannot be greater than "+num);
	}
}
