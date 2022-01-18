package com.day1.q1;

public class Q1 {
	public static void main(String[] args) {
		int first=1,sec=1;
		System.out.print(first+" "+sec);
		for(int i=0;i<18;i++)
		{
			int c=first+sec;
			System.out.print(" "+c);
			first=sec;
			sec=c;
		}
	}
}
