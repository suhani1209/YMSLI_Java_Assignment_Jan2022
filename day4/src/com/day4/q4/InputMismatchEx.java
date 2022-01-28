package com.day4.q4;

import java.util.Scanner;
import java.util.InputMismatchException;

public class InputMismatchEx {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		try {
			int n;
			do {
				System.out.println("Please enter a number or enter -1 if you want to quit .");
				n=in.nextInt();
				if(n==-1)
				{
					System.out.println("Exit application..");
					break;
				}
				if(n%2==0)
				{
					System.out.println("You have entered an even number ..");
					
				}else 
				{
					System.out.println("You have entered an odd number ..");
				}
			}while(n!=-1);
		}catch(InputMismatchException ex)
		{
			System.out.println("You must enter an integer ..");
			
		}
	}
}
